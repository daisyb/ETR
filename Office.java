import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.lang.ClassLoader;

public class Office extends JFrame {
    
    private JFrame frame;
    private BufferedImage image;
    private Container pane;
    private JPanel canvas;
    
    
    public Office() {
	setTitle("Office");
	setSize(600,600);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	try {                
	    image = ImageIO.read(new File("officetemp.jpg"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
       
    }

    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
	}
    }
    
    public static void main(String[] args) {

	ClassLoader classLoader = Office.class.getClassLoader();
	
	try {
	    Class aClass = classLoader.loadClass("Scramble");
	    System.out.println("aClass.getName() = " + aClass.getName());
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

	Office o = new Office();
	o.setVisible(true);
    }

}
