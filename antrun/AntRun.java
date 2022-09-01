
package antrun;

import basicgraphics.BasicContainer;
import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import basicgraphics.sounds.ReusableClip;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * HOW DOES THE GAME WORK?
 * AntRun takes inspiration from Temple Run or Super Mario Run.
 * 
 * The main character is an ant, which the user is acting as. 
 * The ant has to dodge its red/purple bug enemies (there are normal enemies and boss enemies).
 * While the ant is dodging these enemies, it has to collect all the yellow/gold coins in the round. 
 * 
 * 
 * If it collects all the coins, it moves on to the next round.
 * If it dies by an enemy before it gets to collect the coins, it dies and explodes.
 * Then, the game exits and the user lost. 
 * There are 5 rounds in total, so if the ant beats all 5, it wins the game.
 * 
 * 
 * There will be 1-2 power-ups in each round. 
 * These are green an make the ant larger. They give the ant an extra 
 * life and ability to kill an enemy it collides with.
 * 
 * The number of enemies, ants, and power-ups will depend on the round.
 * But, the game will specify how many before the round starts. 
 * 
 * Use the up and down arrows to move across the ground.
 * 
 * 
 * REMEMBER (Cheat Sheet): 
 * 
 * Enemies: smaller and reddish/purple (you want to avoid)
 * 
 * Boss Enemies: bigger and reddish/purple (you want to avoid)
 * 
 * Coins: gold/yellow circles (you want to collect)
 * 
 * Power Ups: green diamonds (you want to collect. will give you extra life) 
 * 
 * Use up and down arrows to move. 
 * 
 * If you die, expect a big explosion of your body. 
*/




public class AntRun { 
    
    //final cconstant variables
    
    final public static int POWERUPS = 2; // max number of powerups for round 1
    final public static Random RAND = new Random(); //random number
    final public static Dimension BOARD_SIZE = new Dimension(1000,600); //board size
    final public static int BIG = 20;
    final public static int SMALL = 5;
    final public static Color GROUNDCOLOR = new Color(210, 180, 140);
    final public static int DIRTNUMBER1 = 45;
    final public static Color DIRTCOLOR1 = new Color(102,51,0);
    final public static int DIRTNUMBER2 = 50;
    final public static Color DIRTCOLOR2 = new Color(205,133,63);
    final public static int DIRTNUMBER3 = 40;
    final public static Color DIRTCOLOR3 = new Color(139,69,19);
    final public static int DIRTNUMBER4 = 55;
    final public static Color DIRTCOLOR4 = new Color(73,40,40);
    final public static Picture ANT = new Picture("ant.png"); 
    final public static ReusableClip clip = new ReusableClip("beep.wav");//coins
    final public static ReusableClip clip2 = new ReusableClip("arrow.wav");// explosion
    
    
    
    //non final  variables for this class
   
    public static int COINS = 4; //total number of coins to be collected - can change depending on round
    public static int COIN_TYPES = COINS/2; //amount of each coin type present
    public static boolean power = false; 
    public static boolean power2 = false; 
    public static boolean round1 = true; 
    public static boolean round2 = false; 
    public static boolean round3 = false; 
    public static boolean round4 = false; 
    public static boolean round5 = false; 
    public static LinkedList <Enemies>eList = new LinkedList<>();
    public static LinkedList <Coins>cList = new LinkedList<>();
    public static LinkedList <PowerUp>pList = new LinkedList<>();  //30
    
    
    public static void startRound2(SpriteComponent sc){
        /**
         * ROUND 2
         * 
         * deletes current enemy and power up sprites from the frame and adds new ones
         * 
         */
        
        Coins.coinsTotal = 0; //number of coins the ant has collected in round
        COINS = 6; // number of coins it needs to collect
        power = false; 
        power2 = false; 
        
        
        JOptionPane.showMessageDialog(sc, "You are now commencing round 2. \n"
                + "You have 6 enemies & "
                +" 1 powerup. \n"
                + "You have "+COINS+" coins to collect. Good luck!");
        for(Object e: eList){
            sc.removeSprite((Enemies)e);
        }
        eList.clear();
        
        for(Object c: cList){
            sc.removeSprite((Coins)c);
        }
        cList.clear();
        
        for(Object p: pList){
            sc.removeSprite((PowerUp)p);
        }
        pList.clear();
        
        Clock.start(40);
        
        
        for(int i=0;i<2;i++) {
            Enemy1 en1 = new Enemy1(sc);
            eList.add(en1);
            Enemy2 en2 = new Enemy2(sc);
            eList.add(en2);
        }
        Enemy3 en3 = new Enemy3(sc);
        eList.add(en3);
            Enemy4 en4 = new Enemy4(sc);
        eList.add(en4);
        
        
        for(int i=0;i<3;i++) {
            Coins coin1 = new Coin1(sc); //60
            cList.add(coin1);
            Coins coin2 = new Coin2(sc);
            cList.add(coin2);
        }
        for(int i=0;i<1;i++) {
            PowerUp pu = new PowerUp(sc);
            pList.add(pu);
        }
        
    }
    
    public static void startRound3(SpriteComponent sc){
        
        /**
         * ROUND 3
         * 
         * deletes current enemy and power up sprites from the frame and adds new ones
         * 
         */
        
        Coins.coinsTotal = 0; //number of coins the ant has collected in round
        COINS = 4;
        power= false; 
        power2 = false; 
        
        JOptionPane.showMessageDialog(sc, "You are now commencing round 3. \n"
                + "You will have 6 boss enemies & 2 powerups. \n"
                + "You have "+COINS+" coins to collect. Good luck!");
        for(Object e: eList){
            sc.removeSprite((Enemies)e);
        }
        eList.clear();
        
        for(Object c: cList){
            sc.removeSprite((Coins)c);
        }
        cList.clear();
        
        for(Object p: pList){
            sc.removeSprite((PowerUp)p);
        }
        pList.clear();
        
        Clock.start(35);
        
        
        
        for(int i=0;i<COINS/2;i++) {
            Coins coin1 = new Coin1(sc);
            cList.add(coin1);
            Coins coin2 = new Coin2(sc);
            cList.add(coin2);
        }
        for(int i=0;i<2;i++) { //90
            PowerUp pu = new PowerUp(sc);
            pList.add(pu);
        }
        
        for(int i = 0; i<2;i++){ //boss enemies
            BossEnemy1 be1 = new BossEnemy1(sc);
            eList.add(be1);
            BossEnemy2 be2 = new BossEnemy2(sc);
            eList.add(be2);
            BossEnemy3 be3 = new BossEnemy3(sc);
            eList.add(be3);
        }
       
    }
    
    
    public static void startRound4(SpriteComponent sc){
        
        
        /**
         * ROUND 4
         * 
         * deletes current enemy and power up sprites from the frame and adds new ones
         * 
         */
        
        
        Coins.coinsTotal = 0; //number of coins the ant has collected in round
        COINS = 6;  //coins to collect
        power = false; 
        power2 = false; 
        
        JOptionPane.showMessageDialog(sc, "You are now commencing round 4. \n"
                + "You will have 8 boss enemies & 1 powerups. \n"
                + "You have "+COINS+" coins to collect. Good luck!");
        
        for(Object e: eList){
            sc.removeSprite((Enemies)e);
        }
        eList.clear();
        
        for(Object c: cList){
            sc.removeSprite((Coins)c);
        }
        cList.clear();
        
        for(Object p: pList){
            sc.removeSprite((PowerUp)p);
        }
        pList.clear();
        
        Clock.start(30);
        
       
        
        for(int i=0;i<3;i++) {
            Coins coin1 = new Coin1(sc);
            cList.add(coin1); //120
            Coins coin2 = new Coin2(sc);
            cList.add(coin2);
        }
        for(int i=0;i<1;i++) {
            PowerUp pu = new PowerUp(sc);
            pList.add(pu);
        }
        
        for(int i = 0; i<2;i++){ //boss enemies
            BossEnemy1 be1 = new BossEnemy1(sc);
            eList.add(be1);
            BossEnemy2 be2 = new BossEnemy2(sc);
            eList.add(be2);
            BossEnemy3 be3 = new BossEnemy3(sc);
            eList.add(be3);
        }
        BossEnemy1 be1 = new BossEnemy1(sc);
        eList.add(be1);
        BossEnemy2 be2 = new BossEnemy2(sc);
        eList.add(be2);
      
        
        
        
    }
    
    
    public static void startRound5(SpriteComponent sc){
        
        /**
         * ROUND 5
         * 
         * deletes current enemy and power up sprites from the frame and adds new ones
         * 
         */
        
        
        Coins.coinsTotal = 0; //number of coins the ant has collected in round
        COINS = 6;  //coins to collect
        power = false; 
        power2 = false; 
        
        JOptionPane.showMessageDialog(sc, "You are now commencing round 5. \n"
                + "You will have 3 boss enemies & 4 normal enemies & 1 powerup. \n"
                + "You have "+COINS+" coins to collect. Good luck!");
        for(Object e: eList){
            sc.removeSprite((Enemies)e);
        }
        eList.clear();
        
        for(Object c: cList){
            sc.removeSprite((Coins)c);
        }
        cList.clear();
        
        for(Object p: pList){ //150
            sc.removeSprite((PowerUp)p);
        }
        pList.clear();
        
        Clock.start(30);
        
        
        for(int i=0;i<3;i++) {
            Coins coin1 = new Coin1(sc);
            cList.add(coin1);
            Coins coin2 = new Coin2(sc);
            cList.add(coin2);
        }
        for(int i=0;i<1;i++) {
            PowerUp pu = new PowerUp(sc);
            pList.add(pu);
        }
        
        BossEnemy1 be1 = new BossEnemy1(sc);
        eList.add(be1);
        BossEnemy2 be2 = new BossEnemy2(sc);
        eList.add(be2);
        BossEnemy3 be3 = new BossEnemy3(sc);
        eList.add(be3);
        Enemy1 e1 = new Enemy1(sc);
        eList.add(e1);
        Enemy2 e2 = new Enemy2(sc);
        eList.add(e2);
        Enemy3 e3 = new Enemy3(sc);
        eList.add(e3);
        Enemy4 e4 = new Enemy4(sc);
        eList.add(e4);
        
    }


    public static void main(String[]args){
        
        /**
         * Creates basic frame, starts first round as default, contains collision events, and key control.
         * Runs the actual game.
         * 
         */
        BasicFrame bf = new BasicFrame("Ant Run");
        final Container content = bf.getContentPane();
        final CardLayout cards = new CardLayout();
        content.setLayout(cards); //180
        BasicContainer bc1 = new BasicContainer();
        content.add(bc1,"Splash");
        final BasicContainer bc2 = new BasicContainer();
        content.add(bc2,"Game");
        
        
        // makes background 
        
        
        SpriteComponent sc = new SpriteComponent(){
            @Override
            public void paintBackground(Graphics g) {
                Dimension d = getSize();
                g.setColor(GROUNDCOLOR);
                g.fillRect(0, 0, d.width, d.height);
                Random rand = new Random();  //100
                rand.setSeed(0);
                g.setColor(DIRTCOLOR1);
                for(int i=0;i<DIRTNUMBER1;i++) {
                    int diameter = rand.nextInt(5)+1;
                    int xpos = rand.nextInt(d.width);
                    int ypos = rand.nextInt(d.height);
                    g.fillOval(xpos, ypos, diameter, diameter);
                }
                g.setColor(DIRTCOLOR2);
                for(int i=0;i<DIRTNUMBER2;i++) {
                    int diameter = rand.nextInt(5)+1;
                    int xpos = rand.nextInt(d.width);
                    int ypos = rand.nextInt(d.height);
                    g.fillOval(xpos, ypos, diameter, diameter); 
                }
                g.setColor(DIRTCOLOR3);
                for(int i=0;i<DIRTNUMBER3;i++) {
                    int diameter = rand.nextInt(5)+1;
                    int xpos = rand.nextInt(d.width);
                    int ypos = rand.nextInt(d.height);
                    g.fillOval(xpos, ypos, diameter, diameter);
                }
                g.setColor(DIRTCOLOR4); //210
                for(int i=0;i<DIRTNUMBER4;i++) {
                    int diameter = rand.nextInt(5)+1;
                    int xpos = rand.nextInt(d.width);
                    int ypos = rand.nextInt(d.height);
                    g.fillOval(xpos, ypos, diameter, diameter);
                }
            }
        };
         
        
        Dimension d = new Dimension(BOARD_SIZE);
        sc.setPreferredSize(d);
        
        //buttons for start
       String[][] splashLayout = {
            {"Title"},
            {"Button"}
        };
        bc1.setStringLayout(splashLayout);
        bc1.add("Title",new JLabel("Ant Run Game"));
        JButton jstart = new JButton("Start");
        jstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content,"Game");
                //instructions message
                JOptionPane.showMessageDialog(sc, "Welcome to AntRun!\n\n"+
                        "You will be placed on the ground as an ant\n"
                        + "where you will have to dodge enemies\n"
                        + "(red/purple bugs) and collect gold coins.\n\n"
                        + "You will get 1-2 green powerups for each round.\n"
                        + "Your size will grow for each one you collect.\n"
                        + "Each powerup gives you an extra life and ability to \n"
                        + "kill an enemy you collide with. \n\n"
                        + "There are 5 rounds.You will only move on to the next round\n"
                        + "if you collect all the coins within that round.\n\n"
                        + "If you are killed, you lose and your body explodes.\n\n"
                        + "Use up and down arrows to move across the ground."
                         
                );
                JOptionPane.showMessageDialog(sc, "You are now commencing round 1. \n"  + 
                   "You will have 4 enemies & 2 powerups. \n"  //240
                + "You have "+COINS+" coins to collect. Good luck!");
                        
                bc2.requestFocus();
                Clock.start(15);
               
            }
        });
        bc1.add("Button",jstart);
        String[][] layout = {{
            "Ant"
        }};
        bc2.setStringLayout(layout);
        bc2.add("Ant",sc); 
        
        //creates ant sprite that user will use
        Ant ant = new Ant(sc);
        Clock.addTask(sc.moveSprites());
        
        ant.setPicture(ant.ant);
    
       
        
        //keys that control the ant
    KeyAdapter control = new KeyAdapter(){
        public void keyPressed( KeyEvent event){
            if(event.getKeyCode() == KeyEvent.VK_DOWN){
                ant.setY(ant.getY()+8);
            }
            else if(event.getKeyCode() == KeyEvent.VK_UP){
                ant.setY(ant.getY()-8);
            }
           
        }
    };
       
       
        
      
    
         //round 1 sprites
        for(int i=0;i<COIN_TYPES;i++) {
            Coins coin1 = new Coin1(sc);
            cList.add(coin1);
            Coins coin2 = new Coin2(sc);
            cList.add(coin1);
        }
        
       
            Enemy1 en1 = new Enemy1(sc);
            eList.add(en1);
            Enemy2 en2 = new Enemy2(sc);
            eList.add(en2);
            Enemy3 en3 = new Enemy3(sc);
            eList.add(en3);
            Enemy4 en4 = new Enemy4(sc); //270
            eList.add(en4);
        

        
        for(int i=0;i<POWERUPS;i++) {
            PowerUp pu = new PowerUp(sc);
            pList.add(pu);
        }
    

    // collision event between Ant and Coins
    sc.addSpriteSpriteCollisionListener(Coins.class, Ant.class, new SpriteSpriteCollisionListener<Coins, Ant>() {
            
            @Override
            public void collision(Coins sp1, Ant sp2) {
                
                    clip.play();
                    sp1.setActive(false);
                    sp2.setActive(true);
                    Coins.coinsTotal++;
                    if(Coins.coinsTotal == COINS){ 

                        if(round1 == true && round2 == false && round3 == false && round4 == false && round5 == false){
                            round1=false;
                            ant.setY(0);
                            ant.setX(0);
                            Clock.stop();
                            round2 = true;
                            JOptionPane.showMessageDialog(sc, "You win the first round! \n"
                                + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                            ant.setPicture(ant.ant);
                            startRound2(sc);

                        }
                        else if (round2 = true && round1 == false && round3 == false && round4 == false && round5 == false){
                            round2= false;
                            ant.setY(0);
                            ant.setX(0);
                            Clock.stop();
                            round3 = true;
                            JOptionPane.showMessageDialog(sc, "You win the second round! \n"
                                + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins."); 
                            ant.setPicture(ant.ant); //300
                            startRound3(sc);
                        }
                        else if(round3 = true && round4 == false && round2 == false && round1 == false && round5 == false){
                            round3= false;
                            ant.setY(0);
                            ant.setX(0);
                            Clock.stop();
                            round4 = true;
                            JOptionPane.showMessageDialog(sc, "You win the third round! \n"
                                + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins."); 
                            ant.setPicture(ant.ant);
                            startRound4(sc);
                        }
                        else if(round4 = true && round2 == false && round3 == false && round1 == false && round5 == false){
                            round4= false;
                            ant.setY(0);
                            ant.setX(0);
                            Clock.stop();
                            round5 = true;
                            JOptionPane.showMessageDialog(sc, "You win the fourth round! \n"
                                + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins."); 
                            ant.setPicture(ant.ant);
                            startRound5(sc);
                        }   
                        else{
                            Clock.stop();
                            JOptionPane.showMessageDialog(sc, "You win the fifth round! Game Over! \n"
                                + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                            System.exit(0);
                        }

                    }
                }
            
        });
    
    
     // collision event between Ant and Enemy 1
     sc.addSpriteSpriteCollisionListener(Enemy1.class, Ant.class, new SpriteSpriteCollisionListener<Enemy1, Ant>() {
            
            @Override
            public void collision(Enemy1 sp1, Ant sp2) {
                if(power==true){
                    power=false; //330
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT);
                }
                else if(power2==true){
                    power=true;
                    power2=false;
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT.resize(1.3));
                }
                else if(Coins.coinsTotal == COINS){
                    sp1.setActive(false);
                    sp2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You Win! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                    System.exit(0);
                }
                else{
                    clip2.play();
                    Explosion n = new Explosion(sc,sp1.getX(), sp1.getY(), "1");
                    sp1.setActive(true);
                    sp2.setActive(false);
                    
                    
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.\n"
                            + "A googly-eyed enemy killed you !!");
                    System.exit(0);
                    
                    
                }
            }
            

            
        });
     
    // collision event between Ant and Enemy 2
     sc.addSpriteSpriteCollisionListener(Enemy2.class, Ant.class, new SpriteSpriteCollisionListener<Enemy2, Ant>() {
            
            @Override
            public void collision(Enemy2 sp1, Ant sp2) {
                if(power==true){
                    power=false;
                    sp1.setActive(false);
                    sp2.setActive(true); //360
                    ant.setPicture(ANT);
                }
                else if(power2==true){
                    power=true;
                    power2=false;
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT.resize(1.3));
                }
                else if(Coins.coinsTotal == COINS){
                    sp1.setActive(false);
                    sp2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You Win! Game Over! \n" 
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                    System.exit(0);
                }
                else{
                    clip2.play();
                    Explosion n = new Explosion(sc,sp1.getX(), sp1.getY(), "2");
                    sp1.setActive(true);
                    sp2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.\n"
                            + "A scared spider enemy killed you !!");
                    System.exit(0);
                }
            }
            

            
        });
     
    // collision event between Ant and Enemy 3
     sc.addSpriteSpriteCollisionListener(Enemy3.class, Ant.class, new SpriteSpriteCollisionListener<Enemy3, Ant>() {
            
            @Override
            public void collision(Enemy3 sp1, Ant sp2) {
                if(power==true){
                    power=false;
                    sp1.setActive(false);
                    sp2.setActive(true); 
                    ant.setPicture(ANT);
                }
                else if(power2==true){ //390
                    power=true;
                    power2=false;
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT.resize(1.3));
                }
                else if(Coins.coinsTotal == COINS){
                    sp1.setActive(false);
                    sp2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You Win! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                    System.exit(0);
                }
                else{
                    clip2.play();
                    Explosion n = new Explosion(sc,sp1.getX(), sp1.getY(), "3");
                    sp1.setActive(true);
                    sp2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.\n"
                            + "A dumb butterfly enemy killed you !!");
                    System.exit(0);
                }
            }
            

            
        });
    // collision event between Ant and Enemy 4
    sc.addSpriteSpriteCollisionListener(Enemy4.class, Ant.class, new SpriteSpriteCollisionListener<Enemy4, Ant>() {
            
            @Override
            public void collision(Enemy4 sp1, Ant sp2) {
                if(power==true){
                    power=false;
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT);
                }
                else if(power2==true){
                    power=true;
                    power2=false; //420
                    sp1.setActive(false); 
                    sp2.setActive(true);
                    ant.setPicture(ANT.resize(1.3));
                }
                else if(Coins.coinsTotal == COINS){
                    sp1.setActive(false);
                    sp2.setActive(false); //300
                    JOptionPane.showMessageDialog(sc, "You Win! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                    System.exit(0);
                }
                else{
                    clip2.play();
                    Explosion n = new Explosion(sc,sp1.getX(), sp1.getY(), "4");
                    sp1.setActive(true);
                    sp2.setActive(false);
                   
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.\n"
                            + "The evil beatle enemy killed you !!");
                    System.exit(0);
                }
            }
            

            
        });
    
    
    // collision event between Ant and Boss Enemy 1
    sc.addSpriteSpriteCollisionListener(BossEnemy1.class, Ant.class, new SpriteSpriteCollisionListener<BossEnemy1, Ant>() {
            
            @Override
            public void collision(BossEnemy1 sp1, Ant sp2) {
                
                if(power==true){
                    power=false;
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT);
                }
                else if(power2==true){
                    power=true;
                    power2=false;
                    sp1.setActive(false); 
                    sp2.setActive(true); //450
                    ant.setPicture(ANT.resize(1.3));
                }
                else if(Coins.coinsTotal == COINS){
                    sp1.setActive(false);
                    sp2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You Win! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                    System.exit(0);
                }
                else{
                    clip2.play();
                    Explosion n = new Explosion(sc,sp1.getX(), sp1.getY(), "1B");
                    
                    sp1.setActive(true);
                    sp2.setActive(false);
                    
                    
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over! \n"
                                + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.\n"
                                + "A boss googly-eyed enemy killed you !!");
                    System.exit(0);
                    
                    
                }
            }
            

            
        });
    // collision event between Ant and Boss Enemy 2
    sc.addSpriteSpriteCollisionListener(BossEnemy2.class, Ant.class, new SpriteSpriteCollisionListener<BossEnemy2, Ant>() {
            
            @Override
            public void collision(BossEnemy2 sp1, Ant sp2) {
                if(power==true){
                    power=false;
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT);
                }
                else if(power2==true){
                    power=true;
                    power2=false;
                    sp1.setActive(false); 
                    sp2.setActive(true);
                    ant.setPicture(ANT.resize(1.3));
                }
                else if(Coins.coinsTotal == COINS){ //480
                    sp1.setActive(false);
                    sp2.setActive(false);
                    JOptionPane.showMessageDialog(sc, "You Win! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                    System.exit(0);
                }
                else{
                    clip2.play();
                   Explosion n = new Explosion(sc,sp1.getX(), sp1.getY(), "2B");
                    
                   sp1.setActive(true);
                   sp2.setActive(false);
                   
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.\n"
                            + "A boss long diamond enemy killed you !!");
                    
                   
                    System.exit(0);
                    
                    
                }
            }
            

            
        });
    
    // collision event between Ant and Boss Enemy 3
    sc.addSpriteSpriteCollisionListener(BossEnemy3.class, Ant.class, new SpriteSpriteCollisionListener<BossEnemy3, Ant>() {
            
            @Override
            public void collision(BossEnemy3 sp1, Ant sp2) {
                if(power==true){
                    power=false;
                    sp1.setActive(false);
                    sp2.setActive(true);
                    ant.setPicture(ANT);
                }
                else if(power2==true){
                    power=true;
                    power2=false;
                    sp1.setActive(false); 
                    sp2.setActive(true);
                    ant.setPicture(ANT.resize(1.3));
                }
                else if(Coins.coinsTotal == COINS){
                    sp1.setActive(false);
                    sp2.setActive(false); //510
                    JOptionPane.showMessageDialog(sc, "You Win! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.");
                    System.exit(0);
                }
                else{
                    clip2.play();
                   Explosion n = new Explosion(sc,sp1.getX(), sp1.getY(), "3B");
                    
                   sp1.setActive(true);
                   sp2.setActive(false);
                   
                    
                    JOptionPane.showMessageDialog(sc, "You lose! Game Over! \n"
                            + "You collected "+ Coins.coinsTotal +"/" +COINS+ " coins.\n"
                            + "A boss evil beatle enemy killed you !!");
                    System.exit(0);
                    
                    
                }
            }
            

            
        });
    
    // collision event between Ant and Power Up
    sc.addSpriteSpriteCollisionListener(PowerUp.class, Ant.class, new SpriteSpriteCollisionListener<PowerUp, Ant>() {
            
            @Override
            public void collision(PowerUp sp1, Ant sp2) {
                
                
                sp1.setActive(false);
                sp2.setActive(true);
                if(power==true){
                    power2=true;
                    power=false;
                    ant.setPicture(ANT.resize(1.6));
                }
                else{
                    power = true;
                    power2=false;
                    ant.setPicture(ANT.resize(1.3));
                }
                
                
            }
        });
    bc2.addKeyListener(control);
        
    
    bf.show(); //536
    }
    
    
   
}
