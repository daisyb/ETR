import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class pBack extends JDialog implements MouseListener{
    private BufferedImage image;
    private Container pane;
    private JPanel canvas;
    private Stuff key, slip;


    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
	int x = e.getX();
	int y = e.getY();
	if(key.withinBounds(x,y)&& key.isActive()){
	    System.out.println("key");
	    if(slip.isActive()){
		try {                
		    image = ImageIO.read(new File("painting/pJustSlip.bmp"));
		} catch (IOException ex) {
		    System.out.println("oops");
		}
	    } else {
		try {                
		    image = ImageIO.read(new File("painting/pNothin.bmp"));
		} catch (IOException ex) {
		    System.out.println("oops");
		}
	    }	
	    canvas.update(canvas.getGraphics());
	    key.setActive(false);

	} else if (slip.withinBounds(x,y) && slip.isActive()){
	    System.out.println("slip");
	    if(key.isActive()){
		try {                
		    image = ImageIO.read(new File("painting/pJustKey.bmp"));
		} catch (IOException ex) {
		    System.out.println("oops");
		} 
	    }else {
		try {                
		    image = ImageIO.read(new File("painting/pNothin.bmp"));
		} catch (IOException ex) {
		    System.out.println("oops");
		}
	    }
	    canvas.update(canvas.getGraphics());
	    slip.setActive(false);
	}
    }

    public pBack(JFrame parent, boolean modal){
	super(parent,true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocation(250,150);
	setSize(400,530);
	setTitle("Back of Poster");
	pane = getContentPane();
	try {                
	    image = ImageIO.read(new File("painting/pBack.bmp"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}

	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	key = new Stuff(100,264,116,193);
	slip = new Stuff(86,258,268,312);

	setVisible(true);

    }

    
    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
    }

    public static void main(String[] args){
	pBack p = new pBack(new JFrame(),true);
	
    }
}
