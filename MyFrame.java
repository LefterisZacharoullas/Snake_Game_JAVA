import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

public class MyFrame implements KeyListener{

	JLabel label, food ;

	static class Cordinates{
		int x ;
		int y ;

		Cordinates(){

		}

		Cordinates(int x, int y){
			this.x = x;
			this.y = y;
		}
	};

	public Cordinates RadnomCordinate(int x, int y){
		Random random = new Random();
		x = random.nextInt(226);
		y = random.nextInt(203);
		return new Cordinates(x, y);
	}

	public void GiveFood(){
		int x = 0, y = 0 ;
		Cordinates cor = new Cordinates();
		cor = RadnomCordinate(x, y);
		food.setLocation(cor.x, cor.y);
		food.setOpaque(true);	
	}

	public boolean CkeckFoodPosition(){
		if(label.getX() == food.getX() && food.getY() == label.getY()){
			return true;
		}
		return false;
	}

	public boolean GameOver(){
		if(label.getX() > 226 || label.getX() < 0 || label.getY() > 203 || label.getY() < 0){
			System.out.println("Game over!!");
			return false ;
		}
		return true ;
	}
	
	MyFrame(){
		JFrame frame = new JFrame("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(260,260);
		frame.setLayout(null);
		frame.addKeyListener(this);
		
		label = new JLabel();
		label.setBounds(0, 0, 20, 20);
		label.setBackground(Color.green);
		label.setOpaque(true);

		food = new JLabel();
		food.setBackground(Color.red);
		food.setSize(20, 20);

		frame.add(label);
		frame.add(food);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()){
			case 'a':
				label.setLocation(label.getX()-1, label.getY());
				break;
			case 'd':
				label.setLocation(label.getX()+1, label.getY());
				break;
			case 'w':
				label.setLocation(label.getX(), label.getY()-1);
				break;
			case 's':
				label.setLocation(label.getX(), label.getY()+1);
				break;
			default:
				System.out.println("You press something wrong");
		}
		// System.out.println(label.getX() + " " + label.getY() );
		// System.out.println(food.getX() + " " + food.getY() );
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) { //is called when every time button is pressed
		//System.out.println("You pressed the button " + e.getKeyChar());
		//System.out.println(label.getX() + " " + label.getY());
	}
}