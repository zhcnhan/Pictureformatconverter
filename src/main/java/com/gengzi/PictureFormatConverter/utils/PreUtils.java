package com.gengzi.PictureFormatConverter.utils;


//用于图片转换前预处理的工具类

public class PreUtils {

    /*
            @fileName 文件原本的全名
            @newSuffixName 文件新的后缀名
            用于清除文件原本的后缀名，并返回文件名+新的后缀名
     */

    public static String RewriteSuffixName(String fileName,String newSuffixName){

        return fileName.substring(0,fileName.lastIndexOf("."))+"."+newSuffixName;
    }


    /*
        @preAddress 待处理的全路径
        由于Windows默认的复制全路径会自带引号，故而在此清除前后引号

     */
    public static String clearQuotes(String preAddress) {

        //如果路径带有引号，返回去除引号的路径，否则返回原路径
        if (preAddress.startsWith("\"") && preAddress.endsWith("\"")) {
            return  preAddress.substring(1, preAddress.length() - 1);
        }else {
            return preAddress;
        }

    }
}
