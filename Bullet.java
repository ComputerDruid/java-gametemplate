import javax.swing.*;
import java.awt.*;

public class Bullet {
	int x, y, dx, dy;
	int size = 5;
	public Bullet(int startx, int starty, int xchange, int ychange) {
		x = startx;
		y = starty;
		dx = xchange;
		dy = ychange;
	}
	public void move() {
		x += dx;
		y += dy;
	}
	public void redraw(Graphics2D g) {
		g.setColor(Color.white);
		g.fillOval(x, y, size, size);
	}
	public boolean check(Item i) {
		if (x >= i.x && x <= i.x + i.width)
			if (y >= i.y && y <= i.y + i.height)
				return true;
		return false;
	}
}
