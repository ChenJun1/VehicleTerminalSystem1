package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.ThreeAxleBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;

/**
 * Created by zww on 2017/8/15.
 */

public class ThreeAxleAnalysisData extends AnalysisUiData {

    private static ThreeAxleAnalysisData threeAxleAnalysisData;
    private static ThreeAxleBean threeAxleBean = new ThreeAxleBean();
    private static BaseBean baseBean = new BaseBean();

    private ThreeAxleAnalysisData(byte[] datas) {
        super(datas);
    }

    public static ThreeAxleAnalysisData getInstance(byte[] datas) {
        if (threeAxleAnalysisData == null) {
            threeAxleAnalysisData = new ThreeAxleAnalysisData(datas);
        }
        threeAxleAnalysisData.setDatas(datas);
        return threeAxleAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        int state = 0;
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_51;
        short length = TextTransformationUtils.getShort(datas, 3);
        switch (value[6]+value[7]) {
            case "0000":
                //角度查询X轴
                int start = 5;
                int angleXSize = datas[6];
                int angleXSizeStart = start + 2;
                int angleXSizeEnd = start + 1 + angleXSize;
                String angleX = decode(TextTransformationUtils.getGbkValue(value, angleXSizeStart,
                        angleXSize));
                threeAxleBean.setAngleX(angleX);

                //角度查询Y轴
                int angleYSize = datas[angleXSizeEnd + 1];
                int angleYSizeStart = angleXSizeEnd + 2;
                int angleYSizeEnd = angleXSizeEnd + 1 + angleYSize;
                String angleY = decode(TextTransformationUtils.getGbkValue(value,
                        angleYSizeStart, angleYSize));
                threeAxleBean.setAngleY(angleY);

                //角度查询Z轴
                int angleZSize = datas[angleYSizeEnd + 1];
                int angleZSizeStart = angleYSizeEnd + 2;
                int angleZSizeEnd = angleYSizeEnd + 1 + angleZSize;
                String angleZ = decode(TextTransformationUtils.getGbkValue(value,
                        angleZSizeStart, angleZSize));
                threeAxleBean.setAngleZ(angleZ);

                //加速度值查询X
                int accelerationXSize = datas[angleZSizeEnd + 1];
                int accelerationXSizeStart = angleZSizeEnd + 2;
                int accelerationXSizeEnd = angleZSizeEnd + 1 + accelerationXSize;
                String accelerationX = decode(TextTransformationUtils.getGbkValue(value,
                        accelerationXSizeStart, accelerationXSize));
                threeAxleBean.setAccelerationX(accelerationX);

                //加速度值查询Y
                int accelerationYSize = datas[accelerationXSizeEnd + 1];
                int accelerationYSizeStart = accelerationXSizeEnd + 2;
                int accelerationYSizeEnd = accelerationXSizeEnd + 1 + accelerationYSize;
                String accelerationY = decode(TextTransformationUtils.getGbkValue(value,
                        accelerationYSizeStart, accelerationYSize));
                threeAxleBean.setAccelerationY(accelerationY);

                //加速度值查询Z
                int accelerationZSize = datas[accelerationYSizeEnd + 1];
                int accelerationZSizeStart = accelerationYSizeEnd + 2;
                int accelerationZSizeEnd = accelerationYSizeEnd + 1 + accelerationZSize;
                String accelerationZ = decode(TextTransformationUtils.getGbkValue(value,
                        accelerationZSizeStart, accelerationZSize));
                threeAxleBean.setAccelerationZ(accelerationZ);

                //设备状态
                int deviceStateSize = datas[accelerationZSizeEnd + 1];
                int deviceStateSizeStart = accelerationZSizeEnd + 2;
                int deviceStateSizeEnd = accelerationZSizeEnd + 1 + deviceStateSize;
                String deviceState = decode(TextTransformationUtils.getGbkValue(value,
                        deviceStateSizeStart, deviceStateSize));
                threeAxleBean.setDeviceState(deviceState);
                // TODO: 2017/8/15 预留
                //        //陀螺仪查询X
                //        int gyroscopeXSize = datas[deviceStateSizeEnd + 1];
                //        int gyroscopeXSizeStart = deviceStateSizeEnd + 2;
                //        int gyroscopeXSizeEnd = deviceStateSizeEnd + 1 + gyroscopeXSize;
                //        String gyroscopeX = TextTransformationUtils.getValue(value,
                //                gyroscopeXSizeStart, gyroscopeXSize);
                //        threeAxleBean.setGyroscopeX(gyroscopeX);
                //
                //        //陀螺仪查询Y
                //        int gyroscopeYSize = datas[gyroscopeXSizeEnd + 1];
                //        int gyroscopeYSizeStart = gyroscopeXSizeEnd + 2;
                //        int gyroscopeYSizeEnd = gyroscopeXSizeEnd + 1 + gyroscopeYSize;
                //        String gyroscopeY = TextTransformationUtils.getValue(value,
                //                gyroscopeYSizeStart, gyroscopeYSize);
                //        threeAxleBean.setGyroscopeY(gyroscopeY);
                //
                //        //陀螺仪查询Z
                //        int gyroscopeZSize = datas[gyroscopeYSizeEnd + 1];
                //        int gyroscopeZSizeStart = gyroscopeYSizeEnd + 2;
                //        int gyroscopeZSizeEnd = gyroscopeYSizeEnd + 1 + gyroscopeZSize;
                //        String gyroscopeZ = TextTransformationUtils.getValue(value,
                //                gyroscopeZSizeStart, gyroscopeZSize);
                //        threeAxleBean.setGyroscopeZ(gyroscopeZ);
                //
                //        //陀螺仪设备状态
                //        int gyroscopeStateSize = datas[gyroscopeZSizeEnd + 1];
                //        int gyroscopeStateSizeStart = gyroscopeZSizeEnd + 2;
                //        int gyroscopeStateSizeEnd = gyroscopeZSizeEnd + 1 + gyroscopeStateSize;
                //        String gyroscopeState = TextTransformationUtils.getValue(value,
                //                gyroscopeStateSizeStart, gyroscopeStateSize);
                //        threeAxleBean.setGyroscopeState(gyroscopeState);
                break;
            case "0001":
                state=1;
                break;
        }
        threeAxleBean.setState(state);
        baseBean.setModel(threeAxleBean);
        ListenerManager.getInstance().
                sendBroadCast(baseBean, code);
    }
}
