package com.cvnavi.app.bean;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/6 13:13
 * version:
 * Depict:
 */

public class UpgradeBean {
    private String serverAddress; //服务器地址
    private String ServerPort;     //服务器端口
    private String accountame;     //账号名
    private String ServerAPN;     //服务器APN
    private String DownloadStatus;     //下载状态

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getServerPort() {
        return ServerPort;
    }

    public void setServerPort(String serverPort) {
        ServerPort = serverPort;
    }

    public String getAccountame() {
        return accountame;
    }

    public void setAccountame(String accountame) {
        this.accountame = accountame;
    }

    public String getServerAPN() {
        return ServerAPN;
    }

    public void setServerAPN(String serverAPN) {
        ServerAPN = serverAPN;
    }

    public String getDownloadStatus() {
        return DownloadStatus;
    }

    public void setDownloadStatus(String downloadStatus) {
        DownloadStatus = downloadStatus;
    }
}
