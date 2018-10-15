//Created By: Nicholas Brean
//Created On: October 2018
//Random walk program

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import java.util.Random;
import javax.swing.*;    // Using Swing's components and containers
 
public abstract class RandomWalk extends JFrame implements ActionListener {
	Timer t = new Timer(5, this);
	double x = 0, y = 0;
    public static final int CANVAS_WIDTH  = 800;
    public static final int CANVAS_HEIGHT = 800;
    private JFrame f;
    private JPanel p;
   
   private DrawCanvas canvas;
 
   public RandomWalk() {
	    // Generates frame.
	    JFrame frame = new JFrame();

	    // Sets frame resolution and other parameters.
	    frame.setSize(900, 900);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setResizable(false);

	 // f = new JFrame("Random Walk");
	 // f.setVisible(true);
	 // f.setSize(500, 500);
     // f.setDefaultCloseOperation(EXIT_ON_CLOSE);            
      //setTitle("RandomWalk"); 
      //setSize(500, 500);
      //setVisible(true);   
   }
 
   private class DrawCanvas extends JPanel {
      // Override paintComponent to perform your own painting
      int initialPointX = 700;
      int initalPointY = 700;
      int targetPointX = 200;
      int targetPointY = 200;

      public void paintComponent(Graphics g) {
         super.paintComponent(g);    
         setBackground(Color.WHITE); 
         
         g.setColor(Color.RED);       // change the drawing color
         g.fillOval(targetPointX, targetPointY, 20, 20); // Target Point
         
         g.setColor(Color.BLACK);
         g.fillRect(initialPointX, initalPointY, 5, 5); //Inital Point
         t.start();

      }
   
    	  
   }
   }
 
   // The entry main method
   public static void main(String[] args) {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new RandomWalk(); // Let the constructor do the job
         }
      });
   }
}
