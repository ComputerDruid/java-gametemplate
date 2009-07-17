import javax.swing.*;
import java.awt.*;

public class Platform {
	int x, y, width, height;
	Color color;
	public Platform(int xpos, int ypos, int w, int h, Color c) {
		x = xpos;
		y = ypos;
		width = w;
		height = h;
		color = c;
	}
	public void redraw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	public void collide(Item i) {
		while(i.y+i.height > y && i.x < x+width && i.x+i.width > x){
			i.y--;
			i.dy=0;
			i.jumpstaken=0;
		}
	}
}
