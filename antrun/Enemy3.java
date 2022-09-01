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
 *  Enemy 3 - creates the image for enemy 3, extends Enemies class
 */
public class Enemy3 extends Enemies{
    public Enemy3(SpriteComponent sc){
        super(sc);
        setPicture(makeEnemy3());
    }
    public static Picture makeEnemy3(){
        BufferedImage im = BasicFrame.createImage(30,30);
        Graphics2D gr = (Graphics2D) im.getGraphics();
        Color en3color = new Color(200,60,60);
        gr.setColor(en3color);
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(5, 5);
        p.addPoint(0, 10);
        p.addPoint(5, 15);
        p.addPoint(0, 20);
        p.addPoint(5, 25);
        
        
        p.addPoint(30, 0);
        p.addPoint(25, 5);
        p.addPoint(30, 10);
        p.addPoint(25, 15);
        p.addPoint(30, 20);
        p.addPoint(25, 25);
        
        
        gr.fillPolygon(p);
        
        Color anColor = new Color(68,27,0);
        gr.setColor(anColor);
        gr.drawLine(15,15,10,5);
        gr.drawLine(15,15,20,5);
        gr.setColor(Color.white);
        gr.fillOval(9, 4, 5, 5);
        gr.fillOval(16, 4, 5, 5);
        
        gr.setColor(Color.black);
        gr.fillOval(11, 5, 2, 2);
        gr.fillOval(18, 5, 2, 2);
        
        gr.setColor(Color.white);
        gr.drawLine(5,7,12,14);
        gr.drawLine(25,7,18,14);
        gr.drawLine(12,14,5,21);
        gr.drawLine(25,21,18,14);
        
        Color pink = new Color(255,20,147);
        gr.setColor(pink);
        Polygon p2 = new Polygon();
        p2.addPoint(4,10);
        p2.addPoint(4,18);
        p2.addPoint(8,14);
        gr.fillPolygon(p2);
        
        
        gr.setColor(pink);
        Polygon p3 = new Polygon();
        p3.addPoint(26,10);
        p3.addPoint(26,18);
        p3.addPoint(22,14);
        gr.fillPolygon(p3);
        
        Picture enemy = new Picture(im);
        return enemy; //53
    }
}
