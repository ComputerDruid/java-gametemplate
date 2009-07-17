import javax.swing.*;
import java.awt.*;

public class Item {
	final int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3, SPACE = 4;
	int xpos, ypos, width, height;
	ImageIcon icon;
	Image image;
	int gravity = 3;
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
		if(keys[UP]) ypos -= 5;
		if(keys[DOWN]) ypos += 5;
		ypos += gravity;
	}
	public void redraw(Graphics2D g) {
		g.drawImage(image, xpos, ypos, width, height, null);	
	}
}
