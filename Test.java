import javax.swing.JFrame;

public class Test{
    
    public static void main(String args[]){

        GamePanel p = new GamePanel();

        JFrame frame = new JFrame();
        frame.setTitle("Pong Game");
        frame.setSize(650, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(p);
    }
}