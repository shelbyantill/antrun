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
 *  Enemy 4 - creates the image for enemy 4, extends Enemies class
 */
public class Enemy4 extends Enemies{
    public Enemy4(SpriteComponent sc){
        super(sc);
        setPicture(makeEnemy4());
    }
    public static Picture makeEnemy4(){
        BufferedImage im = BasicFrame.createImage(30,30);
        Graphics2D gr = (Graphics2D) im.getGraphics();
        Color en4color = new Color(139,0,50);
        gr.setColor(en4color);
        gr.fillOval(0, 0, 30, 20);
        
        Color cr = new Color(255, 209, 219);
        gr.setColor(cr);
        Polygon p = new Polygon();
        p.addPoint(5, 5);
        p.addPoint(0,10);
        p.addPoint(25, 5);
        p.addPoint(30, 10);
        
        gr.fillPolygon(p);
        
        Polygon p2 = new Polygon();
        p2.addPoint(5, 15);
        p2.addPoint(0,10);
        p2.addPoint(25, 15);
        p2.addPoint(30, 10);
        
        gr.fillPolygon(p2);
        
        
        Color cl = new Color(255, 150, 219);
        gr.setColor(cl);
        Polygon p3 = new Polygon();
        p3.addPoint(12, 0);
        p3.addPoint(18, 0);
        p3.addPoint(15, 4);//30
        gr.fillPolygon(p3);
        
        gr.setColor(cl);
        Polygon p4 = new Polygon();
        p4.addPoint(12, 20);
        p4.addPoint(18, 20);
        p4.addPoint(15, 16);
        gr.fillPolygon(p4);

        
        gr.setColor(Color.black);
        gr.drawLine(5, 5, 0, 0);
        gr.drawLine(5, 15, 0, 20);
        
        gr.fillOval(-1, -1, 4, 4);
        gr.fillOval(-1, 18, 4, 4);
        
        Picture enemy = new Picture(im);
        return enemy; //44
    }
}
