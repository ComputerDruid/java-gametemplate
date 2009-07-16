import javax.swing.*;
import java.awt.*;

public class Item {
	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private ImageIcon icon;
	private Image image;
// other variables go here
// int health = ...
// int points = ...
	
	public Item(int x, int y, int w, int h) {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		icon = new ImageIcon("Images/Pikachu.png");
		image = icon.getImage();
	}
	public Image getImage() {
		return image;
	}
	public int getX() {
		return xpos;
	}
	public int getY() {
		return ypos;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setX(int newx) {
		xpos = newx;
	}
	public void setY(int newy) {
		ypos = newy;
	}
}
