/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antrun;

import static antrun.Coins.makeCoin;
import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

/**
 *
 * Coin 1 - creates the image for coin 1, extends Coins class
 */
public class Coin1 extends Coins{
    public Coin1(SpriteComponent sc){
        super(sc);
        setPicture(makeCoin1());
    }
    
    public static Picture makeCoin1(){
        BufferedImage im = BasicFrame.createImage(20,20);
        Graphics2D gr = (Graphics2D) im.getGraphics();
        int w = im.getWidth();
        int h = im.getHeight();
        Color main = new Color(255, 234, 0);
        
        gr.setColor(main);
        gr.fillOval(0, 0, h, w);
        
        Color lightYellow = new Color(255, 191, 0);
        gr.setColor(lightYellow);
        gr.fillOval(2, 2, 15, 15);
        
        Color yellow = new Color(253, 218, 13);
        gr.setColor(yellow);
        Polygon p = new Polygon();
        p.addPoint(10, 20);
        p.addPoint(10, 0);
        p.addPoint(0, 10);
        p.addPoint(20, 10);
        gr.fillPolygon(p);
        
        
        Color dark = new Color(255, 255, 143);
        gr.setColor(dark);
        gr.fillOval(5, 5, 10, 10);
        
        Color yell = new Color(225, 193, 110);
        gr.setColor(yell);
        gr.fillOval(7, 7, 5, 5);
        
        Picture enemy = new Picture(im);
        return enemy;    //31
    }
}
