
package antrun;

import static antrun.Enemies.enemyCount;
import static antrun.Enemies.makeEnemy;
import basicgraphics.BasicFrame;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

/**
 *
 * Makes power ups for ant to gain an extra life.
 */
public class PowerUp extends Sprite{
    public static int powerUpsTotal = 0;
    
    public static Picture makePowerUp() {
        /**
        *
        * Makes power ups image.
        */
        Image im = BasicFrame.createImage(24, 24);
        Graphics g = im.getGraphics();
        Color c = new Color(144, 238, 145);
        g.setColor(c);
        Polygon p = new Polygon();
        p.addPoint(12, 0);
        p.addPoint(0, 12);
        p.addPoint(12, 24);
        p.addPoint(24, 12);
        g.fillPolygon(p);
        
        
        Color c1 = new Color(46,139,87);
        g.setColor(c1);
        Polygon p2 = new Polygon();
        p2.addPoint(12, 0);
        p2.addPoint(20, 8);
        p2.addPoint(4, 8);
        g.fillPolygon(p2);
        
        Color c2 = new Color(143,188,143);
        g.setColor(c2);
        Polygon p4 = new Polygon();
        p4.addPoint(12, 0);
        p4.addPoint(16, 4);
        p4.addPoint(8, 4);
        g.fillPolygon(p4);
        
        Color c3 = new Color(85,107,47);
        g.setColor(c3);
        Polygon p3 = new Polygon(); //30
        p3.addPoint(24, 12);
        p3.addPoint(20, 8);
        p3.addPoint(20, 16);
        g.fillPolygon(p3);
        
        Color c4 = new Color(107,142,35);
        g.setColor(c4);
        Polygon p5 = new Polygon();
        p5.addPoint(0, 12);
        p5.addPoint(4, 8);
        p5.addPoint(4, 16);
        g.fillPolygon(p5);
        
        
        g.setColor(c1);
        Polygon p6 = new Polygon();
        p6.addPoint(12, 24);
        p6.addPoint(4, 16);
        p6.addPoint(20, 16);
        g.fillPolygon(p6);
        
        Color c7 = new Color(50,205,50);
        g.setColor(c7);
        Polygon p7 = new Polygon();
        p7.addPoint(12, 24);
        p7.addPoint(16, 20);
        p7.addPoint(8, 20);
        g.fillPolygon(p7);
        
        Color c8 = new Color(143,188,143);
        g.setColor(c8);
        g.drawLine(4, 10, 20, 10);
        g.setColor(c8);
        g.drawLine(4, 14, 20, 14);
        g.setColor(c8); //60
        g.drawLine(4, 12, 20, 12);
        return new Picture(im);
    }
    public PowerUp(SpriteComponent sc) {
        /**
        *
        * Sets power ups x and y velocity with x and y position.
        */
        super(sc);
        powerUpsTotal++;
        setPicture(makePowerUp());
        while (true) {
            setX(AntRun.RAND.nextInt(AntRun.BOARD_SIZE.width)-AntRun.SMALL);
            setY(AntRun.RAND.nextInt(AntRun.BOARD_SIZE.height)-AntRun.SMALL);
            if (Math.abs(getX() - AntRun.BOARD_SIZE.width / 2) < 2 * AntRun.BIG
                    && Math.abs(getY() - AntRun.BOARD_SIZE.height / 2) < 2 * AntRun.BIG) {
                // Overlaps with center, try again
            } else {
                break;
            }
        }
        // A random speed
        setVelX(2 * AntRun.RAND.nextDouble() - 1);
        setVelY(2 * AntRun.RAND.nextDouble() - 1);
    }
    public void setActive(boolean b) {
        if(isActive() == b)
            return;
        
        super.setActive(b);
    }
    
    public void processEvent(SpriteCollisionEvent se) {
        /**
        *
        * Processes when power up hits a wall.
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
                setY(0); //90
            }
        }
    }
}
