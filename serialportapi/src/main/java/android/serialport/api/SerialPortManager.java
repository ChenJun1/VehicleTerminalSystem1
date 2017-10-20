package android.serialport.api;

import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ProjectName: SerialPortJNI
 * @PackageName: android.serialport.api
 * @Description:
 * @Author: xug
 * @Date: 2017/7/5 13:25
 **/
public class SerialPortManager implements SerialPortInterface{
    private static SerialPortManager serialPortManager = null;
	private String portName = "/dev/ttyS1"; // A20
//	private String portName = "/dev/ttymxc4"; // J7
	private final static int SERIAL_BAUD = 38400;
	private final static int BUFFER_SIZE = 1024;
	//private final static int MAX_COUNT_PROTOCOL_DATA = (BUFFER_SIZE * 64) + 7;



	private InputStream inputStream;
	private OutputStream outputStream;

	private SerialPort serialPort;
	private boolean isRun = false;


	private LinkedBlockingQueue<byte[]> receiveQueue;
	private LinkedBlockingQueue<byte[]> sendQueue;



    public static  synchronized SerialPortManager getInstance(){
        if(null == serialPortManager)
            serialPortManager = new SerialPortManager();
        return serialPortManager;
    }


	@Override
	public void start() {
		if (isRun){
			return;
		}

		if (TextUtils.isEmpty(portName)) {
			LogUtils.e(" uart postName is null");
			return;
		}

		try {
			serialPort = new SerialPort(new File(portName), SERIAL_BAUD, 0);

		} catch (IOException e) {
			LogUtils.e("uart serialPort get error",e);
			serialPort = null;
			return;
		}

		if (null == serialPort) {
			LogUtils.e("uart serialPort get error...........");
			return;
		}

		inputStream = serialPort.getInputStream();
		outputStream = serialPort.getOutputStream();

		LogUtils.i("uart start sucess......");


		receiveQueue = new LinkedBlockingQueue<byte[]>();
        sendQueue = new LinkedBlockingQueue<byte[]>();

		new Thread(new ReceiveRunnable()).start();
		new Thread(new SendRunnable()).start();

	}

	@Override
	public void send(byte[] sendData) {
		if ((null != sendQueue) && (null != sendData)) {
			sendQueue.offer(sendData);
		}else {
			LogUtils.i("serialPort send failed.....");
		}
	}

	@Override
	public byte[] receive() {
		if ((null != receiveQueue) && isRun()){
			return receiveQueue.poll();
		}else {
			LogUtils.i("serialPort not opend.....");
			return null;
		}

	}

	@Override
	public void close() {
		if (null!=serialPort){
			serialPort.close();
			serialPort = null;
			receiveQueue.clear();
			sendQueue.clear();
            isRun = false;
		}
	}

	@Override
	public boolean isRun() {
		return isRun;
	}



    private class ReceiveRunnable implements Runnable {


		@Override
		public void run() {

			LogUtils.i("uart receive from uart start......");
            isRun = true;
			while (isRun) {

                if (null == receiveQueue || null == serialPort){
                    continue;
                }

				try {
					byte[] receiveBuffer = new byte[BUFFER_SIZE];
                    int ret = 0;
                    try {
                        ret = inputStream.read(receiveBuffer);

                        Thread.sleep(500);
                    } catch (IOException e) {
                        ret = 0;
                        LogUtils.i("serial port read failed ...............");
                        e.printStackTrace();
                    }

                    if (ret > 0) {
						byte[] tmpBuffer = new byte[ret];
						System.arraycopy(receiveBuffer, 0, tmpBuffer, 0, ret);
                        receiveQueue.offer(tmpBuffer);
					} else {
						Thread.sleep(500);
					}

				} catch (InterruptedException e) {
					LogUtils.i(e.getMessage());
				}
			}
			close();
			LogUtils.i("uart receive from uart stop......");
		}
	}

	private class SendRunnable implements Runnable {

        @Override
        public void run() {

			while (!isRun);

            while (isRun){


                if (null == sendQueue || sendQueue.isEmpty()){
					continue;
				}


                byte[] sendByte = sendQueue.poll();
                try {
                    outputStream.write(sendByte);
                    Thread.sleep(1000); // 发送延时

                } catch (IOException e) {
                    LogUtils.i("serial port write failed ..........");
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            LogUtils.i("Thread uart send stop......");
            close();

        }
    }

}
