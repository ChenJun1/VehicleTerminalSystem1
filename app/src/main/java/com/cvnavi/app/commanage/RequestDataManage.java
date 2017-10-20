package com.cvnavi.app.commanage;


import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/10 10:17
 * version: 1.0
 * Depict: 首页数据请求字管理
 */

public class RequestDataManage implements RequestDataManageInf {
    private volatile static RequestDataManage INSTANCE;

    byte[] bytes = null;

    private RequestDataManage() {
    }


    public static RequestDataManage getInstance() {
        if (INSTANCE == null) {
            synchronized (RequestDataManage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RequestDataManage();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 主页显示 0x41 byte[]{AA,75,41,00,01,00,01,}
     *
     * @return
     */
    @Override
    public byte[] getMain_41() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x41, 0x00, 0x01, 0x00, 0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 主页状态条显示 0x47 byte[]{AA,75,47,00,01,00,01,}
     *
     * @return
     */
    @Override
    public byte[] getMain_47() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x47, 0x00, 0x01, 0x00, 0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 主页 驾驶行为评分 0x57 byte[]{0xAA, 0x75, 0x57, 0x00, 0x02, 0x00, 0x00, 0x00, 0}
     *
     * @return
     */
    @Override
    public byte[] getMain_57_00() {

        bytes = new byte[]{(byte) 0xAA, 0x75, 0x57, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 主页 驾驶行为评分 0x57 byte[]{0xAA, 0x75, 0x57, 0x00, 0x14, 0x00, 0x00, 0x01}
     *
     * @param dataTime [00 00] 查询 /应答实时分值显示数据
     *                 [00 01]  查询 /应答历史数据
     *                 [00 02]  查询 /应答 MAPMAPMAP数据
     *                 [00 03]  应答历史数据的汇总信息
     * @return
     */
    @Override
    public byte[] getMain_57_01(int[] dataTime) {
        if (dataTime != null && dataTime.length > 5) {

            bytes = new byte[]{(byte) 0xAA, 0x75, 0x57, 0x00, 0x14, 0x00, 0x00, 0x01,
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[0])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[1])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[2])),
                    0x00, 0x00, 0x00,
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[3])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[4])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[5])),
                    0x00, 0x00, 0x00, 0};
            if (ContentUtils.getByte(bytes) != 0) {
                bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
            }
        }
        return bytes;
    }

    /**
     * 主页 驾驶行为评分 0x57 byte[]{0xAA, 0x75, 0x57, 0x00, 0x02, 0x00, 0x00, 0x02, 0}
     *
     * @return
     */
    @Override
    public byte[] getMain_57_02() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x57, 0x00, 0x02, 0x00, 0x00, 0x02, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 行驶记录 事故疑点 AA 75 10 00 0E 00 17 07 25 11 14 16 17 07 27 11 14 16 00 FF 3C
     *
     * @param dataTime
     * @return
     */
    @Override
    public byte[] getMain_10(int[] dataTime) {
        if (dataTime != null && dataTime.length > 11) {

            bytes = new byte[]{(byte) 0xAA, 0x75, 0x10, 0x00, 0x0E, 0x00,
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[0])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[1])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[2])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[3])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[4])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[5])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[6])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[7])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[8])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[9])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[10])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[11])),
                    0x00, (byte) 0xFF, 0};
            if (ContentUtils.getByte(bytes) != 0) {
                bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
            }
        }
        return bytes;
    }

    /**
     * 行驶记录 疲劳驾驶数据信息 AA 75 11 00 0E 00 17 07 25 11 14 17 17 07 27 11 14 17 00 FF 3D
     *
     * @param dataTime
     * @return
     */
    @Override
    public byte[] getMain_11(int[] dataTime) {
        if (dataTime != null && dataTime.length > 11) {

            bytes = new byte[]{(byte) 0xAA, 0x75, 0x11, 0x00, 0x0E, 0x00,
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[0])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[1])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[2])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[3])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[4])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[5])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[6])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[7])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[8])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[9])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[10])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[11])),
                    0x00, (byte) 0xFF, 0};
            if (ContentUtils.getByte(bytes) != 0) {
                bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
            }
        }
        return bytes;
    }


    /**
     * 空、满载设 置指令
     *
     * @return 0x3c  byte[]{AA,75,3c,00,01,00,01,}
     */
    @Override
    public byte[] getMain_3c(String status) {
        byte statu = 0x00;
        if ("1".equals(status))
            statu = 0x00;
        if ("2".equals(status))
            statu = 0x01;
        if ("3".equals(status))
            statu = 0x02;

        bytes = new byte[]{(byte) 0xAA, 0x75, 0x3c, 0x00, 0x01, 0x00, statu, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }

        return bytes;
    }

    /**
     * 设置系统时间
     *
     * @param dataTime
     * @return
     */
    @Override
    public byte[] getMain_02(int[] dataTime) {
        if (dataTime != null && dataTime.length > 5) {

            bytes = new byte[]{(byte) 0xAA, 0x75, 0x02, 0x00, 0x06, 0x00,
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[0])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[1])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[2])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[3])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[4])),
                    ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[5])),
                    0};
            if (ContentUtils.getByte(bytes) != 0) {
                bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
            }
        }
        return bytes;
    }


    /**
     * 主页 头部 GPRS GPS
     * 起始字头(#AAH)
     * 起始字头(#75H)
     * 命令字(#22H)
     * 数据块长度(高字节)
     * 数据块长度(低字节)
     * 保留(备用)字
     * 校验字节
     *
     * @return
     */
    @Override
    public byte[] getMain_22() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x22, 0x00, 0x01, 0x00, 0x01, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    @Override
    public byte[] getMain_26() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x26, 0x00, 0x01, 0x00, 0x01, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    @Override
    public byte[] getMain_27() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x27, 0x00, 0x01, 0x00, 0x01, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 报警状态
     *
     * @return
     */
    @Override
    public byte[] getMain_49() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x49, 0x00, 0x01, 0x00, 0x01, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 车辆参数
     *
     * @return
     */
    @Override
    public byte[] getMain_42() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x42, 0x00, 0x01, 0x00, 0x01, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 设备信息
     *
     * @return
     */
    @Override
    public byte[] getMain_4C() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x4C, 0x00, 0x01, 0x00, 0x01, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 定位状态
     *
     * @return
     */
    @Override
    public byte[] getMain_40() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x40, 0x00, 0x01, 0x00, 0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 三轴设备
     *
     * @return
     */
    @Override
    public byte[] getMain_51() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x51, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 三轴设备设置
     *
     * @return
     */
    @Override
    public byte[] getMain_51_01(int type) {
        byte t = 0x00;
        if (type == 1)
            t = 0x00;
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x51, 0x00, 0x02, 0x00, 0x00, t, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * CAN 总线监测
     *
     * @return
     */
    @Override
    public byte[] getMain_52() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x52, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    @Override
    public byte[] getMain_53() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x53, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    @Override
    public byte[] getMain_4E(int c, int b, int e) {
        if (e == 0) {
            bytes = new byte[]{(byte) 0xAA, 0x4E, 0x52, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        } else if (e == 1) {
            String d = Integer.toHexString(b);
            bytes = new byte[]{(byte) 0xAA, 0x4E, (byte) c, 0x00, 0x02, 0x00, 0x00, Byte.parseByte(d), 0};
        } else if (e == 2) {
            byte[] bytes2 = TextTransformationUtils.hexStringToByte(String.valueOf(b));
            bytes = new byte[]{(byte) 0xAA, 0x4E, (byte) c, 0x00, 0x02, 0x00, 0x00, bytes2[0], bytes2[1], 0};
        } else if (e == 4) {
            byte[] bytes1 = TextTransformationUtils.intToBytes2(b);
            bytes = new byte[]{(byte) 0xAA, 0x4E, (byte) c, 0x00, 0x02, 0x00, 0x00, bytes1[0], bytes1[1], bytes1[2], bytes1[3], 0};
        }
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 0x4F 工程菜单 —初始化项
     *
     * @return 查询中心优先级
     */
    @Override
    public byte[] getMain_4F_00() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x4F, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 0x4F 工程菜单 —初始化项
     *
     * @return 设置
     */
    @Override
    public byte[] getMain_4F_0x(byte id) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x4F, 0x00, 0x02, 0x00, id, 0x00, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 0x4F 工程菜单 —初始化项
     *
     * @return 中心优先级设置
     */
    @Override
    public byte[] getMain_4F_07(byte id) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x4F, 0x00, 0x04, 0x00, 0x00, 0x07, 0x01, id, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 0x50 工程菜单-设备测试
     *
     * @param id
     * @param type
     * @return
     */
    @Override
    public byte[] getMain_50(byte id, byte type) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x50, 0x00, 0x04, 0x00, 0x00, id, 0x01, type, 0};
        byte result = ContentUtils.getByte(bytes);
        if (result != 0) {
            bytes[bytes.length - 1] = result;
        }
        return bytes;
    }

    /**
     * 车辆信号状态
     *
     * @return
     */
    @Override
    public byte[] getMain_48() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x48, 0x00, 0x01, 0x00, 0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 实时数据信息 0x20
     *
     * @return
     */
    @Override
    public byte[] getMain_20() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x20, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 报警信号  0x24
     *
     * @return
     */
    @Override
    public byte[] getMain_24() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x24, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 不良驾驶记录
     *
     * @return
     */

    @Override
    public byte[] getMain_28(int[] dataTime) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x28, 0x00, 0x14, 0x00,
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[0])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[1])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[2])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[3])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[4])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[5])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[6])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[7])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[8])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[9])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[10])),
                ContentUtils.getByte(ContentUtils.DectoBCD(dataTime[11])),
                0x00, 0x00,
                0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 设置终端参数指令 3A
     *
     * @return
     */
    @Override
    public byte[] getMain_3A() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x3A, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    @Override
    public byte[] getMain_3A_0x(byte[] bytes) {
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 查询车载终端是否锁定
     *
     * @return
     */
    @Override
    public byte[] getMain_3B() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x3B, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 常规注册
     *
     * @return
     */
    @Override
    public byte[] getMain_4B() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x4B, 0x00, 0x01, 0x00, 0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    @Override
    public byte[] getMain_4B_01(byte[] bytes) {
//        bytes = new byte[]{(byte) 0x55, 0x7A, 0x4B, 0x00, 0x00,
//                0x02,
//                0x01, 0X03};
//        if (ContentUtils.getByte(bytes) != 0) {
//            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
//        }
        return bytes;
    }

    /**
     * 渣土车  载重传感器设置
     *
     * @param type
     * @return
     */
    @Override
    public byte[] getMain_5B(byte type) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x5B, 0x00, 0x03, 0x01, 0x01, type, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 远程升级
     *
     * @return
     */
    @Override
    public byte[] getMain_54() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x54, 0x00, 0x02, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     *  使用前锁定一
     * @param type
     * @return
     */
    @Override
    public byte[] getMain_4D(byte type) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x4D, 0x00, 0x01, 0x00, type, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 复位能效分析数据
     * @return
     */
    @Override
    public byte[] getMain_34() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x34, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 复位能效分析数据
     * @return
     */
    @Override
    public byte[] getMain_36() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x36, 0x00, 0x00, 0x00, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 打印页面
     * @param type
     * @return
     */
    @Override
    public byte[] getMain_43(byte type) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x43, 0x00, 0x01, 0x00,type, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 渣土车电子运营证页面
     * @return
     */
    @Override
    public byte[] getMain_3F() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x3F, 0x00, 0x01, 0x00,0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 模拟终端按键
     * @param type
     * @return
     */
    @Override
    public byte[] getMain_3E(byte type) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x3E, 0x00, 0x01, 0x00,type, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 采集胎压讯息数据
     * @return
     */
    @Override
    public byte[] getMain_39() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x39, 0x00, 0x01, 0x00,0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * TTS 播报提示
     * @return
     */
    @Override
    public byte[] getMain_46() {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x46, 0x00, 0x01, 0x00,0x01, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }

    /**
     * 模拟终端 0x01：进入模拟界面
     *          0x02：离开模拟界面
     * @param type
     * @return
     */
    @Override
    public byte[] getMain_3D(byte type) {
        bytes = new byte[]{(byte) 0xAA, 0x75, 0x3D, 0x00, 0x01, 0x00,type, 0};
        if (ContentUtils.getByte(bytes) != 0) {
            bytes[bytes.length - 1] = ContentUtils.getByte(bytes);
        }
        return bytes;
    }
}
