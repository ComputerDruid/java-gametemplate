//NEW PROGRAMMER'S JAVA GAME TEMPLATE

//-------------------------------------------------------------------
//All right, this is an extremely basic template that you can use
// to make a simple java game.  I will try to thoroughly explain
// each line of code, DO NOT BE INTIMIDATED BY THE BLOCKS OF MY
// COMMENTS.  While I have a bad habit of over-explaining, the real
// things you NEED to read will be marked as such.  Each line of code
// that needs explaining will be on the following line.
//
//I will put an pound (#) before any comments that I feel are
// essential to understand.
//
//This is a TEMPLATE, as of now it will only display a window.
// Everything you need to make basic stuff happen is here.
//
//
//-------------------------------------------------------------------

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
//The above packages are necessary to handle keyboard input,
//	display windows, handle timers, and pretty much everything
// you'd need at this point.  If you wanted to implement music,
// or perhaps 3D graphics, you would need to implement the
// packages here.

public class GameTemplate extends JPanel {
	public BufferedImage myImage;
	//You are creating a BufferedImage here.  What this
	//	basically does is creates an area of the window to draw all
	// your crap on.
	public Graphics2D buffer;
	//To make sure the image is displayed correctly, you need to
	// 'buffer' it.  What this means is that it draws the your
	// stuff onto the main image, but it only DISPLAYS it after it's
	// completely done drawing.  This avoids annoying 'flickery'
	// effects that come up when your screen displays stuff.
	public Timer t = new Timer(30, new Listener());
	//#All right, you need to know what this does.  Here, you are
	// instantiating a Timer object.  The parameters for this object
	// are the (1) milliseconds between each call, and (2) what method
	// the timer calls.  This will make more sense later, but understand
	// that this is what makes your program 'run'.  Essentially, this is
	// your 'while' loop to do stuff.  Right now, the first argument
	// is set at '30', a good enough number with whatever you're doing.
	// You can fool around with the settings later.

	final int WINDOWX = 600, WINDOWY = 600;
	//#The dimensions of your game.  Will be called upon later a lot.
	final int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3, SPACE = 4;
	boolean[] keys = new boolean[5];
	//#The two above lines are a cool way to keep track of what keys are
	// pressed down.  Each declared key's status is marked by a boolean.
	// When the boolean is TRUE, the key is pressed down.  When the boolean
	// is FALSE, the key is not pressed.  This will be explained more later
	// with the KeyListener.
	// And example of using the array would be:
	// 	if(keys[RIGHT])
	//		{
	//			character_x_position+=5;
	//		}
	// You can add more keys you wish to use in the game later, but for now
	// I've only implemented LEFT, UP, RIGHT, DOWN, and SPACE.

	public GameTemplate() {
		myImage = new BufferedImage(WINDOWX, WINDOWY, BufferedImage.TYPE_INT_RGB);
		//#This template is based on a WINDOWX by WINDOWY window display.
		// If you run this program without modifying anything, a black window
		// should appear with the dimensions of 600 by 600.
		buffer = (Graphics2D)myImage.getGraphics();
		//The buffer calls on the BufferedImage object instantiated earlier.
		addKeyListener(new KeyListener());
		//Makes sure the program will actually detect key strokes.  You need this
		// line if you are creating a game that requries input(which is very likely.)
		setFocusable(true);
		//The window can be 'focused', or clicked on.
		setPreferredSize(new Dimension(WINDOWX, WINDOWY));
		//Sets the PreferredSize of the Component GameTemplate as WINDOWX,WINDOWY.
		//  This will be called later when drawing the game area on the frame.
		t.start();
		//#Starts the timer instantiated earlier.  Remember, all of the code above is
		// executed at the very beginning of the game, and only ONCE.

	}
	public void roomMath() {
		//#This is where you will put all the 'math' or game code. The most essential
		// thing this method should be handling is parsing player input (remember the
		// boolean array), and making everything work together.
	}

	public void roomDraw() {
		//#This is where you will put all the display elements of the game.  Displaying
		// elements is very easy.  The object you are drawing stuff to is the BUFFER,
		// not the actual image itself.  So you will be calling the buffer object, which
		// is conveniently named 'buffer'.
		//
		//  Try uncommenting the following example lines to see what they do:
		//		buffer.setColor(Color.blue);
		//		buffer.fillRect(100,100,200,100);
		//		buffer.setColor(Color.red);
		//		buffer.fillOval(300,300,100,200);
		//		buffer.setColor(Color.white);
		//		buffer.drawString("Hello world!", 50, 400);
		//
		// If you wanted to draw an oval shape of size 50 pixels by 50 pixels
		//  at the position marked by the variables 'playerx' and 'playery', then
		//  you would use the line of code:
		// 	buffer.fillOval(playerx,playery,50,50);
		//
		// Of course, if there are moving elements of your display, you'd probably
		//  want to draw the background over everything at the beginning of this method.
		// 	Redrawing the background as the color BLACK:
		//			buffer.setColor(Color.black);
		//			buffer.fillRect(0,0,WINDOWX,WINDOWY);
		//		The window size was 600x600, remember?

		repaint();
		//Essential if you want your window to update its display
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//#Everything in this method is called by the 'Timer' declared at the
			// beginning.  If you didn't change it's rate, this method will be called
			// once every 30 milliseconds.
			roomMath();
			roomDraw();
			//#Usually, most of the math and calculations are done before drawing stuff.
			// While you CAN just put all your code mixed together in the actionPerformed
			// method, it will be confusing and may cause you problems.  Leave this code
			// block untouched for now: only put your new code into the methods roomMath()
			// and roomDraw()
		}
	}
	public class KeyListener extends KeyAdapter {
		//#I've gone ahead and handled all the basic movement functions already.
		// If you want to add more keys to the game however, you need to add
		// stuff to this.  Follow the general format and you should be fine.
		public void keyPressed(KeyEvent e) {
			//This method is called when you press ANY KEY!  The key you pressed
			// is taken in as an event called 'e' in this case, and parsed below.
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				keys[SPACE] = true;
				//If the key pressed is SPACE, then we set the boolean keys[SPACE]
				// to true! This is same for all the following keys.
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				keys[RIGHT] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				keys[UP] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				keys[LEFT] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				keys[DOWN] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				System.exit(0);
			//You can take out the above to lines if you don't want players
			// to be able to quit when you press 'ESCAPE'.
		}
		public void keyReleased(KeyEvent e) {
			//This method is called when you press ANY KEY!  The key you pressed
			// is taken in as an event called 'e' in this case, and parsed below.
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				//If the key released is SPACE, then we set the boolean keys[SPACE]
				// to false! This is same for all the following keys.
				keys[SPACE] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				keys[RIGHT] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				keys[UP] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				keys[LEFT] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				keys[DOWN] = false;
			}
		}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, WINDOWX, WINDOWY, null);
		//Rightio, you won't be messing with this much at all.  Remember if you change
		// the window dimensions in the code above, you need to change it here too!
	}
	public static void main(String[] args) {
		//#THE MAIN METHOD. THIS IS WHAT IS CALLED FIRST THING!!! THIS CREATES YOUR
		// WINDOW AND PUTS THE GAME CLASS INTO THE WINDOW.


		JFrame frame = new JFrame("Game");
		//The actual window will have the caption: "Game"  You can change it to whatever
		// you want.
		frame.setLocationRelativeTo(null);
		//This neat method of code makes sure your window is exactly in the middle of the
		// player's screen.  If you want to set the exact position on the screen for the
		// player, comment out the above line and use:
		//   frame.setLocation(xpos,ypos);
		//	where xpos and ypos are where you want it to be
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Don't change this please.  When you close the window, the process ends.
		// Neat, huh?
		frame.setResizable(false);
		//If you don't want people to resize the playing area, set this to false.
		frame.setContentPane(new GameTemplate());
		//Right, if you changed the name of the main class up at the top, you will need
		// to change this too.  There are two other instances of this name in the above
		// code.  They ALL need to be the same if you want it to work correctly.
		frame.pack();
		//This makes sure you can see the entire game area in the frame.  the pack() method
		// sets the size of the frame to the PreferredSize as set in the GameTemplate() class.
		frame.setVisible(true);
		//Do you want the player to be able to see your game window? Yes.
	}
}

//In conclusion, this document turned out to be more of a tutorial than a template,
// but I still hope you found it somewhat useful.  Remember, always refer to the
// Java API when you need to implement something that you don't know how to do.  By
// using the API, you can figure out how to handle Mouse Clicks, or even anti-alias
// your entire game.  Try making a simple project at first, like "Catch the Ball" or
// something equally easy.  It really helps to work your way up instead of taking on
// a huge project that you have no idea how to handle.


//CHANGE LOG
/*
Started by epaik - 11/15/07 19:52

*/
