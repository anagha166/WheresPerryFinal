import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import imgs.Background;
import imgs.Level;
import imgs.Buttons;
import imgs.RestartMenu;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	Player p = new Player();
	Background homepage = new Background();
	boolean home = false;
	Buttons one = new Buttons("level1logo.png", 130, 190);
	Buttons two = new Buttons("level2logo.png", 230, 190);
	Buttons three = new Buttons("level3logo.png", 520, 190);
	Buttons pause = new Buttons("pause.png", 730, 0);
	
	Background back = new Background("background.png");
	Level first = new Level("level1.png");
	boolean firstStart = false;
	Level second = new Level("level2.png");
	boolean secondStart = false;
	Level third = new Level("test.png");
	boolean thirdStart = false;
	
	RestartMenu restartMenu = new RestartMenu();
	boolean canRestart = false;
	Buttons restart = new Buttons("restart.png",300 ,320);
	Buttons menu = new Buttons("menu.png", 420, 320);
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		homepage.paint(g);
		one.paint(g);
		two.paint(g);
		three.paint(g);
		
		if (firstStart) {
			back.paint(g);
			first.paint(g);
			pause.paint(g);
			p.paint(g);
		}
		if (secondStart) {
			back.paint(g);
			second.paint(g);
			pause.paint(g);
			p.paint(g);
		}
		if (thirdStart) {
			back.paint(g);
			third.paint(g);
			pause.paint(g);
			p.paint(g);
		}
		if (canRestart) {
			restartMenu.paint(g);
			menu.paint(g);
			restart.paint(g);
		}
		//System.out.println(p.getY());
		//System.out.println(third.getclr(p.getX() + 30,p.getY()+90));
		//System.out.println(homepage.getclr(p.getX()+10,p.getY()/100));
		
		
		if(third.getclr(p.getX() + 30,p.getY()+70) == true) {
			System.out.println("yas");
			p.setFlor(p.getY());
			//p.setFlor(p.getY());
		} else {
			p.setFlor(700);
		}
		
		/*
		if(third.getclr(p.getX()+20,p.getY()+70) == true) {
			p.setLwall(p.getX());
	
		} 
		
		/*
		
		if(third.getclr(p.getX()+30,p.getY()+70) == true) {
			p.setRwall(p.getX());
			
		} \\*/
		
		
	
		
		
		
		
		
	}
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Wheres Perry");
		f.setSize(new Dimension(800, 800));
		f.setBackground(Color.white);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//third.getclr(40, 500);
		
		//System.out.println("yas");
		//p.setFlor(300);
		
		//p.getclr();
		//homepage.getclr(0,1);
		
		
		
		
		
		
		//p.GetPixelColor(100, 200);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arig0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		if(one.hit(arg0)) {
			firstStart = true;
		}
		if(two.hit(arg0)) {
			secondStart = true;
		}
		if(three.hit(arg0)) {
			thirdStart = true;
		}
		if(pause.hit(arg0)) {
			canRestart = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		if (arg0.getKeyCode() == 39) { 
			p.moveLeft();
		}
		if (arg0.getKeyCode() == 37) { 
			p.moveRight();
		}
		if (arg0.getKeyCode() == 38) { 
			System.out.println("jump");
			p.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		p.stop();
		/*
		if (arg0.getKeyCode() == 39) { 
			p.stop();
		}
		if (arg0.getKeyCode() == 37) { 
			p.stop();
		}
		
		*/
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}