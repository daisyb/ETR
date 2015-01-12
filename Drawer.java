import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Drawer extends JDialog implements MouseListener{
    private BufferedImage image;
    private Container pane;
    private JPanel canvas;
    private Stuff scissors, slip, phone;
    private boolean Drawer1,hasScissors,hasPhone,hasSlip;


    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
	if(Drawer1){
	    if(scissors.withinBounds() && isActive()){
		hasScissors = true;
	    }
	}
		
    }

    public Drawer(JFrame parent, boolean modal,boolean isDrawer1){
	super(parent, true);
	Drawer1 = isDrawer1;
	setDefaultOperation(Dispose_ON_CLOSE);
	setLocation(250,150);
	setSize(400,400);
	setTitle("Drawer Inside");
	pane = getContnentPane();
	
	try {                
	    image = ImageIO.read(new File("painting/pBack.bmp"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}

	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	
	// scissors = new Stuff(blahlabladlhg);
	// slip = new Stuff(badjgfhasdjkghs);
	// phone = new Stuff(blahblahabval);
	setVisible(true);
    }

 
    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
    }
