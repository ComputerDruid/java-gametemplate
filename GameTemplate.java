import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class GameTemplate extends JPanel {
	//We use these for double buffereing:
	public BufferedImage myImage;
	public Graphics2D buffer;

	//This timer drives your game forward:
	public Timer t = new Timer(30, new Listener());

	final int WINDOWX = 600, WINDOWY = 600;
	//#The dimensions of your game.  Will be called upon later a lot.
	final int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3, SPACE = 4;
	boolean[] keys = new boolean[5];

	public GameTemplate() {
		myImage = new BufferedImage(WINDOWX, WINDOWY, BufferedImage.TYPE_INT_RGB);

		buffer = (Graphics2D)myImage.getGraphics();

		addKeyListener(new KeyListener());
		setFocusable(true);

		setPreferredSize(new Dimension(WINDOWX, WINDOWY)); //makes the later call to frame.pack() work nicely

		t.start();
	}
	public void roomMath() {
		/*
		 * Game Logic goes here
		 */










	}

	public void roomDraw() {
		buffer.setColor(Color.black);
		buffer.fillRect(0,0,WINDOWX,WINDOWY);
		










		//buffer.setColor(Color.blue);
		//buffer.fillRect(100,100,200,100);
		//buffer.setColor(Color.red);
		//buffer.fillOval(300,300,100,200);
		//buffer.setColor(Color.white);
		//buffer.drawString("Hello world!", 50, 400);
		//buffer.fillOval(playerx,playery,50,50);
		repaint();
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//This stuff happens once per frame
			roomMath();
			roomDraw();
		}
	}
	public class KeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				keys[SPACE] = true;
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
				System.exit(0); //Makes the program quit when the player hits Esc
		}
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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
		//displays our stored image to the panel (to the screen)
		g.drawImage(myImage, 0, 0, WINDOWX, WINDOWY, null);
	}
	public static void main(String[] args) {
		//This method sets up everything, including the panel, which will do the rest of the work.

		JFrame frame = new JFrame("Game");
		frame.setLocationRelativeTo(null); //Centers the window onscreen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); //keeps the window size from changing
		frame.setContentPane(new GameTemplate());
		frame.pack();//Makes the frame the right size so that the panel is displayed at the right size
		frame.setVisible(true);
	}
}
