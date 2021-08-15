package com.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CheckCode {
    public static void main(String[] args) throws IOException {
        String pool="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] poolChar=pool.toCharArray();
        int width=100;
        int heigh=30;
        //画板
        BufferedImage image=new BufferedImage(width,heigh,BufferedImage.TYPE_INT_RGB);
        //画笔
//        Graphics g = image.getGraphics();
        Graphics2D g = image.createGraphics();
        g.setColor(getRandomColor(180,230));//设置画笔颜色,作为背景颜色
        g.fillRect(0,0,width,heigh);//画笔填充颜色
        //获取字符
        Random r=new Random();
        int x=15;
        int y=20;//定义字符画在画板上的位置
        g.setFont(new Font("宋体",Font.BOLD,25));
        for (int i=0;i<4;i++){
            g.setColor(getRandomColor(30,90));
            //随机获取字符
            char c=poolChar[r.nextInt(poolChar.length)];
            //将字符画在画板上
            g.drawString(c+"",x,y);
            x=x+20;
            System.out.printf(c+"");
        }
//        //增加干扰线
//        for (int i=0;i<30;i++){
//            int x1=getRandomNum(0,100);
//            int y1=getRandomNum(0,30);
//            int x2=getRandomNum(0,100);
//            int y2=getRandomNum(0,30);
//            g.setColor(getRandomColor(150,230));
//            g.drawLine(x1,y1,x2,y2);
//        }
        //增加圆点干扰
//        for (int i=0;i<100;i++){
//            g.setColor(getRandomColor(100,150));
//            g.drawOval(getRandomNum(0,100),getRandomNum(0,30),1,1);
//        }
        ImageIO.write(image,"jpg",new File("E:\\aaaa.jpg"));
    }
    public static int getRandomNum(int min,int max){
        return (int)(Math.random()*(max-min)+min);
    }
    public static Color getRandomColor(int min,int max){
        int red=getRandomNum(min,max);
        int green=getRandomNum(min,max);
        int blue=getRandomNum(min,max);
        return new Color(red,green,blue);
    }
}
