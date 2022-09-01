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
import java.awt.Polygon;
import java.awt.image.BufferedImage;

/**
 *
 * Boss Enemy 2 - creates the image for boss enemy 2, extends Enemies class
 */
public class BossEnemy2 extends Enemies{
    public BossEnemy2(SpriteComponent sc){
        super(sc);
        setPicture(makeBossEnemy2());
    }
    public static Picture makeBossEnemy2(){
        
        Image im = BasicFrame.createImage(30, 40);
        Graphics g = im.getGraphics();
        Color purple = new Color(159, 43, 104);
        
        g.setColor(purple);
        
        g.drawLine(0, 0, 30, 40);
        g.drawLine(30, 0, 0, 40);
        
        
        Polygon p = new Polygon();
        p.addPoint(15, 0);
        p.addPoint(0, 15);
        p.addPoint(15, 40);
        p.addPoint(30, 15);
        g.fillPolygon(p);
        
        //eyes
        g.setColor(Color.WHITE);
        g.fillOval(4, 6, 10, 10);
        g.fillOval(14, 6, 10, 10);
        
        g.setColor(Color.BLACK);
        g.fillOval(5, 7, 6, 6);
        g.fillOval(15, 7, 6, 6);
        
        
        //mouth
        g.setColor(Color.WHITE);
        g.fillOval(9, 18, 12, 12);
        
        Color purple2 = new Color(191, 64, 191);
        g.setColor(purple2);
        Polygon p2 = new Polygon();
        p2.addPoint(9, 20);
        p2.addPoint(21, 20);
        p2.addPoint(15, 30);
        g.fillPolygon(p2);
        
         // attennas
        Color purple4 = new Color(203,195,227);
        g.setColor(purple4);
        Polygon p4 = new Polygon();
        p4.addPoint(17, 6);
        p4.addPoint(21, 6);
        p4.addPoint(19, 0);
        g.fillPolygon(p4);
        
        g.setColor(purple4);
        Polygon p5 = new Polygon();
        p5.addPoint(8, 6);
        p5.addPoint(12, 6);
        p5.addPoint(10, 0);
        g.fillPolygon(p5);
        
        Picture enemy = new Picture(im);
        return enemy; //47
        
    }
}
