package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.VehicleInformationBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/21.
 * 车辆基本信息
 */

public class VehicleInformationAnalysisData extends AnalysisUiData {

    private static VehicleInformationAnalysisData vehicleInformationAnalysisData;
    private static VehicleInformationBean vehicleInformationBean = new VehicleInformationBean();
    private static BaseBean baseBean = new BaseBean();

    private VehicleInformationAnalysisData(byte[] datas) {
        super(datas);
    }

    public static VehicleInformationAnalysisData getInstance(byte[] datas) {
        if (vehicleInformationAnalysisData == null) {
            vehicleInformationAnalysisData = new VehicleInformationAnalysisData(datas);
        }
        vehicleInformationAnalysisData.setDatas(datas);
        return vehicleInformationAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_26;
        short length = TextTransformationUtils.getShort(datas, 3);
        //终端ID
        String id= TextTransformationUtils.getGbkValue(value, 6, 20);
        vehicleInformationBean.setId(id);

        //vin
        String vin=TextTransformationUtils.getGbkValue(value, 26, 20);
        vehicleInformationBean.setVin(vin);

        //sim
        String sim=TextTransformationUtils.getGbkValue(value, 46, 20);
        vehicleInformationBean.setSim(sim);

        //车牌号
        String vehicleNo=decode(getGbkValue(value, 66, 20));
        vehicleInformationBean.setVehicleNo(vehicleNo);

        //发动机号
        String engineNumber=decode(getGbkValue(value, 86, 20));
        vehicleInformationBean.setEngineNumber(engineNumber);

        //车型
        String models=decode(getGbkValue(value, 106, 20));
        vehicleInformationBean.setModels(models);

        baseBean.setModel(vehicleInformationBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
