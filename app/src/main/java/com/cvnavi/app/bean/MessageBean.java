package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/4.
 */

public class MessageBean {

    /**
     * 消息时间
     */
    private String time;

    /**
     * 消息类别
     */
    private String type;

    /**
     * 消息来源
     */
    private String source;

    /**
     * 消息内容
     */
    private String content;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
