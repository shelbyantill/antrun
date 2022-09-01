
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
 * @author shelbyantill
 */
public class Enemies extends Sprite{
    static int enemyCount = 0;
    
    public static Picture makeEnemy(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.fillOval(0, 0, size, size);
        return new Picture(im);
    }
    
    public Enemies(SpriteComponent sc) {
        super(sc);
        enemyCount++;
        while (true) {
            
            setX((AntRun.RAND.nextInt(AntRun.BOARD_SIZE.width-100)+100));
            setY((AntRun.RAND.nextInt(AntRun.BOARD_SIZE.height-100)+100));
            if (Math.abs(getX() - AntRun.BOARD_SIZE.width / 2) < 2 * AntRun.BIG
                    && Math.abs(getY() - AntRun.BOARD_SIZE.height / 2) < 2 * AntRun.BIG) {
                
            } else {
                break;
            }
        }
        // A random speed
        setVelX(2 * AntRun.RAND.nextDouble() - 1 );
        setVelY(2 * AntRun.RAND.nextDouble() - 1);
    }
    public void setActive(boolean b) {
        if(isActive() == b)
            return;
        if(b)
            enemyCount++;
        else
            enemyCount--;
        super.setActive(b);
    }
    
    public void processEvent(SpriteCollisionEvent se) {
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
                setY(0); //39
            }
        }

    }
}

