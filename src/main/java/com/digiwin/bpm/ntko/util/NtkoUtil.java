package com.digiwin.bpm.ntko.util;

public class NtkoUtil {
    public static String resolvingPath(String physicalName){
        String jbossPath = System.getProperty("jboss.home.dir");
        jbossPath = jbossPath.replaceAll("\\\\","\\\\\\\\");
//        jbossPath = "F:\\BPM5821\\wildfly-15.0.0.Final";
        String basePath = jbossPath +"\\modules\\NaNa\\DocServer\\document\\attachment\\";

        int physicalNameLength = physicalName.length();
        // 将physicalName 转换成目录
        String sliceData;
        if (physicalName.length() % 2 != 0) {
            // physicalName 为基数
            sliceData = physicalName.substring(2, physicalNameLength - 1);
        } else {
            // physicalName 为偶数
            sliceData = physicalName.substring(2, physicalNameLength - 2);
        }
        String[] sliceArr = sliceData.split("");
        String str1 = "";
        String str3 = "";
        for (int i = 0; i < sliceArr.length; i++) {
            if (i % 2 == 0) {
                str3 = str3 + sliceArr[i];
            } else {
                str3 = str3 + sliceArr[i];
                str1 = str1 + str3 + ",";
                str3 = "";
            }
        }
        String[] arr4 = str1.split(",");
        //定义临时变量temp来进行数组的交换
        for (int i = 0; i < arr4.length / 2; i++) {
            String temp = arr4[i];
            arr4[i] = arr4[arr4.length - 1 - i];
            arr4[arr4.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr4.length; i++) {
            basePath = basePath + arr4[i] + "\\";
        }
        return basePath;
    }
}
