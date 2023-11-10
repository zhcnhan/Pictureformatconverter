package com.gengzi.PictureFormatConverter;


import com.gengzi.PictureFormatConverter.utils.PreUtils;
import com.gengzi.PictureFormatConverter.utils.pictureConverUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class pictureConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //待修改的图片路径
        String preAddress = null;

        //新的格式名
        String formatType = null;

        //输出的文件路径，留空则输出到原文件位置
        String outputAddress = null;

        //待修改的图片
        File prePicture = null;


        System.out.println("请粘贴要转换的完整文件地址：");
        preAddress = scanner.nextLine();


        System.out.println("请输入要转换的文件格式：");
        formatType = scanner.nextLine();

        System.out.println("请输入要输出到的文件夹地址(留空则修改原文件)：");
        outputAddress = scanner.nextLine();

        //去除Windows复制默认路径的引号，如果没有引号，保持原路径不变
        preAddress = PreUtils.clearQuotes(preAddress);
        outputAddress = PreUtils.clearQuotes(outputAddress);

        //构造图片文件
        prePicture = new File(preAddress);

        //图像格式转换输出
        try {

            pictureConverUtils.pictureNormalFormatConver(prePicture,formatType,outputAddress);

        } catch (Exception e) {

            System.out.println("转换失败： " + e.getMessage());

        }

    }
}
