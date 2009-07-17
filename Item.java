import javax.swing.*;
import java.awt.*;

public class Item {
	final int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3, SPACE = 4;
	int x, y, width, height;
	int dx, dy;
	ImageIcon icon = new ImageIcon("Images/Pikachu.png");;
	Image image = icon.getImage();
	int gravity = 1;
	int jumpstaken=0;
	static final int TERMINALVELOCITY = 25;
	Bullet bullet = null;
	public Item(int xpos, int ypos, int w, int h) {
		x = xpos;
		y = ypos;
		width = w;
		height = h;
	}
	public void move(boolean[] keys) {
		if(keys[LEFT]) x -= 5;
		if(keys[RIGHT]) x += 5;
		if(keys[DOWN]) y += 5;
		dy+= gravity;
		if (dy > TERMINALVELOCITY)
			dy = TERMINALVELOCITY;
		y += dy;
		x += dx;
		if(keys[SPACE]) bullet = new Bullet(x+50, y+50, 10, 0);
	}
	public void jump(){
		if (jumpstaken<2) {
			dy= -15;
			jumpstaken++;
		}
	}
	public void redraw(Graphics2D g) {
		g.drawImage(image, x, y, width, height, null);	
	}
}
