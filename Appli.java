//copyrigth
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Appli extends JFrame{
	private Appli2 p = new Appli2() ;
	
	public Appli(){
		this.setTitle("Tic Tac Toc");
	    this.setSize(320, 325);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(p);
	    this.setVisible(true);
	   //this.setResizable(false); 
		
	}
	
	public static void main(String[] args) {
		new Appli() ;

	}

}
