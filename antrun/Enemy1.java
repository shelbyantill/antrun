/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antrun;


import static antrun.Enemies.enemyCount;
import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

/**
 *
 *  Enemy 1 - creates the image for enemy 1, extends Enemies class
 */
public class Enemy1 extends Enemies{
    public Enemy1(SpriteComponent sc){
        super(sc);
        setPicture(makeEnemy1());
    }
    public static Picture makeEnemy1(){
        
        
        BufferedImage im = BasicFrame.createImage(20,30);
        Graphics2D gr = (Graphics2D) im.getGraphics();
        int w = im.getWidth();
        int h = im.getHeight();
        Color en1Color = new Color(150,0,0);
        gr.setColor(en1Color);
        gr.fillOval(0, 0, w, h);
        
        //adding legs
        gr.drawLine(0, 0, 20, 30);
        gr.drawLine(20, 0, 0, 30);
        
        
        //adding orange triangle stripe
        gr.setColor(Color.orange);
        Polygon p = new Polygon();
        p.addPoint(w/4, 2*h/3);
        p.addPoint(w/2, h);
        p.addPoint(3*w/4, 2*h/3);
        gr.fillPolygon(p);
        
        Color orange = new Color(204,85,0);
        gr.setColor(orange);
        Polygon p2 = new Polygon();
        p2.addPoint(w/4+2, 2*h/3+1);
        p2.addPoint(3*w/4-2, 2*h/3+1);
        p2.addPoint(w/2, h-2);
        gr.fillPolygon(p2);
        
        
        //adding eyes
        gr.setColor(Color.WHITE);
        gr.fillOval(2, 4, w/3, w/3);
        gr.fillOval(12, 4, w/3, w/3);
        
        gr.setColor(Color.BLACK);
        gr.fillOval(2, 4, w/5, w/5);
        gr.fillOval(12, 4, w/5, w/5);
        
        //adding antennas
        
        Color orangey = new Color(233,116,81);
        gr.setColor(orangey);
        Polygon p4 = new Polygon();
        p4.addPoint(11, 4);
        p4.addPoint(15, 4);
        p4.addPoint(13, 0);
        gr.fillPolygon(p4);
        
        gr.setColor(orangey);
        Polygon p5 = new Polygon();
        p5.addPoint(4, 4);
        p5.addPoint(8, 4);
        p5.addPoint(6, 0);
        gr.fillPolygon(p5);
        
        Picture enemy = new Picture(im);
        return enemy; //48
        
    }
    

}
