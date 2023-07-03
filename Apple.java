import java.awt.*;
import java.util.Random;

public class Apple {
    Random random = new Random(); // dimiourgeitai mono mia fora, gia na exikonomisoume mnimi. Min dimiourgis object parapano fores apo oti xreiazese.
    int x, y;

    public Apple(Snake snake) {
        this.relocate(snake);
    }

    private boolean collides(Snake snake) { // exetazoume ean to snake einai mes tin mesi
        if (this.x > snake.x && this.x < snake.x + 20 && this.y > snake.y && this.y < snake.y + 20)
            return true;
        return false;
    }

    public void relocate(Snake snake) { // dialegoume tixes metablites gia to milo.
        do {
            this.x = this.random.nextInt(260 - 20);//an exei x = 259 tote tha einai ektos apo to frame!
            this.y = this.random.nextInt(260 - 20);
        } while (collides(snake)); // an einai pas to snake
    }

    public void paint(Graphics2D g) { // super giga chad zografismos milou
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 20, 20);
    }
}
