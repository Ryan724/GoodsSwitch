package com.goodsswitch.tool;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtils {
//    public static void main(String[] s){
//        ImageUtils.scaleByFile2(new File("e:/abc.jpg"), new File("e:/123.jpg"), 300, 200, true);
//    }
    /**
     * 缩放图像（按高度和宽度缩放）
     * @param srcFile 源文件
     * @param result 转后的文件
     * @param height 缩放后的高度
     * @param width 缩放后的宽度
     * @param bb 比例不对时是否需要补白：true为补白; false为不补白;
     */
    public final static void scaleByFile(File srcFile, File desFile,  int width,int height,boolean bb) {
        try {
            double ratio = 0.0; // 缩放比例
            BufferedImage bi = ImageIO.read(srcFile);
            Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
            // 计算比例
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = (new Integer(height)).doubleValue()/ bi.getHeight();
                } else {
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform
                        .getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }
            if (bb) {//补白
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                g.dispose();
                itemp = image;
            }
            ImageIO.write((BufferedImage) itemp, "JPEG",desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void scaleByFile2(File srcFile, File desFile, int width,int height,boolean bb){
        try {
        String imagePath =srcFile.getAbsolutePath();  
        BufferedImage image = ImageIO.read(srcFile);
        Builder<BufferedImage> builder = null;  
          
        int imageWidth = image.getWidth();  
        int imageHeitht = image.getHeight();  
        if ((float)width / height != (float)imageWidth / imageHeitht) {  
            if (imageWidth < imageHeitht) {  
                image = Thumbnails.of(imagePath).height(height).asBufferedImage();  
            } else {  
                image = Thumbnails.of(imagePath).width(width).asBufferedImage();  
            }  
            builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height).size(width, height);  
        } else {  
            builder = Thumbnails.of(image).size(width, height);  
        }  
        builder.outputFormat("jpg").toFile(desFile); 
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
}
