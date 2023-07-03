import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener {
    Snake snake; // oi metablites prepi na einai mesa sto JPanel kai oxi to JFrame. tora anarotiese giati logika, i apantisi einai stin grammi 86.
    Apple apple;

    public Game() {
        this.setSize(260, 260);

        this.snake = new Snake(0, 0);
        this.apple = new Apple(this.snake);

        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) { // kalite stin arxi kai otan kaloume #repaint.
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        this.apple.paint(g2d); //zografizoume ta dio object mas, i sira exei simasia!
        this.snake.paint(g2d);
    }

    public boolean isGameOver() {
        if(snake.x > 260 - 20 || snake.x < 0 || snake.y > 260 - 20 || snake.y < 0) { // des Apple#relocate gia exigisi sto 260-20.
            System.out.println("Game over!!");
            return true;
        }
        return false;
    }

    public void tryEat() {
        if (this.snake.x == this.apple.x && this.snake.y == this.apple.y) {
            //kame kati otan fai to milo
            this.apple.relocate(this.snake);
        }
    }

    public void gameLoop() {
        while (!this.isGameOver()) {
            this.tryEat();

            this.repaint(); //sxediazoume to snake kai apple pano stin othoni, des #paint() pio pano.

            //edo stamatame to thread gia 15millisecond giati to while en polla glioro giauto afinoume to cpu na sxediasei ta kainouria pramata me tin isixia tou.
            //nai, touto ida to apo kapio allo. omos ta ipolipa einai dikis mou empneusis.
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { // kaliteri sinartisi apo to keyTyped
        switch (e.getKeyChar()) {
            case 'a':
                snake.setXY(snake.x - 1, snake.y);
                break;
            case 'd':
                snake.setXY(snake.x+1, snake.y);
                break;
            case 'w':
                snake.setXY(snake.x, snake.y-1);
                break;
            case 's':
                snake.setXY(snake.x, snake.y+1);
                break;
            default:
                System.out.println("You press something wrong"); // auto logika den xreiazete afou den sou dia kapia xrisimi pliroforia
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
// Den exw idea.