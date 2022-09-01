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
 * Boss Enemy 3 - creates the image for boss enemy 3, extends Enemies class
 */
public class BossEnemy3 extends Enemies{
    public BossEnemy3(SpriteComponent sc){
        super(sc);
        setPicture(makeBossEnemy3());
    }
    public static Picture makeBossEnemy3(){
        
        
        BufferedImage im = BasicFrame.createImage(40,40);
        Graphics2D gr = (Graphics2D) im.getGraphics();
        Color en4color = new Color(139,0,50);
        gr.setColor(en4color);
        gr.fillOval(0, 0, 40, 30);
        
        
        Color cr = new Color(255, 253, 208);
        gr.setColor(cr);
        Polygon p = new Polygon();
        p.addPoint(7, 7);
        p.addPoint(0,13);
        p.addPoint(33, 7);
        p.addPoint(40, 13);
        
        gr.fillPolygon(p);
        
        Polygon p2 = new Polygon();
        p2.addPoint(7, 20);
        p2.addPoint(0,15);
        p2.addPoint(33, 20);
        p2.addPoint(40, 15);
        
        gr.fillPolygon(p2);
        
        gr.setColor(Color.white);
        gr.fillOval(18, 12, 4, 4);
        gr.fillOval(14, 12, 4, 4);
        gr.fillOval(22, 12, 4, 4);
         gr.fillOval(10, 12, 4, 4);
        gr.fillOval(26, 12, 4, 4);
        
        
        
        //adding antennas
       
        gr.setColor(Color.red);
        gr.drawLine(7, 7, 0, 0);
        gr.drawLine(7, 20, 0, 30);
        
        gr.fillOval(-2, -2, 5, 5);
        gr.fillOval(-2, 27, 5, 5);
        
        
        
        Picture enemy = new Picture(im);
        return enemy; //37
    }
}
