package com.gengzi.PictureFormatConverter.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.gengzi.PictureFormatConverter.utils.PreUtils;

//用于图片处理和输出的工具类
public class pictureConverUtils {
        /*
          @prePicture 待转换的图片
          @formatType 需要要转换的文件格式
          @outputAddress 输出文件路径，留空则输出到原路径

          用于基本图片格式转换的方法
         */
        public static void pictureNormalFormatConver(File prePicture,String formatType,String outputAddress)  {

            //判断传入的文件是否是一个可用文件
            if (prePicture.isFile()) {

                //判断输出路径是否留空
                if (outputAddress.isEmpty()){
                    //清除原本文件的后缀名，并定义新的后缀名
                    String newPictureAddress = prePicture.getParent()+"\\"+PreUtils.RewriteSuffixName(prePicture.getName(),formatType);


                    //调用Thumbnails类，转换图片格式并输出到原本路径，不改变图像尺寸
                    Thumbnails.Builder<File> instance = Thumbnails.of(prePicture);
                    try {
                        instance.scale(1f)
                                .outputFormat(formatType)
                                .toFile(newPictureAddress);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }



                }else {
                    //清除原本文件的后缀名，并定义新的后缀名
                    String newPictureName = PreUtils.RewriteSuffixName(prePicture.getName(),formatType);

                    //调用Thumbnails类，转换图片格式并输出，不改变图像尺寸
                    Thumbnails.Builder<File> instance = Thumbnails.of(prePicture);
                    try {
                        instance.scale(1f)
                                .outputFormat(formatType)
                                .toFile(outputAddress +"\\"+newPictureName);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }else {
                //如果文件不可用，抛出FileNotFound异常
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }


}
