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

public class Keypad extends JDialog implements MouseListener{

    private JPanel canvas;
    private BufferedImage image;
    private Container pane;
    private Stuff one, two, three, four, five, six, seven, eight, nine, zero, star, pound;
    private JTextArea instructions, spaces, status;
   
    public Keypad(JFrame parent, boolean modal) {
	super(parent, true);
	setTitle("Keypad");
	setSize(464, 666);
	setLocation(100, 100);

	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	try {
	    image = ImageIO.read(new File("images/keypad.jpeg"));
	} catch (IOException ex) {
	    System.out.println("cannot load image");
	}
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	one = new Stuff(72, 160, 205, 293);
	two = new Stuff(191, 277, 208, 295);

	setVisible(true);
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
    }
    
    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
    }

    /*-----------------------Methods-------------------*/
	


    //public static void main(String[] args) {
//	Keypad k = new Keypad();
//	k.setVisible(true);
//  }

}
