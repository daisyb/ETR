import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

// class for the final piece of the puzzle: getting the code
// to get out of the room
public class Keypad extends JDialog implements MouseListener{

    private JPanel canvas;
    private BufferedImage image;
    private Container pane;
    public keys one, two, three, four, five, six, seven, eight, nine, zero, star, enter;
    //private JTextArea instructions, spaces, status;
    private String passcodeguess = "";
    //final passcode to get out!
    private String passcode = "13456240";

    public Keypad(JFrame parent, boolean modal) {
	super(parent, true);
	setTitle("Keypad");
	setSize(360, 540);
	setLocation(100, 100);

	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	pane = getContentPane();
	//VERY WRONG - pane.setLayout(new FlowLayout());
	try {
	    image = ImageIO.read(new File("images/keypad2.jpg"));
	} catch (IOException ex) {
	    System.out.println("cannot load image");
	}
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	// these are the coordinates for the keys
	// (see the keys class)
	one = new keys(53, 131, 161, 239);
	two = new keys(142, 219, 161, 239);
	three = new keys(229, 306, 157, 239);
	four = new keys(53, 131, 247, 326);
	five = new keys(142, 219, 247, 326);
	six = new keys(229, 306, 247, 326);
	seven = new keys(53, 131, 336, 414);
	eight = new keys(142, 219, 336, 414);
	nine = new keys(229, 306, 336, 414);
	star = new keys(53, 131, 423, 501);
	zero = new keys(142, 219, 423, 501);
	enter = new keys(229, 306, 423, 501);
	setVisible(true);
    }

    // fill in the methods implemented from MouseListener
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    //  all the important things that happen in Keypad are all in mouseClicked.
    //  if the key is "within bounds" of the x and y coordinates of the key
    //  which is determined by a method in the keys class, then the image changes
    //  to show the user what key they clicked on. it also adds the number to
    //  the "passcodeguess" string, which is compared with the real passocde string
    //  when the enter button is clicked to determine if the user has "escaped."
    public void mouseClicked(MouseEvent e) {
	int x = e.getX();
	int y = e.getY();
       
	if (one.withinBounds(x, y)) {
	    try {
		image = ImageIO.read(new File("images/kp1.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "1";
	} else if (two.withinBounds(x, y)) {
	    try {
		image = ImageIO.read(new File("images/kp2.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "2";
	} else if (three.withinBounds(x, y)) {
	    try {
		image = ImageIO.read(new File("images/kp3.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "3";
	} else if (four.withinBounds(x, y)) {
	    try {
		image = ImageIO.read(new File("images/kp4.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "4";
	} else if (five.withinBounds(x, y)) {
	    try {
		image = ImageIO.read(new File("images/kp5.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "5";
	} else if (six.withinBounds(x, y)) {
	     try {
		image = ImageIO.read(new File("images/kp6.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "6";
	} else if (seven.withinBounds(x, y)) {
	     try {
		image = ImageIO.read(new File("images/kp7.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "7";
	} else if (eight.withinBounds(x, y)) {
	     try {
		image = ImageIO.read(new File("images/kp8.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "8";
	} else if (nine.withinBounds(x, y)) {
	     try {
		image = ImageIO.read(new File("images/kp9.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "9";
	} else if (zero.withinBounds(x, y)) {
	    try {
		image = ImageIO.read(new File("images/kp0.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "0";
	} else if (star.withinBounds(x, y)) {
	     try {
		image = ImageIO.read(new File("images/kpstar.jpg"));
	    } catch (IOException ex) {
		System.out.println("cannot load image");
	    }
	    canvas.update(canvas.getGraphics());
	    passcodeguess = passcodeguess + "*";
	} else if (enter.withinBounds(x, y)) {
	    System.out.println(passcodeguess);
	    if (passcodeguess.equals(passcode)) {
		System.out.println("yay");
	    } else {
		System.out.println("not yay");
	    }
	}
    }


    public boolean gotOut() {
	return passcodeguess.equals(passcode);
    }

    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
    }

    //key class for the keys of the keypad
    //allows us to set the coordinates of where the mouse needs to click
    public class keys {
	private int[] coord;
	private String number;
	
	// gives the keys class an array of the coordinates
	public keys(){
	    coord = new int[4];
	}
	
	// sets the coordinates (four param constructor)
	public keys(int x1, int x2, int y1, int y2){
	    this();
	    setXY(x1, x2, y1, y2);
	}
	
	// gives the key a name (in this case, it's the number, or "star" for the *)
	public keys(String number){
	    this.number = number;
	}

	public String toString(){
	    return number;
	}
	
	// method used in the four param constructor; sets item in the array to
	// the coordinates plugged in
	public void setXY(int x1, int x2, int y1, int y2){
	    coord[0] = x1;
	    coord[1] = x2;
	    coord[2] = y1;
	    coord[3] = y2;
	}

	public int[] getXY() {
	    return coord;
	}

	// this is used in the mouseClicked method.
	// the two parameters are checked to see if they
	// are greater than the smaller coordinate and
	// less than the bigger coordinate. this will
	// return a boolean of whether or not the conditions
	// are met.
	public boolean withinBounds(int xLoc, int yLoc) {
	    if( xLoc >= coord[0] &&
		xLoc <= coord[1] &&
		yLoc >= coord[2] &&
		yLoc <= coord[3]){
		return true;
	    }
	    return false;
	}
    }

}
