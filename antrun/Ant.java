
package antrun;

import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.awt.image.BufferedImage;


public class Ant extends Sprite{
    public Picture ant;

    public Ant(SpriteComponent sc) {
        super(sc);
        ant = new Picture("ant.png");
        setPicture(ant);
        Dimension d = sc.getSize();
        setX(d.width/2);
        setY(d.height/2);
        setVelX(0);
        setVelY(0);
        
        
        Task time = new Task(){
           public void run(){
            setVelX(getVelX()+.002);
          }
        };
        Clock.addTask(time); 
    }
    
    
    
    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
            setX(sc.getSize().width-getWidth());
        }
        if (se.xhi) {
            setX(0);
        }
        if (se.ylo) {
            setY(sc.getSize().height-getHeight());
        }
        if (se.yhi) {
            setY(0); //25
        }
    }
}
