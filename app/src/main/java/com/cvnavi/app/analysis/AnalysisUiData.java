package com.cvnavi.app.analysis;

/**
 * Created by zww on 2017/7/31.
 * 数据解析发送到ui
 */

abstract class AnalysisUiData {

    byte[] datas;


    AnalysisUiData(byte[] datas) {
        this.datas = datas;
    }
}
