import java.awt.*;

public class Snake {
	int x, y;

	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(this.x, this.y, 20, 20);
	}
}