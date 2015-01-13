import java.io.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
  Abstract class for popup windows like pBack and drawer
  subclass constructors should take the params (JFrame parent, boolean modal)
  and include the line: super(parent, true);
 */

public abstract class Popup extends JDialog implements MouseListener{
    private BufferedImage image; //holds image for graphics

    //mouseListener methods
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    //loads image at filePath
    public void setImage(String filePath){
	try {                
	   image = ImageIO.read(new File(filePath));
	} catch (IOException ex) {
	    System.out.println("oops");
	}
    }

    //constructor
    public Popup(JFrame parent, boolean modal){
	super(parent,true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocation(250,150);
	setSize(500,500);
	setResizable(false);


    }

    //canvas class
    public class Canvas extends JPanel {

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
    }
}
