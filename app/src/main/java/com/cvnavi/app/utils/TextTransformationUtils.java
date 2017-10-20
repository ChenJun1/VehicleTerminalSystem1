package com.cvnavi.app.utils;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by zww on 2017/7/11.
 */

public class TextTransformationUtils {

    private static String hexString = "0123456789ABCDEF";

    /*
    * 将16进制数字解码成字符串,适用于所有字符（包括中文）
    */
    public static String decode(String bytes) {
        bytes = bytes.toUpperCase();
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
        // 将每2位16进制整数组装成一个字节
        for (int i = 0; i < bytes.length(); i += 2)
            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString
                    .indexOf(bytes.charAt(i + 1))));
        String value = null;
        try {
            value = new String(baos.toByteArray(), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    /*
    * 将字符串编码成16进制数字,适用于所有字符（包括中文）
    */
    public static String encode(String data) {
        byte[] bytes;
        try {
            bytes = data.getBytes("GBK");
            StringBuilder sb = new StringBuilder(bytes.length * 2);

            for (byte aByte : bytes) {
                sb.append(hexString.charAt((aByte & 0xf0) >> 4));
                sb.append(hexString.charAt((aByte & 0x0f)));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static byte[] encode(String data, int length, int a, int b, int c, boolean t) {
        byte[] by = new byte[]{(byte) a, (byte) b, (byte) c};
        try {
            byte[] bytes = data.getBytes("GBK");
            StringBuilder sb = new StringBuilder(bytes.length * 2);

            for (byte aByte : bytes) {
                sb.append(hexString.charAt((aByte & 0xf0) >> 4));
                sb.append(hexString.charAt((aByte & 0x0f)));
            }
            if (t)
                return byteMerger(by, hexStringToByte(sb.toString(), length));
            else {
                byte[] bytes1 = hexStringToByte(sb.toString());
                String lin = Integer.toHexString(bytes1.length);
//                bytes[4] = Integer.valueOf(lin, 16).byteValue();
                by[2] = Integer.valueOf(lin, 16).byteValue();
                return byteMerger(by, bytes1);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return by;
    }

    //将汉字转换为16进制数
    public static String enUnicode(String content) {
        String enUnicode = null;
        for (int i = 0; i < content.length(); i++) {
            if (i == 0) {
                enUnicode = getHexString(Integer.toHexString(content.charAt(i)).toUpperCase());
            } else {
                enUnicode = enUnicode + getHexString(Integer.toHexString(content.charAt(i)).toUpperCase());
            }
        }
        return enUnicode;
    }

    private static String getHexString(String hexString) {
        String hexStr = "";
        for (int i = hexString.length(); i < 4; i++) {
            if (i == hexString.length())
                hexStr = "0";
            else
                hexStr = hexStr + "0";
        }
        return hexStr + hexString;
    }

    //十六进制转ASCII码
    private static String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < hex.length() - 1; i += 2) {

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }


    /**
     * byte数组转换成16进制字符数组
     *
     * @param src
     * @return
     */
    public static String[] bytesToHexStrings(byte[] src) {
        if (src == null || src.length <= 0) {
            return null;
        }

        String[] str = new String[src.length];

        for (int i = 0; i < src.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);

            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
            str[i] = stringBuilder.toString();
        }
        return str;
    }

    //十六进制转二进制
    public static String hexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000"
                    + Integer.toBinaryString(Integer.parseInt(hexString
                    .substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    /**
     * 把16进制字符串转换成字节数组
     *
     * @param hex
     * @return byte[]
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    /**
     * 把16进制字符串转换成字节数组
     *
     * @param hex
     * @return byte[]
     */
    public static byte[] hexStringToByte(String hex, int b) {
        int len = (hex.length() / 2);
        byte[] result = new byte[b];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    /**
     * 通过byte数组取到int
     *
     * @param bb
     * @param index 第几位开始
     * @return
     */
    public static int getInt(byte[] bb, int index) {
        return (int) ((((bb[index] & 0xff) << 24)
                | ((bb[index + 1] & 0xff) << 16)
                | ((bb[index + 2] & 0xff) << 8) | ((bb[index + 3] & 0xff))));
    }


    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。  和bytesToInt2（）配套使用
     */
    public static byte[] intToBytes2(int value) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value >> 24) & 0xFF);
        src[1] = (byte) ((value >> 16) & 0xFF);
        src[2] = (byte) ((value >> 8) & 0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * 通过byte数组取到short
     *
     * @param b
     * @param index 第几位开始取
     * @return
     */
    public static short getShort(byte[] b, int index) {
        return (short) (((b[index] << 8) | b[index + 1] & 0xff));
    }


    /**
     * 转换short为byte
     *
     * @param s 需要转换的short
     */
    public static byte[] shortToByte(short s) {
        byte[] b = new byte[2];
        b[0] = (byte) ((s >> 8) & 0xFF);
        b[1] = (byte) (s & 0xFF);
        return b;
    }

    /**
     * @param temp 十进制转换成BCD编码
     * @return
     */
    public static int DectoBCD(int temp) {
        return ((temp / 10) << 4 | temp % 10);
    }

    private static int toByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String getGbkValue(String[] test, int start, int size) {
        String value = "";
        for (int i = 0; i < size; i++) {
            value = value + test[start + i];
        }
        return value;
    }


    public static int[] binaryToArray(String value) {
        return new int[]{Integer.parseInt(value.substring(0, 1)), Integer.parseInt(value.substring(1,
                2)), Integer.parseInt(value.substring(2, 3)), Integer.parseInt(value.substring(3, 4)),
                Integer.parseInt(value.substring(4, 5)), Integer.parseInt(value.substring(5, 6)),
                Integer.parseInt(value.substring(6, 7)), Integer.parseInt(value.substring(7, 8))};
    }

    public static String[] binaryToStringArray(String value) {
        return new String[]{value.substring(0, 1), value.substring(1,
                2), value.substring(2, 3), value.substring(3, 4),
                value.substring(4, 5), value.substring(5, 6),
                value.substring(6, 7), value.substring(7, 8)};
    }

    public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }

    /**
     * 取数据源里时间
     * @param values 数据源
     * @param index 起始下标
     * @param end 终止下标
     * @return
     */
    public static String getDateTime(String[] values, int index, int end) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = index; i <= end; i++) {

            if(i==index+2){
                stringBuffer.append(values[i]+" ");
            }else if(i<index+2){
                stringBuffer.append(values[i]+"-");
            }else if(i==index+5){
                stringBuffer.append(values[i]+" ");
            }else if(i<index+5&&i>index+2){
                stringBuffer.append(values[i]+":");
            }
        }
        return stringBuffer.toString();
    }
}
