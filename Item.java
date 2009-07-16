import javax.swing.*;
import java.awt.*;

public class Item {
	int xpos, ypos, width, height;
	ImageIcon icon;
	Image image;
	public Item(int x, int y, int w, int h) {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		icon = new ImageIcon("Images/Pikachu.png");
		image = icon.getImage();
	}
	public void move(int dx, int dy) {
		xpos += dx;
		ypos += dy;
		
	}
	public void redraw(Graphics2D g) {
		g.drawImage(image, xpos, ypos, width, height, null);	
	}
}
