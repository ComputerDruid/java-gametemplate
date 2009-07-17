import javax.swing.*;
import java.awt.*;

public class Item {
	final int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3, SPACE = 4;
	int xpos, ypos, width, height;
	int dx, dy;
	ImageIcon icon;
	Image image;
	int gravity = 1;
	int jumpstaken=0;
	static final int TERMINALVELOCITY = 25;
	public Item(int x, int y, int w, int h) {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		icon = new ImageIcon("Images/Pikachu.png");
		image = icon.getImage();
	}
	public void move(boolean[] keys) {
		if(keys[LEFT]) xpos -= 5;
		if(keys[RIGHT]) xpos += 5;
		if(keys[DOWN]) ypos += 5;
		dy+= gravity;
		if (dy > TERMINALVELOCITY)
			dy = TERMINALVELOCITY;
		ypos += dy;
		xpos += dx;
	}
	public void jump(){
		if (jumpstaken<2) {
			dy= -15;
			jumpstaken++;
		}
	}
	public void redraw(Graphics2D g) {
		g.drawImage(image, xpos, ypos, width, height, null);	
	}
}
