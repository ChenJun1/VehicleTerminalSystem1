package com.cvnavi.app.commanage;


public interface IListener<M>
{
    void notifyAllActivity(String code, M modelBean);
    void sendMsg();
}

