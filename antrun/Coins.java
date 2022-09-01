
package antrun;


import basicgraphics.BasicFrame;
import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * This is the super class for the coin sprites. 
 * 
 */
public class Coins extends Sprite{
    /**
    *
    * Default image for coins. 
    * 
    */
    public static int coinsTotal = 0; // number of coins the ant has collected
    
    public static Picture makeCoin(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.fillOval(0, 0, size, size);
        return new Picture(im);
    }
    public Coins(SpriteComponent sc) {
    /**
    *
    * Sets x and y and x and y velocity. 
    * 
    */
 
        
        super(sc);
        
        while (true) {
            setX(AntRun.RAND.nextInt(AntRun.BOARD_SIZE.width)-AntRun.SMALL);
            setY(AntRun.RAND.nextInt(AntRun.BOARD_SIZE.height)-AntRun.SMALL);
            if (Math.abs(getX() - AntRun.BOARD_SIZE.width / 2) < 2 * AntRun.BIG
                    && Math.abs(getY() - AntRun.BOARD_SIZE.height / 2) < 2 * AntRun.BIG) {
                
            } else {
                break;
            }
        }
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
    * Processing the coin sprites when it hits the walls. 
    * 
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
                setY(0); //34
            }
        }

    }
}
