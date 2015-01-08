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
    private Stuff painting, totoro, rilakkuma, appa, drawer1, drawer2, drawer3, doorpad, book;
    
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

	//sets the x y bounds of the items in the room and initiallizes
	painting = new Stuff();
	painting.setXY(300,400,250,380);
	rilakkuma = new Stuff();
	rilakkuma.setXY(310, 370, 416, 495);
	totoro = new Stuff();
	totoro.setXY(217, 292, 442, 494);
	appa = new Stuff();
	appa.setXY(400,515,437,491);
	drawer1 = new Stuff();
	drawer1.setXY(190,285,525,555);
	drawer2 = new Stuff();
	drawer2.setXY(295,395,525,555);
	drawer3 = new Stuff();
	drawer3.setXY(402,514,525,555);
	doorpad = new Stuff();
	doorpad.setXY(630,665,365,445);
    }

    public boolean openScramble(){
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
	//tests for if clickability works
	if (painting.withinBounds(x,y)) {
	    Scramble s = new Scramble();
	    s.setVisible(true);
	    System.out.println("painting");
	    while(s.getWinner() == false){
	    }
	}else if (rilakkuma.withinBounds(x,y)){
	    System.out.println("rilakkuma");

	}else if (totoro.withinBounds(x,y)){
	    System.out.println("totoro");

	}else if (appa.withinBounds(x,y)){
	    System.out.println("appa");

	}else if (drawer1.withinBounds(x,y)){
	    System.out.println("d1");

	}else if (drawer2.withinBounds(x,y)){
	    System.out.println("d2");

	}else if (drawer3.withinBounds(x,y)){
	    System.out.println("d3");

	}else if (doorpad.withinBounds(x,y)){
	    System.out.println("doorpad");

	}

	
    }

    //class for items in the room
    public class Stuff {
        private int[] coord; //holds cordinates of item in order x1,x2,y1,y2
	private String name;
	private boolean active;

	public Stuff(){
	    coord = new int[4];
	    active = true;
	}
	
	//names apply to inventory items only
	public Stuff(String name){
	    this.name = name;
	}

	public void setXY(int x1, int x2, int y1, int y2){
	    coord[0] = x1;
	    coord[1] = x2;
	    coord[2] = y1;
	    coord[3] = y2;
	}

	//returns array with all 4 coordinates in it
	public int[] getXY(){
	    return coord;
	}
	
	//tests if the given (x,y) is within the bounds of the item
	public boolean withinBounds(int xLocation, int yLocation){
	    if( xLocation >= coord[0] &&
		xLocation <= coord[1] &&
		yLocation >= coord[2] &&
		yLocation <= coord[3]){
		return true;
	    }
	    return false;
	}
	
	public void setName(String s){
	    name = s;
	}

	public String getName(){
	    return name;
	}

	public boolean isActive(){
	    return active;
	}

	public void setActive(boolean b){
	    active = b;
	}
    }

	
	    
	    
    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
    }
    
    public static void main(String[] args) {

	Room r = new Room();
	r.setVisible(true);
    }

}
