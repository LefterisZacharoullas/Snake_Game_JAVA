import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    Game game;

    public Main() throws HeadlessException {
        super("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // i parametros lali ti tha ginei me to programma otan kalesoume tin sinartisi JFrame#dispose.
        this.setResizable(false);
        this.setSize(260,260);
        this.setLayout(null);

        game = new Game();
        this.add(game);

        this.addKeyListener(game);
        this.setVisible(true);

        Thread loop = new Thread(this::loop); //dimiourgoume thread gia to kirio loop tou pexnidiou.
        loop.start(); // xekinoume to thread.
    }

    public void loop() {
        this.game.gameLoop(); //kaloume to dame gia na eimaste pio organized.
        this.dispose(); // klinei to parathiro, kai etsi to programma.
    }

    public static void main(String args[]) {
        new Main();
    }
}