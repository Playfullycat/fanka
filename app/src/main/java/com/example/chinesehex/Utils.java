package com.example.chinesehex;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by yxl on 17/2/5.
 */

public class Utils {

    public static String toGBK(String source) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = source.getBytes("GBK");
        for (byte b : bytes) {
            sb.append(Integer.toHexString((b & 0xff)).toUpperCase());
        }

        return sb.toString();
    }

    //写数据
    public static void writeToSdCard(Context context, String name, String num, String money,
                                     String filename) {
        //1、判断sd卡是否可用
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //sd卡可用
            //2、获取sd卡路径
            File sdFile = Environment.getExternalStorageDirectory();
            File path = new File(sdFile + "/MifareClassicTool/dump-files/", filename);//sd卡下面的a.txt文件  参数 前面 是目录 后面是文件
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                StringBuffer sb = new StringBuffer();
                sb.append("+Sector: 0\n");
                sb.append("95B2F95B850804006263646566676869\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 1\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 2\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 3\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 4\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 5\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 6\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 7\n");
                sb.append(num + "0000000000100100100130\n");   //工号
                sb.append("000000000000000000044E000000004A\n");
                sb.append(name + "00000000000000000152\n");   //姓名
                sb.append("199902240628FF078069199902240628\n");
                sb.append("+Sector: 8\n");
                sb.append("43308047433080470000000816780A66\n");   //工号验证(未解)
                sb.append("66001526" + name + "000000006006\n");   //中间还有姓名
                sb.append("0131123488888800261500660000B1CB\n");
                sb.append("13802276230DFF0780694346A053464A\n");
                sb.append("+Sector: 9\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append(money + "\n");   //余额
                sb.append(money + "\n");   //余额
                sb.append("2F95B1159168FF0780694346A053464A\n");
                sb.append("+Sector: 10\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00130090B60005008FAE0016008D0C4A\n");
                sb.append("075583740268FF0780694346A053464A\n");
                sb.append("+Sector: 11\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 12\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 13\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 14\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");
                sb.append("+Sector: 15\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF\n");
                sb.append("00000000000000000000000000000000\n");
                sb.append("369886663696FF078069B0B1B2B3B4B5\n");


                fileOutputStream.write(sb.toString().getBytes());
                Toast.makeText(context, "保存好了", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    }
}
