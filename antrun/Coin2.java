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
import java.awt.Image;
import java.awt.Polygon;

/**
 *
 * Coin 2 - creates the image for coin 2, extends Coins class
 */
public class Coin2 extends Coins{
    public Coin2(SpriteComponent sc){
        super(sc);
        setPicture(makeCoin2());
    }
    
    public static Picture makeCoin2(){
        Image im = BasicFrame.createImage(20, 20);
        Graphics gr = im.getGraphics();
        Color yellow = new Color(252, 245, 95);
        gr.setColor(yellow);
        gr.fillOval(0, 0, 20, 20);
        
        Color c1 = new Color(225, 193, 110);
        gr.setColor(c1);
        Polygon p = new Polygon();
        p.addPoint(10, 10);
        p.addPoint(5, 20);
        p.addPoint(15, 20);
        gr.fillPolygon(p);
        
        Color c2 = new Color(255, 191, 0);
        gr.setColor(c2);
        Polygon p2 = new Polygon();
        p2.addPoint(5, 1);
        p2.addPoint(15, 1);
        p2.addPoint(10, 10);
        gr.fillPolygon(p2);
        
        Color c3 = new Color(255, 255, 240);
        gr.setColor(c3);
        Polygon p3 = new Polygon();
        p3.addPoint(1, 5);
        p3.addPoint(1, 15);
        p3.addPoint(10, 10);
        gr.fillPolygon(p3);
        
        Color c4 = new Color(255, 222, 173);
        gr.setColor(c4);
        Polygon p4 = new Polygon();
        p4.addPoint(19, 5);
        p4.addPoint(19, 15);
        p4.addPoint(10, 10);
        gr.fillPolygon(p4);
        
        
        return new Picture(im); //39
    }
}
