

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener, KeyListener{
        
    public boolean running = false;
    public int padleY1 = 0;
    public int padleY2 = 0;

    public int ballX = 200;
    public int ballY = 300;

    public int ballXDir = 1;    
    public int ballYDir = 1;

    public int score = 0;

    public Timer timer;

    public int delay = 8;
    int player1 = 0;
    int player2 = 0;
    public Random r;
    int c1 = 0;
    int c2 =0;
    int c3 = 0;

    public GamePanel(){
        this.addKeyListener(this);
        this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
        timer = new Timer(delay,this);
        r= new Random(255);
        timer.start();
    }

    public void paint(Graphics g){

        g.fillRect(10, 10, 630, 630);
        g.setColor(Color.BLACK);

        g.fillRect(0, 0, 650, 10);
        g.setColor(Color.yellow);
        g.fillRect(0, 640, 650, 10);
        g.setColor(Color.yellow);

        g.fillRect(0, 0, 10, 650);
        g.setColor(Color.yellow);
        g.fillRect(640, 0, 10, 650);
        g.setColor(Color.yellow);

        g.setColor(Color.green);
        g.fillRect(10, padleY1, 10, 50);
        
        g.setColor(Color.red);
        g.fillRect(630, padleY2, 10, 50);

        g.setColor(Color.white);
        g.drawLine(325, 0, 325, 650);

        g.setColor(new Color(c1,c2,c3));
        g.fillOval(ballX, ballY, 20, 20);

        g.setColor(Color.blue);
        g.setFont(new java.awt.Font("Mv boli", 1, 20));
        g.drawString("PLayer One "+player1, 100, 100);

        g.setColor(Color.pink);
        g.setFont(new java.awt.Font("Mv boli", 1, 20));
        g.drawString("PLayer One "+player2, 400, 100);


        if(ballX<0){
            
            running = false;

            g.setColor(Color.green);
            g.setFont(new java.awt.Font("Mv boli", 1, 20));
            g.drawString("Fuck You ", 100, 170);
        }
        if(ballX>620){
            
            running = false;
            g.setColor(Color.blue);
            g.setFont(new java.awt.Font("Mv boli", 1, 20));
            g.drawString("Fuck You ", 400, 170);
        }

        g.dispose();
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            if(padleY2<=0){
                padleY2 = 0;
            }else{
                moveUp2();
            }
            System.out.println(padleY2);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            if(padleY2>=550){
                padleY2 = 550;
            }else{
                moveDown2();
            }
            System.out.println(padleY2);
        }
        if(e.getKeyCode()==KeyEvent.VK_W){
            if(padleY1<=0){
                padleY1 = 0;
            }else{
                moveUp1();
            }
            System.out.println(padleY1);
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            if(padleY1>=550){
                padleY1 = 550;
            }else{
                moveDown1();
            }
            System.out.println(padleY1);
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            timer.start();
            ballX = 200;
            ballY = 300;
        }
    }

    public void moveUp1(){
        running = true;
        padleY1 -= 20;
    }
    public void moveDown1(){
        running = true;
        padleY1 += 20;
    }
    public void moveUp2(){
        running = true;
        padleY2 -= 20;
    }
    public void moveDown2(){
        running = true;
        padleY2 += 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
       timer.start();

       if(running){
            ballX += ballXDir;
            ballY += ballYDir;

            c1 = r.nextInt(255);
            c2 = r.nextInt(255);
            c3 = r.nextInt(255);

            System.out.println(ballX+" "+ballY );
            if(ballY<0){
                ballYDir = -ballYDir;
            }
            
            if(ballY>620){
                ballYDir = -ballYDir;
            }

            if(ballY>=padleY1 && ballY<=padleY1+50 && ballX<=20){
                ballXDir = -ballXDir;
                player1++;
                
            }
            if(ballY>=padleY2 && ballY<=padleY2+50 && ballX>=620){
                ballXDir = -ballXDir; 
                player2++;             
            }

            if(ballX<0){
                
                running = false;
                timer.stop();
            }
            if(ballX>620){
                
                running = false;
                timer.stop();
                
            }

            
            
       }

       repaint();
    }




}
