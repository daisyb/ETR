import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.lang.ClassLoader;

public class Room extends JFrame implements MouseListener {
    
    private JFrame frame;
    private BufferedImage image;
    private Container pane;
    private JPanel canvas;
    private stuff painting, totoro, rilakkuma, appa, drawer1, drawer2, drawer3, doorhandle, book;
    
    public Room() {
	setTitle("Room");
	setSize(700,900);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	try {                
	    image = ImageIO.read(new File("Room.jpg"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);
    }

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
	if ((x < 400 && x > 300) && (y < 380 && y > 250)) {
	    Scramble s = new Scramble();
	    s.setVisible(true);
	    System.out.println("yes");
	}

	
    }

    public class stuff {
	int x1;
	int x2;
	int y1;
	int y2;
	String name;
	boolean active;

	public void setXY(int newx1, int newx2, int newy1, int newy2){
	    x1 = newx1;
	    x2 = newx2;
	    y1 = newy1;
	    y2 = newy2;
	}

	public int getXbegin(){
	    return this.x1;
	}

	/*
	  rilakkuma: 310, 370, 416, 495
	  totoro: 216, 295, 430, 490
	*/

    }

	
	    
	    
    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
	}
    }
    
    public static void main(String[] args) {

	Room r = new Room();
	r.setVisible(true);
    }

}
