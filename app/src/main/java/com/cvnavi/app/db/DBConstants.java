package com.cvnavi.app.db;

/**
 * 数据库变量储存接口
 * Created by zww on 2017/8/4.
 */
public interface DBConstants {


    /**
     * 数据库名称
     */
    String DBNAME = "cvnavi";

    /**
     * 数据库版本
     */
    int DBVERSION = 1;


    /**
     * 批注数据表名
     */
    String TB_MESSAGE = "message";
    /**
     * 主键
     */
    String _ID = "id";
    /**
     * 时间
     */
    String MESSAGE_TIME = "time";
    /**
     * 消息类型
     */
    String MESSAGE_TYPE = "type";
    /**
     * 消息来源
     */
    String MESSAGE_SOURCE = "source";
    /**
     * 消息内容
     */
    String MESSAGE_CONENT = "conent";


}
