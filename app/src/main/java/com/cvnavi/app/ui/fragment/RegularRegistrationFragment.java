package com.cvnavi.app.ui.fragment;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.RoutineRegisterBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.CurrencyUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者：wangshy on 17/8/23 16:29
 */

public class RegularRegistrationFragment extends BaseListenerFragment {
    @BindView(R.id.terminalModel)
    TextView terminalModel;
    @BindView(R.id.manufacturerId)
    TextView manufacturerId;
    @BindView(R.id.terminalId)
    TextView terminalId;
    @BindView(R.id.vehicleNo)
    EditText vehicleNo;
    @BindView(R.id.vehicleColor)
    EditText vehicleColor;
    @BindView(R.id.firstIp)
    TextView firstIp;
    @BindView(R.id.firstPort)
    TextView firstPort;
    @BindView(R.id.firstAgreement)
    TextView firstAgreement;
    @BindView(R.id.vin)
    EditText vin;
    @BindView(R.id.provinceId)
    EditText provinceId;
    @BindView(R.id.cityId)
    EditText cityId;
    @BindView(R.id.terminalPhone)
    EditText terminalPhone;
    @BindView(R.id.apn)
    EditText apn;
    @BindView(R.id.secondIp)
    TextView secondIp;
    @BindView(R.id.secondPort)
    TextView secondPort;
    @BindView(R.id.secondAgreement)
    TextView secondAgreement;
    @BindView(R.id.firstState)
    TextView firstState;
    @BindView(R.id.secondState)
    TextView secondState;
    @BindView(R.id.qidong)
    TextView qidong;
    Unbinder unbinder;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {
        if (!AgreementUtils.agreement_4B.equals(code)) {
            return;
        }
        if (null == modelBean)
            return;
        RoutineRegisterBean bean = (RoutineRegisterBean) modelBean.getModel();
        if (null == bean)
            return;
        terminalModel.setText(bean.getTerminalModel());
        manufacturerId.setText(bean.getManufacturerId());
        terminalId.setText(bean.getTerminalId());
        vehicleNo.setText(bean.getVehicleNo());
        vehicleColor.setText(CurrencyUtils.getColorByCode(Integer.parseInt(bean.getVehicleColor())));
        firstIp.setText(bean.getFirstIp());
        firstPort.setText(bean.getFirstPort());
        firstAgreement.setText(bean.getFirstAgreement());
        vin.setText(bean.getVin());
        provinceId.setText(CurrencyUtils.getProvince(Integer.parseInt(bean.getProvinceId())));
        cityId.setText(CurrencyUtils.getCity(Integer.parseInt(bean.getProvinceId()), Integer.parseInt(bean.getCityId())));
        apn.setText(bean.getApn());
        secondIp.setText(bean.getSecondIp());
        secondPort.setText(bean.getSecondPort());
        secondAgreement.setText(bean.getSecondAgreement());
        terminalPhone.setText(bean.getTerminalPhone());
        firstState.setText(bean.getFirstState());
        secondState.setText(bean.getSecondState());
    }

    @Override
    public void sendMsg() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fram_regular_registration_layout;
    }

    @Override
    public void initView() {
        UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4B());
    }

    @Override
    protected void lazyLoad() {

    }


    @OnClick({R.id.qidong, R.id.terminalModel})
    public void onViewClicked() {
        byte[] bytes = new byte[]{(byte) 0xAA, 0x75, 0x4B, 0x00, 0x00, 0x00, 0x02};
        if (!TextUtils.isEmpty(terminalModel.getText())) {
            byte[] terminalModel_byte = TextTransformationUtils.encode(terminalModel.getText().toString().trim(), 16, 0x01, 0X03, 0x10, true);
            bytes = TextTransformationUtils.byteMerger(bytes, terminalModel_byte);
        }
        if (!TextUtils.isEmpty(manufacturerId.getText())) {
            byte[] manufacturerId_byte = TextTransformationUtils.encode(manufacturerId.getText().toString().trim(), 5, 0x01, 0X23, 0x05, true);
            bytes = TextTransformationUtils.byteMerger(bytes, manufacturerId_byte);
        }
        if (!TextUtils.isEmpty(terminalId.getText())) {
            byte[] terminalId_byte = TextTransformationUtils.encode(terminalId.getText().toString().trim(), 7, 0x00, 0XF0, 0x07, true);
            bytes = TextTransformationUtils.byteMerger(bytes, terminalId_byte);
        }

        if (!TextUtils.isEmpty(vehicleNo.getText())) {
            byte[] vehicleNo_byte = TextTransformationUtils.encode(vehicleNo.getText().toString().trim(), 0, 0x01, 0X0f, 0, false);
            bytes = TextTransformationUtils.byteMerger(bytes, vehicleNo_byte);
        }
        if (!TextUtils.isEmpty(vehicleColor.getText())) {
            byte[] vehicleColor_byte = new byte[]{0x01, 0X24, 0x01, Byte.parseByte(String.valueOf(CurrencyUtils.getCodeByColor(vehicleColor.getText().toString().trim())))};
            bytes = TextTransformationUtils.byteMerger(bytes, vehicleColor_byte);
        }
        if (!TextUtils.isEmpty(vin.getText())) {
            byte[] vin_byte = TextTransformationUtils.encode(vin.getText().toString().trim(), 17, 0x01, 0X0E, 0x11, true);
            bytes = TextTransformationUtils.byteMerger(bytes, vin_byte);
        }
        if (!TextUtils.isEmpty(provinceId.getText())) {
            byte[] provinceId_byte = new byte[]{0x01, 0X21, 0x02};
            bytes = TextTransformationUtils.byteMerger(bytes, TextTransformationUtils.byteMerger(provinceId_byte, TextTransformationUtils.shortToByte(Short.parseShort(CurrencyUtils.getProvinceId(provinceId.getText().toString().trim())))));
        }
        if (!TextUtils.isEmpty(cityId.getText())) {
            byte[] cityId_byte = new byte[]{0x01, 0X22, 0x02};
//            bytes = TextTransformationUtils.byteMerger(bytes, TextTransformationUtils.byteMerger(cityId_byte, TextTransformationUtils.shortToByte(Short.parseShort(CurrencyUtils.getCityId(cityId.getText().toString().trim())))));
        }
        if (!TextUtils.isEmpty(terminalPhone.getText())) {
            String str = "0" + terminalPhone.getText().toString().trim();
            byte[] terminalPhone_byte = new byte[]{0x01, 0X17, 0x06,
                    ContentUtils.getByte(ContentUtils.DectoBCD(Integer.parseInt(str.substring(0, 2)))),
                    ContentUtils.getByte(ContentUtils.DectoBCD(Integer.parseInt(str.substring(2, 4)))),
                    ContentUtils.getByte(ContentUtils.DectoBCD(Integer.parseInt(str.substring(4, 6)))),
                    ContentUtils.getByte(ContentUtils.DectoBCD(Integer.parseInt(str.substring(6, 8)))),
                    ContentUtils.getByte(ContentUtils.DectoBCD(Integer.parseInt(str.substring(8, 10)))),
                    ContentUtils.getByte(ContentUtils.DectoBCD(Integer.parseInt(str.substring(10, 12))))};

            bytes = TextTransformationUtils.byteMerger(bytes, terminalPhone_byte);
        }
        if (!TextUtils.isEmpty(apn.getText())) {
            byte[] apn_byte = TextTransformationUtils.encode(apn.getText().toString().trim(), 0, 0x01, 0X13, 0, false);
            bytes = TextTransformationUtils.byteMerger(bytes, apn_byte);
        }
        if (!TextUtils.isEmpty(firstIp.getText())) {
            byte[] firstIp_byte = TextTransformationUtils.encode(firstIp.getText().toString().trim(), 0, 0x01, 0X11, 0, false);
            bytes = TextTransformationUtils.byteMerger(bytes, firstIp_byte);
        }
        if (!TextUtils.isEmpty(firstPort.getText())) {

            byte[] firstPort_byte = new byte[]{0x01, 0X12, 0x04};

            bytes = TextTransformationUtils.byteMerger(bytes, TextTransformationUtils.byteMerger(firstPort_byte, TextTransformationUtils.intToBytes2(Integer.parseInt(firstPort.getText().toString().trim()))));
        }
        if (!TextUtils.isEmpty(firstAgreement.getText())) {

            byte[] firstAgreement_byte = new byte[]{0x11, 0X01, 0x01, Byte.parseByte(firstAgreement.getText().toString().trim())};
            bytes = TextTransformationUtils.byteMerger(bytes, firstAgreement_byte);
        }
        if (!TextUtils.isEmpty(secondIp.getText())) {
            byte[] secondIp_byte = TextTransformationUtils.encode(secondIp.getText().toString().trim(), 0, 0x11, 0X02, 0, false);
            bytes = TextTransformationUtils.byteMerger(bytes, secondIp_byte);
        }
        if (!TextUtils.isEmpty(secondPort.getText())) {
            byte[] secondPort_byte = new byte[]{0x11, 0X03, 0x04};//
            bytes = TextTransformationUtils.byteMerger(bytes, TextTransformationUtils.byteMerger(secondPort_byte, TextTransformationUtils.intToBytes2(Integer.parseInt(secondPort.getText().toString().trim()))));
        }
        if (!TextUtils.isEmpty(firstAgreement.getText())) {
            byte[] secondAgreement_byte = new byte[]{0x11, 0X04, 0x01, Byte.parseByte(firstAgreement.getText().toString().trim())};
            bytes = TextTransformationUtils.byteMerger(bytes, secondAgreement_byte);
        }
        String lin = Integer.toHexString(bytes.length - 6);
        bytes[4] = Integer.valueOf(lin, 16).byteValue();
        byte[] byteslin = new byte[]{0x00};
        if (ContentUtils.getByte(bytes) != 0) {
            byteslin[0] = ContentUtils.getByte(bytes);
        }
        bytes = TextTransformationUtils.byteMerger(bytes, byteslin);
        UIMessageManager.getInstance().send(bytes);
    }
}
