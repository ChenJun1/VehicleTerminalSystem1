package com.cvnavi.app.ui.fragment;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.QueryTerminalBean;
import com.cvnavi.app.bean.SettingTerminalBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.CurrencyUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/23 11:43
 * version:
 * Depict:
 */

public class QuickRegistrationFragment extends BaseListenerFragment {
    @BindView(R.id.terminalModel_tv)
    EditText mTerminalModelTv;
    @BindView(R.id.provinceId_tv)
    EditText mProvinceIdTv;
    @BindView(R.id.manufacturerId_tv)
    EditText mManufacturerIdTv;
    @BindView(R.id.cityId_tv)
    EditText mCityIdTv;
    @BindView(R.id.terminalId_tv)
    EditText mTerminalIdTv;
    @BindView(R.id.terminalPhone_tv)
    EditText mTerminalPhoneTv;
    @BindView(R.id.vehicleNo_tv)
    EditText mVehicleNoTv;
    @BindView(R.id.ownerPhone_tv)
    EditText mOwnerPhoneTv;
    @BindView(R.id.vehicleColor_tv)
    EditText mVehicleColorTv;
    @BindView(R.id.ownerName)
    EditText mOwnerName;
    @BindView(R.id.vin_tv)
    EditText mVinTv;
    @BindView(R.id.registration_tv)
    TextView mRegistrationTv;
    @BindView(R.id.content_tv)
    TextView mContentTv;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {
        if (!AgreementUtils.agreement_3A.equals(code) && !AgreementUtils.agreement_3B.equals(code))
            return;
        if (null == modelBean)
            return;
        if (null == modelBean.getModel())
            return;

        if (null == mProvinceIdTv)
            return;

        if (AgreementUtils.agreement_3A.equals(code)) {
            SettingTerminalBean bean = (SettingTerminalBean) modelBean.getModel();
            setData1(bean);
        }

        if (AgreementUtils.agreement_3B.equals(code)) {
            QueryTerminalBean bean = (QueryTerminalBean) modelBean.getModel();
            if (!TextUtils.isEmpty(bean.getContent()))
                mContentTv.setText(bean.getContent());
        }

    }

    private void setData1(SettingTerminalBean bean) {
        //终端型号
        if (!TextUtils.isEmpty(bean.getTerminalModel()))
            mTerminalModelTv.setText(bean.getTerminalModel());

        //省域ID
        if (!TextUtils.isEmpty(bean.getProvinceId()))
            mProvinceIdTv.setText(CurrencyUtils.getProvince(Integer.valueOf(bean.getProvinceId())));

        //制造商ID
        if (!TextUtils.isEmpty(bean.getManufacturerId()))
            mManufacturerIdTv.setText(bean.getManufacturerId());

        //市县城ID
        if (!TextUtils.isEmpty(bean.getCityId()) && !TextUtils.isEmpty(bean.getProvinceId())) {
            String city = CurrencyUtils.getCity(Integer.valueOf(bean.getProvinceId()), Integer.valueOf(bean.getCityId()));
            mCityIdTv.setText(city);
        }

        //终端ID
        if (!TextUtils.isEmpty(bean.getTerminalId()))
            mTerminalIdTv.setText(bean.getTerminalId());

        //终端手机号
        if (!TextUtils.isEmpty(bean.getTerminalPhone()))
            mTerminalPhoneTv.setText(bean.getTerminalPhone());

        //车牌号码
        if (!TextUtils.isEmpty(bean.getVehicleNo()))
            mVehicleNoTv.setText(bean.getVehicleNo());

        //车主手机号
        if (!TextUtils.isEmpty(bean.getOwnerPhone()))
            mOwnerPhoneTv.setText(bean.getOwnerPhone());

        //车牌颜色
        if (bean.getVehicleColor() > 0) {
            mVehicleColorTv.setText(CurrencyUtils.getColorByCode(bean.getVehicleColor()));
        }

        //车主姓名
        if (!TextUtils.isEmpty(bean.getOwnerName()))
            mOwnerName.setText(bean.getOwnerName());

        //车辆VIN
        if (!TextUtils.isEmpty(bean.getVin()))
            mVinTv.setText(bean.getVin());
    }

    @Override
    public void sendMsg() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fram_quick_registration;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void lazyLoad() {
        ruquest(RequestDataManage.getInstance().getMain_3A());
        ruquest(RequestDataManage.getInstance().getMain_3B());
    }

    /**
     * 发送请求
     *
     * @param bytes
     */
    private void ruquest(byte[] bytes) {
        UIMessageManager.getInstance().send(bytes);
    }

    @OnClick(R.id.registration_tv)
    public void onViewClicked() {
        SettingTerminalBean bean = new SettingTerminalBean();
        bean.setTerminalModel("SVT111");
        bean.setProvinceId("31");
        bean.setManufacturerId("70504");
        bean.setCityId("0000");
        bean.setTerminalId("0003898");
        bean.setTerminalPhone("0" + "15274504455");
        bean.setVehicleNo("沪Q666666");
        bean.setOwnerPhone("0" + "13474507788");
        bean.setVehicleColor(3);
        bean.setOwnerName("当当");
        bean.setVin("SLGV0123456789777");
        byte[] bytes1 = getBytes1(getDataBean());
        ruquest(RequestDataManage.getInstance().getMain_3A_0x(bytes1));
    }

    private SettingTerminalBean getDataBean() {
        SettingTerminalBean bean = new SettingTerminalBean();
        bean.setTerminalModel(mTerminalModelTv.getText().toString().trim());
        if (!TextUtils.isEmpty(mProvinceIdTv.getText())) {
            bean.setProvinceId(CurrencyUtils.getProvinceId(mProvinceIdTv.getText().toString().trim()));
        }
        bean.setManufacturerId(mManufacturerIdTv.getText().toString().trim());
        if (!TextUtils.isEmpty(mCityIdTv.getText())) {
            bean.setCityId(CurrencyUtils.getCityId(bean.getProvinceId(),mCityIdTv.getText().toString().trim()));
        }
        bean.setTerminalId(mTerminalIdTv.getText().toString().trim());
        bean.setTerminalPhone(mTerminalPhoneTv.getText().toString().trim());
        bean.setVehicleNo(mVehicleNoTv.getText().toString().trim());
        bean.setOwnerPhone(mOwnerPhoneTv.getText().toString().trim());
        if (!TextUtils.isEmpty(mVehicleColorTv.getText())) {
            bean.setVehicleColor(CurrencyUtils.getCodeByColor(mVehicleColorTv.getText().toString().trim()));
        }
        bean.setOwnerName(mOwnerName.getText().toString().trim());
        bean.setVin(mVinTv.getText().toString().trim());
        return bean;
    }

    private String getString(String str, String id, int len) {
        String encode = TextTransformationUtils.encode(str);
        int encodelen = encode.length() / 2;
        String lens = Integer.toHexString(len);
        if (len > 0) {
            if (len > encodelen) {
                for (int i = 0; i < len - encodelen; i++) {
                    encode = encode + "00";
                }
            } else if (len < encodelen) {
                LogUtils.e("解析数据错误");
            }
        }
        if (len == 0) {
            len = encodelen;
            lens = Integer.toHexString(len);
        }
        if (lens.trim().length() == 1) {
            lens = "0" + lens;
        }
        //拼接 命令字  长度  数据块
        encode = id + lens + encode;
        return encode;
    }

    // 省市 颜色
    private String intToString(String str, String id, int len) {
        String lens = Integer.toHexString(len);
        if (lens.trim().length() == 1) {
            lens = "0" + lens;
        }
        if (len == 1) { //颜色
            return id + lens + "0" + str;
        }

        if (len > 1) {
            byte[] bytes = TextTransformationUtils.shortToByte(Short.parseShort(str));
            String[] strings = TextTransformationUtils.bytesToHexStrings(bytes);
            return id + lens + strings[0] + strings[1];
        }
        return "";
    }

    // 电话
    private String PhoneToString(String str, String id, int len) {
        StringBuffer sb = new StringBuffer();
        String lens = String.valueOf(len);
        if (len != 0) {
            lens = Integer.toHexString(len);
            if (lens.trim().length() == 1) {
                lens = "0" + lens;
            }
        }
        sb.append(id);
        sb.append(lens);
//        sb.append(ContentUtils.DectoBCD(Integer.valueOf(str.substring(0, 2))));
//        sb.append(ContentUtils.DectoBCD(Integer.valueOf(str.substring(2, 4))));
//        sb.append(ContentUtils.DectoBCD(Integer.valueOf(str.substring(4, 6))));
//        sb.append(ContentUtils.DectoBCD(Integer.valueOf(str.substring(6, 8))));
//        sb.append(ContentUtils.DectoBCD(Integer.valueOf(str.substring(8, 10))));
//        sb.append(ContentUtils.DectoBCD(Integer.valueOf(str.substring(10, 12))));
        if(str.length()==12) {
            sb.append(str.substring(0, 2));
            sb.append(str.substring(2, 4));
            sb.append(str.substring(4, 6));
            sb.append(str.substring(6, 8));
            sb.append(str.substring(8, 10));
            sb.append(str.substring(10, 12));
        }

        return sb.toString();
    }

    private byte[] getBytes1(SettingTerminalBean bean) {
        StringBuffer Datasb = new StringBuffer();
        StringBuffer content = new StringBuffer();
        content.append("AA753A");
        if (!TextUtils.isEmpty(bean.getTerminalModel())) {
            Datasb.append(getString(bean.getTerminalModel(), "0103", 16));
        }
        if (!TextUtils.isEmpty(bean.getManufacturerId())) {
            Datasb.append(getString(bean.getManufacturerId(), "0123", 5));
        }
        if (!TextUtils.isEmpty(bean.getTerminalId())) {
            Datasb.append(getString(bean.getTerminalId(), "00F0", 7));
        }
        if (!TextUtils.isEmpty(bean.getVehicleNo())) {
            Datasb.append(getString(bean.getVehicleNo(), "010F", 0));
        }
        if (bean.getVehicleColor() > 0) {
            Datasb.append(intToString(bean.getVehicleColor() + "", "0124", 1));
        }
        if (!TextUtils.isEmpty(bean.getVin())) {
            Datasb.append(getString(bean.getVin(), "010E", 17));
        }
        if (!TextUtils.isEmpty(bean.getProvinceId())) {
            Datasb.append(intToString(bean.getProvinceId() + "", "0121", 2));
        }
        if (!TextUtils.isEmpty(bean.getCityId())) {
            Datasb.append(intToString(bean.getCityId() + "", "0122", 2));
        }
        if (!TextUtils.isEmpty(bean.getTerminalPhone())) {
            Datasb.append(PhoneToString("0"+bean.getTerminalPhone(), "0117", 6));
        }
        if (!TextUtils.isEmpty(bean.getOwnerPhone())) {
            Datasb.append(PhoneToString("0"+bean.getOwnerPhone(), "0193", 6));
        }
        if (!TextUtils.isEmpty(bean.getOwnerName())) {
            Datasb.append(getString(bean.getOwnerName(), "0194", 0));
        }
        int i = Datasb.length() / 2;
        byte[] bytesLen = TextTransformationUtils.shortToByte((short) i);
        String[] strings = TextTransformationUtils.bytesToHexStrings(bytesLen);
        content.append(strings[0]);
        content.append(strings[1]);
        content.append("00");
        content.append(Datasb);
        content.append("00");
        byte[] bytes = TextTransformationUtils.hexStringToByte(content.toString().toUpperCase());
        LogUtils.d(bytes);
        return bytes;
    }
}
