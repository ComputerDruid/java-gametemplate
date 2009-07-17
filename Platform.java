import javax.swing.*;
import java.awt.*;

public class Platform {
	int xpos, ypos, width, height;
	Color color;
	public Platform(int x, int y, int w, int h, Color c) {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		color = c;
	}
	public void redraw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(xpos, ypos, width, height);
	}
	public void collide(Item i) {
		while(i.ypos+i.height > ypos && i.xpos < xpos+width && i.xpos+i.width > xpos){
			i.ypos--;
			i.dy=0;
			i.jumpstaken=0;
		}
	}
}
