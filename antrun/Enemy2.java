/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antrun;

import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 *  Enemy 2 - creates the image for enemy 2, extends Enemies class
 */
public class Enemy2 extends Enemies{
    public Enemy2(SpriteComponent sc){
        super(sc);
        setPicture(makeEnemy2());
    }
    public static Picture makeEnemy2(){
        BufferedImage im = BasicFrame.createImage(30,30);
        Graphics2D gr = (Graphics2D) im.getGraphics();
        int w = 20;
        int h = 20;
        Color en2Color = new Color(120,0,0);
        gr.setColor(en2Color);
        gr.fillOval(5, 5, w, h);
        
        Color legColor = new Color(115,0,0);
        gr.setColor(legColor);
        gr.drawLine(5,5, 25, 25);
        gr.drawLine(25, 5, 5, 25);
        gr.drawLine(15, 0, 15, 30);
        gr.drawLine(0, 15, 30, 15);
      
        
        gr.setColor(Color.WHITE);
        gr.fillOval(7, 9, w/3, w/3);
        gr.fillOval(17, 9, w/3, w/3);
        
        gr.setColor(en2Color);
        gr.fillOval(8, 10, w/5, w/5);
        gr.fillOval(18, 10, w/5, w/5);
        
        
        
        gr.setColor(Color.white);
        gr.fillOval(10, 16, 10, 5);
        
      
        
        
        Picture enemy = new Picture(im);
        return enemy; //28
    }
}
