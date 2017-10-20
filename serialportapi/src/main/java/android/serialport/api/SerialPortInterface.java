package android.serialport.api;

/**
 * @ProjectName: SerialPortJNI
 * @PackageName: android.serialport.api
 * @Description:
 * @Author: xug
 * @Date: 2017/7/5 13:57
 **/
public interface SerialPortInterface {
    public void start();

    public void send(byte[] sendData);

    public byte[] receive();

    public void close();

    public boolean isRun();

}
