package com.springboot.pdftoimage.util;

import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;










import javax.imageio.ImageIO;










import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.PDimension;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * @author chendeyou 2019/11/6 15:48
 * @ClassName: com.springboot.pdftoimage.util
 * @describe
 */
public class PdfToImageUtil {
    static Logger logger = LoggerFactory.getLogger(PdfToImageUtil.class);

    public static void mergeImage(List<BufferedImage> piclist, String outPath){
        if (piclist == null || piclist.size() <= 0) {
            System.out.println("图片数组为空!");
            return;
        }
        //总高度
        int height = 0;
        //总宽度
        int width = 0;
        int _height = 0,picNum = piclist.size();// 图片的数量   // 临时的高度 , 或保存偏移高度  
        int[] heightArray = new int[picNum]; // 保存每个文件的高度  
        BufferedImage buffer = null; // 保存图片流  
        List<int[]> imgRGB = new ArrayList<int[]>(); // 保存所有的图片的RGB
        int[] _imgRGB; // 保存一张图片中的RGB数据  
        for (int i = 0; i < picNum; i++) {
            buffer = piclist.get(i);
            heightArray[i] = _height = buffer.getHeight();// 图片高度
            if(i == 0){
                width = buffer.getWidth();// 图片宽度
            }
            height += _height; // 获取总高度
        }
        _height = 0; // 设置偏移高度为0
        // 生成新图片
        BufferedImage imageResult = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
        //创建输出流
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(outPath);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //绘制合成图像
        Graphics g = imageResult.createGraphics();
        height = 0;
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < picNum; i++) {

            g.drawImage(piclist.get(i), 0, height, width, heightArray[i], null);
            _height = heightArray[i];
            height += _height; // 计算偏移高度

        }
        g.dispose();
        //将绘制的图像生成至输出流
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        try {
            encoder.encode(imageResult);
            //关闭输出流
            out.close();
        } catch (ImageFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("耗时："+(System.currentTimeMillis() - starttime));
    }
    public static void pdfToImage(String filePath,String path){
        Document document = new Document();
        try {
            document.setFile(filePath);
            //缩放比例
            float scale = 2.5f;
            //旋转角度
            float rotation = 0f;
            List<BufferedImage> piclist = new ArrayList<BufferedImage>();

            long startTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                BufferedImage image = (BufferedImage)document.getPageImage(i, GraphicsRenderingHints.SCREEN,org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
                image.flush();
                piclist.add(image);
            }
            logger.info("转pdf耗时："+(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()-startTime));
            mergeImage(piclist,path);
            document.dispose();
        } catch (PDFException e) {
            e.printStackTrace();
        } catch (PDFSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "E:\\NPT014_201911061521060589.pdf";
        pdfToImage(filePath, "E:\\b.jpg");
    }
}
