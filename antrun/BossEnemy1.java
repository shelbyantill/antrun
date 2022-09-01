/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antrun;

import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

/**
 *
 * Boss Enemy 1 - creates the image for boss enemy 1, extends Enemies class
 */
public class BossEnemy1 extends Enemies{
    
    
    public BossEnemy1(SpriteComponent sc){
        super(sc);
        setPicture(makeBossEnemy1());
    }
    public static Picture makeBossEnemy1(){
        
        
        BufferedImage im = BasicFrame.createImage(30,40);
        Graphics2D gr = (Graphics2D) im.getGraphics();
        int w = im.getWidth();
        int h = im.getHeight();
        Color color = new Color(159,43, 104);
        gr.setColor(color);
        gr.fillOval(0, 0, w, h);
        
        //adding legs
        gr.drawLine(0, 0, 30, 40);
        gr.drawLine(30, 0, 0, 40);
        
        
        //adding triangle stripe
        gr.setColor(Color.pink);
        Polygon p = new Polygon();
        p.addPoint(w/4, 2*h/3);
        p.addPoint(w/2, h);
        p.addPoint(3*w/4, 2*h/3);
        gr.fillPolygon(p);
        
        Color purple2 = new Color(191,64,191);
        gr.setColor(purple2);
        Polygon p2 = new Polygon();
        p2.addPoint(w/4+2, 2*h/3+1);
        p2.addPoint(3*w/4-2, 2*h/3+1);
        p2.addPoint(w/2, h-2);
        gr.fillPolygon(p2);
        
        Color purple3 = new Color(203,195,227);
        gr.setColor(purple3);
        Polygon p3 = new Polygon();
        p3.addPoint(w/4+5, 2*h/3+3);
        p3.addPoint(3*w/4-5, 2*h/3+3);
        p3.addPoint(w/2, h-5);
        gr.fillPolygon(p3);
        
        //adding eyes
        gr.setColor(Color.WHITE);
        gr.fillOval(4, 6, w/3, w/3);
        gr.fillOval(14, 6, w/3, w/3);
        
        gr.setColor(Color.BLACK);
        gr.fillOval(4, 6, w/5, w/5);
        gr.fillOval(14, 6, w/5, w/5);
        
        //adding antennas
        
        Color purple4 = new Color(203,195,227);
        gr.setColor(purple4);
        Polygon p4 = new Polygon();
        p4.addPoint(17, 6);
        p4.addPoint(21, 6);
        p4.addPoint(19, 0);
        gr.fillPolygon(p4);
        
        gr.setColor(purple4);
        Polygon p5 = new Polygon();
        p5.addPoint(8, 6);
        p5.addPoint(12, 6);
        p5.addPoint(10, 0);
        gr.fillPolygon(p5);
        
        Picture enemy = new Picture(im);
        return enemy; //55
        
}
}
