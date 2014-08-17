import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.Stack ;

public class Appli2 extends JPanel{
    public int [][] t = {{2,3,4},
    		             {5,6,7},
    		             {8,9,10}};
    
	public int x =0 ;
	public int y = 0 ;
	public boolean tour = true ;
	
	public Appli2(){
		   this.addMouseListener(new MouseAdapter(){
			      public void mousePressed(MouseEvent e){
			    	  if(tour){
			      t[(int)(e.getY()/(300/3))][(int)(e.getX()/(300/3))] = 1 ; 
			      System.out.println((int)(e.getY()/(325/3)));
			       repaint() ;
			       tour  = false ;
			    	  }else {
			    		  t[(int)(e.getY()/(300/3))][(int)(e.getX()/(300/3))] = -1 ; 
					     
					       repaint() ; 
					       tour  = true ;
			    	  }
			      }
			    });

			    this.addMouseMotionListener(new MouseMotionListener(){
			      public void mouseDragged(MouseEvent e) {
			       
			      }

			      public void mouseMoved(MouseEvent e) {}
			    });
	
	
	
	}
	
	public boolean verif2(int[][]t){
		for(int i = 0 ; i< t.length ; i++){
			for(int j = 0 ; j < t[0].length ;j++){
				if(t[i][j]!=0){
					return false ;
				}
			}
		}
		return true ;
	}
	
	
	
	public boolean verif (int [][] t){
	//if(verif2(t) == false    ){
		if(t[0][0] == t[0][1] && t[0][1] == t[0][2]){
			System.out.println("?");
		return true ;
		}
		if(t[1][0] == t[1][1] && t[1][1] == t[1][2]){
			System.out.println("?1");
			return true ;
		}
		if(t[2][0] == t[2][1] && t[2][1] == t[2][2]){
			System.out.println("?2");
			return true ;
		}
		if(t[0][0] == t[1][0] && t[1][0] == t[2][0]){
			System.out.println("?3");
			return true ;
		}	
		if(t[0][1] == t[1][1] && t[1][1] == t[2][1]){
			System.out.println("4?");
			return true ;
		}	
		if(t[0][2] == t[1][2] && t[1][2] == t[2][2]){
			System.out.println("?5");
			return true ;
		}	
		if(t[0][0] == t[1][1] && t[1][1] == t[2][2]){
			System.out.println("?6");
			return true ;
		}
		if(t[0][2] == t[1][1] && t[1][1] == t[2][0]){
			System.out.println("?7");
			return true ;
		}
		
		return false ;
	//}
	

	}
	public void affiche(int [][]t ,Graphics g){
	for(int i = 0 ;i < t.length ; i++){
		for(int j = 0 ; j< t[0].length ; j++){
			
			if(t[i][j] == 1){
				g.setColor(Color.blue);
				g.drawLine(x, y, x+100, y+100);
				g.drawLine(x, y+100, x+100, y);
			}
			if(t[i][j] == -1){
				g.setColor(Color.red);
				g.drawLine(x, y, x+100, y+100);
				g.drawLine(x, y+100, x+100, y);
				
			}
			
			x = x + 100;
		}
		x = 0 ;
		y = y + 100 ;
	}
	
	x = y =0 ;
	}
	
	public void paintComponent(Graphics g){
		
		
		try{
			Image i = ImageIO.read(new File("gates.jpg"));
			g.drawImage(i,0,0,500,300,this);
			g.setColor(new Color(206,206,206));
			g.fillRect(230, 80, 110, 130);
			g.setColor(Color.black);
			g.drawLine(100, 0, 100, 300);
			g.drawLine(200, 0, 200, 300);
			g.drawLine(0, 100, 300, 100);
			g.drawLine(0, 200, 300, 200);
			
			
			affiche(t,g) ;
			
			if(verif(t)){
				if(tour){
					tour = false ;
					System.out.println("bravo " + tour );
					g.setColor(Color.red);
					 g.setFont(new Font("Arial", Font.BOLD, 20));
					 
					 g.drawString("Bravo ,Tu as gagné , croix rouge ! ", 200, 150);
				}else{
					tour = true ;
					System.out.println("bravo " + tour );
					g.setColor(Color.red);
					 g.setFont(new Font("Arial", Font.BOLD, 20));
					 
					 g.drawString("Bravo ,Tu as gagné , croix bleu ! ", 200, 150);
				}
			}
			
			
		}catch (IOException e) {
		    e.printStackTrace();
		}      
		
	}
	
}
