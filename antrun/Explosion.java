/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antrun;


import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;


/**
 *
 * Makes explosions when the ant dies by certain enemies. 
 */
public class Explosion extends Sprite {
    public Explosion(SpriteComponent sc, double x, double y, String type){
        
        /**
        *
        * Sets x and y, and x and y velocity. Determines what type of explosion to make.
        */
        super (sc);
        if(type.equals("1")){
            setPicture(makeExplosion1());
        }
        if(type.equals("2")){
            setPicture(makeExplosion2());
        }
        if(type.equals("3")){
            setPicture(makeExplosion2());
        }
        if(type.equals("4")){
            setPicture(makeExplosion3());
        }
        if(type.equals("1B")){
            setPicture(makeExplosion1());
        }
        if(type.equals("2B")){
            setPicture(makeExplosion2());
        }
        if(type.equals("3B")){
            setPicture(makeExplosion3());
        }
        setX(x);
        setY(y);
        setVelX(2 * AntRun.RAND.nextDouble() - 1);
        setVelY(2 * AntRun.RAND.nextDouble() - 1);
    }
    
    public static Picture makeExplosion1(){
        /**
         * makes explosion 1 image
         */
        Image im = BasicFrame.createImage(30, 30);
        Graphics g = im.getGraphics();
        g.setColor(Color.red);
        g.fillOval(0, 0, 30, 30);
        
        Color crimson = new Color(220, 20, 60);
        g.setColor(crimson);
        g.fillOval(3, 3, 25, 25);
       
       
        Color coral = new Color(255, 127, 80); //30
        g.setColor(coral);
        Polygon p = new Polygon();
        p.addPoint(15, 30);
        p.addPoint(15, 0);
        p.addPoint(0, 15);
        p.addPoint(30, 15);
        g.fillPolygon(p);
        
        
        Color tomato = new Color(255, 99, 71);
        g.setColor(tomato);
        g.fillOval(8, 8, 15, 15);
        
        return new Picture(im);
    }
    
     public static Picture makeExplosion2(){
         
        /**
        * makes explosion 2 image
        */
        Image im = BasicFrame.createImage(30, 30);
        Graphics g = im.getGraphics();
        
        g.setColor(Color.red);
       
        
        g.fillRect(0, 0, 30, 30);
        
        Color c3 = new Color(255, 99, 71);
        g.setColor(c3);
        Polygon p1 = new Polygon();
        p1.addPoint(15, 30);
        p1.addPoint(15, 0);
        p1.addPoint(0, 15);
        p1.addPoint(30, 15);
        g.fillPolygon(p1);
        
        Color c4 = new Color(220, 20, 60);
        g.setColor(c4);
        Polygon p2 = new Polygon();
        p2.addPoint(0,30);
        p2.addPoint(15, 0);
        p2.addPoint(30, 30); //60
        g.fillPolygon(p2);
        
        
        Color c5 = new Color(136, 8, 8);
        g.setColor(c5);
        Polygon p3 = new Polygon();
        p3.addPoint(0,30);
        p3.addPoint(15, 0);
        p3.addPoint(30, 0);
        g.fillPolygon(p3);
        
        
        return new Picture(im);
    }
     
     
     public static Picture makeExplosion3(){
         /**
         * makes explosion 3 image
         */
         Image im = BasicFrame.createImage(30, 30);
        Graphics g = im.getGraphics();
        
        g.setColor(Color.red);
        g.fillOval(0, 0, 30, 30);
       
        Color c = new Color(139, 0, 0);
        g.setColor(c);
        Polygon p = new Polygon();
        p.addPoint(15, 0);
        p.addPoint(0, 15);
        p.addPoint(15, 30);
        p.addPoint(30, 15);
        g.fillPolygon(p);
        
        
        Color c1 = new Color(248,131,121);
        g.setColor(c1);
        Polygon p2 = new Polygon();
        p2.addPoint(15, 0);
        p2.addPoint(26, 10);
        p2.addPoint(5, 10);
        g.fillPolygon(p2);
        
       
        Polygon p3 = new Polygon(); //90
        p3.addPoint(15, 30);
        p3.addPoint(26, 20);
        p3.addPoint(5, 20);
        g.fillPolygon(p3);
        
        return new Picture(im);
     }
    
    
    public boolean checkActive(){
        
        if(isActive()){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
    public void processEvent(SpriteCollisionEvent se) {
        
        /**
         * processes when the explosion hits the walls
         */
        SpriteComponent sc = getSpriteComponent();
        if(se.eventType == CollisionEventType.WALL_INVISIBLE) {
            if (se.xlo) {
                setX(sc.getSize().width - getWidth());
            }
            if (se.xhi) {
                setX(0);
            }
            if (se.ylo) {
                setY(sc.getSize().height - getHeight());
            }
            if (se.yhi) {
                setY(0); //111
            }
        }

    }
}


