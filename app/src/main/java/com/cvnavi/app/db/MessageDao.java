package com.cvnavi.app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cvnavi.app.bean.MessageBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zww on 2017/8/4.
 */
public class MessageDao {

    private DB_Helper helper;

    public MessageDao(Context context) {
        helper = DB_Helper.getInstance(context);
    }

    public void closeDataBase() {
        helper.close();
    }

    public boolean insert(MessageBean messageBean) {
        SQLiteDatabase db = helper.getWritableDatabase();
        long insertResult;
        ArrayList<String> errorList = new ArrayList<>();
        ContentValues values = new ContentValues();
        values.put(DBConstants.MESSAGE_TIME, messageBean.getTime());
        values.put(DBConstants.MESSAGE_TYPE, messageBean.getType());
        values.put(DBConstants.MESSAGE_SOURCE, messageBean.getSource());
        values.put(DBConstants.MESSAGE_CONENT, messageBean.getContent());
        insertResult = db.insert(DBConstants.TB_MESSAGE, null, values);
        if (insertResult == 0)
            errorList.add(messageBean.getTime()+"遗漏");
        return errorList.size() == 0;
    }


    public List<MessageBean> query() {
        List<MessageBean> list = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from message where id>?",
                new String[]{"0"});
        if (cursor != null) {
            list = new ArrayList<>();
            while (cursor.moveToNext()) {
                MessageBean messageBean = new MessageBean();
                messageBean.setTime(cursor.getString(1));
                messageBean.setType(cursor.getString(2));
                messageBean.setSource(cursor.getString(3));
                messageBean.setContent(cursor.getString(4));
                list.add(messageBean);
            }
            cursor.close();
        }
        return list;
    }

}
