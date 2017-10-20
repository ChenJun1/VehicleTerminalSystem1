package android.serialport.api;

import com.apkfuns.logutils.LogUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xug on 2017/7/7.
 */

public class SerialPortDataHandler {

    private static SerialPortDataHandler serialPortDataHandler;
    private String TAG = getClass().getSimpleName();
    private SerialPortManager commPortManager = null;

    private LinkedBlockingQueue<byte[]> receiveDataQueue;
    //private LinkedBlockingQueue<byte[]> sendDataQueue;
    private final static int MAX_COUNT_PROTOCOL_DATA = (1024 * 64) + 7;

    public SerialPortDataHandler() {

        this.commPortManager = SerialPortManager.getInstance();

        receiveDataQueue = new LinkedBlockingQueue<byte[]>();
        //sendDataQueue = new LinkedBlockingQueue(byte[]);

    }


    public static SerialPortDataHandler getInstance() {
        if (serialPortDataHandler == null) {
            synchronized (SerialPortDataHandler.class) {
                if (serialPortDataHandler == null) {
                    serialPortDataHandler = new SerialPortDataHandler();
                }
            }
        }
        return serialPortDataHandler;
    }




    public void start() throws IOException {
        if (isRun()) {
            return;
        }

        if (commPortManager == null) {
            throw new IOException("communication channel is null");
        }


        commPortManager.start();

        //new Thread(new SendDataRunnable()).start(); //发送数据线程
        new Thread(new ReceiveDataRunnable()).start(); //接收数据线程


    }

    public void close() {
        commPortManager.close();

        receiveDataQueue.clear();
        //sendDataQueue.clear();
    }

    public void send(byte[] bytesSend) {

        if ((null != bytesSend) && (null != commPortManager)) {
            commPortManager.send(bytesSend);
        }
    }

    public byte[] receive() {
        if (null != receiveDataQueue) {
            return receiveDataQueue.poll();
        }else {
            return null;
        }
    }

    public boolean isRun() {
        if ((null != commPortManager)){
            return commPortManager.isRun();
        }else {
            return false;
        }

    }




    private class ReceiveDataRunnable implements Runnable {

        private String protocolHead = new String(new byte[]{(byte) 0x55, (byte) 0x7A});
        private byte[] fullProtocolData = new byte[MAX_COUNT_PROTOCOL_DATA];


        private int  IsFullProtocol(byte[] bytes, byte[] recBuffer, int count) {
            if ((null == bytes) || (null == recBuffer)){
                count = 0;
                return count;
            }

            if (5 > bytes.length){

                return count;
            }

            int dataLen = ((((bytes[3]) << 8) | (bytes[4]) & 0xFF) + 7);

            if (count >= dataLen && dataLen > 0) {
                byte[] tmpBuff = new byte[dataLen];
                if((tmpBuff!= null)){
                    System.arraycopy(bytes, 0, tmpBuff, 0, dataLen);
                }else {
                    return 0;
                }

                receiveDataQueue.offer(tmpBuff);
                int iCount = count - dataLen;

                if (iCount > 0) {
                    int iTmp = (recBuffer.length-(iCount));
                    if ((byte)0x55 == recBuffer[iTmp]){
                        System.arraycopy(recBuffer, iTmp, bytes, 0, iCount);
                        count = iCount;
                    }else {
                        count = 0;
                    }
                }else {
                    count = 0;
                }
            }
            return count;
        }

        @Override
        public void run() {

            int proCount = 0;
            while (!isRun());
            LogUtils.i(" Handler uart data start ..............");
            while (isRun()) {

                byte[] recBuffer = commPortManager.receive();

                if (null == recBuffer) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                String strRecBuff = null;
                try {
                    strRecBuff = new String(recBuffer,"US-ASCII");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                int buffLength = strRecBuff.length();
                int lengthCount = 0;
                int pos = -1;

                List<Integer> listPos = new LinkedList<>();

                while (buffLength >= lengthCount) {
                    pos = strRecBuff.indexOf(protocolHead, lengthCount);
                    if (0 > pos) {
                        break;
                    }

                    listPos.add(pos);
                    lengthCount = pos + 2;

                }
                int size = listPos.size();
                if (0 == size) {
                    if (0 != proCount) {
                        System.arraycopy(recBuffer, 0, fullProtocolData, proCount, buffLength);
                        proCount += buffLength;
                        proCount = IsFullProtocol(fullProtocolData, recBuffer, proCount);
                    }
                    continue;
                }


                if (1 == size) {
                    int position = listPos.get(0);
                    if (0 == position && 0 != proCount){
                        proCount = 0;

                    }
                    if (0 != position && 0 != proCount) {
                        System.arraycopy(recBuffer, 0, fullProtocolData, proCount, position);
                        IsFullProtocol(fullProtocolData,recBuffer,proCount+position);
                        proCount = 0;
                    }

                    System.arraycopy(recBuffer, position, fullProtocolData, proCount, buffLength - position);
                    proCount = buffLength - position;
                    proCount = IsFullProtocol(fullProtocolData,recBuffer,proCount);
                    continue;

                }

                {
                    int position = listPos.get(0);

                    if (0 != (proCount + position)) {
                        System.arraycopy(recBuffer, 0, fullProtocolData, proCount, position);
                        IsFullProtocol(fullProtocolData,recBuffer,proCount + position);
                        proCount = 0;
                    }

                }

                {
                    int position = listPos.get(size - 1);
                    System.arraycopy(recBuffer, listPos.get(size - 1),
                            fullProtocolData, proCount, buffLength - position);
                    proCount += buffLength - position;
                    proCount = IsFullProtocol(fullProtocolData, recBuffer, proCount);
                }

                for (int i = 0; i < (size - 1); i++) {
                    int dataLen = listPos.get(i + 1) - listPos.get(i);
                    byte[] tmpBuff = new byte[dataLen];
                    System.arraycopy(recBuffer, listPos.get(i), tmpBuff, 0, dataLen);
                    IsFullProtocol(tmpBuff,tmpBuff,dataLen);
                }
            }
            LogUtils.i(" Handler Thread is closed...............");
            close();
        }
    }
}

