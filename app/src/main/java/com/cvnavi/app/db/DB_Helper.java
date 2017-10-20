package com.cvnavi.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zww on 2017/8/4.
 */
public class DB_Helper extends SQLiteOpenHelper {

    private static DB_Helper helper;

    private DB_Helper(Context context) {
        super(context, DBConstants.DBNAME, null, DBConstants.DBVERSION);
    }

    public static DB_Helper getInstance(Context context) {
        if (helper == null) {
            synchronized (DB_Helper.class) {
                if (helper == null)
                    helper = new DB_Helper(context);
            }
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_Message);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    /**
     * 创建服务器
     */
    String create_Message = "create table " + DBConstants.TB_MESSAGE + " ("
            + DBConstants._ID + " integer primary key autoincrement,"
            + DBConstants.MESSAGE_TIME + " varchar(20) unique,"
            + DBConstants.MESSAGE_TYPE + " varchar(20),"
            + DBConstants.MESSAGE_SOURCE + " varchar(20),"
            + DBConstants.MESSAGE_CONENT + " varchar(200)  not null)";

}
