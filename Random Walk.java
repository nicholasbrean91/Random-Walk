//Created by: Nicholas Brean
//Created On: Dec 12 2018
//This program randomly walks from inital point to target.

import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.Timer;
  
public class RandomWalk extends JFrame{

	Scanner userInput = new Scanner(System.in);
	private static int width = 250;
	private static int height = 250;
	private static int Sizex = 750;
	private static int Sizey = 750;
	
	
	public RandomWalk(){
        super("Random Walk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setSize(Sizex,Sizey);
        setVisible(true);
	}
	
	
	public void paint(Graphics g){
		
		System.out.println("Enter the size of the target, between 10 and 50");
		int size = userInput.nextInt();
		
		if(size > 50 || size < 10){
			System.out.println("Please enter a value that is higher than 5 but lower than 30 next time.");
			System.exit(0);
		}
		
		super.paint(g);
		Random ran = new Random();
	    int targetx = ran.nextInt((Sizex  - size) / 2);
        int targety = ran.nextInt((Sizey - size) / 2);
		
		g.setColor(Color.RED);
		g.fillOval(targetx, targety, size, size);
		
		g.setColor(Color.BLACK);    
	      do {
	 	 
	    	  Random rand = new Random();
	          int next = rand.nextInt(4)+1;
	          if(next == 1) {
	        	  width +=1;
		      }
		      else if(next == 2) {
		    	  width -= 1 ;
		      }
		      else if(next == 3) {
		    	  height += 1 ;
		      }
		      else if(next == 4) {
		    	  height -= 1 ;
		      }
	          
	          if(width < 0) {
	        	  width = 500;
	          }
	          else if(width > 500) {
	        	  width = 500;
	          }
	          
	          if(height < 0) {
	        	  height = 500;
	          }
	          else if(height > 500) {
	        	  height = 500;
	          }
	          
	          g.drawRect(width, height, 1, 1);
	      }while(width > targetx+size || width < targetx || height > targety+size || height < targety);
	}
		
	
	
	public static void main(String args[]){
		
		RandomWalk walk = new RandomWalk();
		
		
	}
	
}
