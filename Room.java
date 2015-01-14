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

public class Room extends JFrame implements MouseListener{
    
    private JFrame frame;
    private BufferedImage image;
    private Container pane;
    private JPanel canvas;
    private ArrayList<Stuff> inventory; //arrayList to hold inventory items
    private Stuff inHand; //object currently holding (button pressed)
    private Stuff painting, totoro, rilakkuma, appa, drawer1, drawer2, drawer3, doorpad, book; //items in room
    private Stuff key1, key3, scissors, phone; //slip1,slip2,slip3,slip4,slip5; 
    //^items you can hold and put in inventory

    
  
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
	if (painting.withinBounds(x,y) & painting.isActive()) {
	    Scramble s = new Scramble(this,true);
	    if(s.getWinner()){
		try {                
		    image = ImageIO.read(new File("images/room/Room2.jpg"));
		} catch (IOException ex) {
		    System.out.println("oops");
		}
		canvas.update(canvas.getGraphics());
		painting.setActive(false);
		pBack p = new pBack(this,true);
		inventory.add(key1);
		//inventory.add(slip);
	    }
	    System.out.println(inventory);
	}else if (rilakkuma.withinBounds(x,y)){
	    System.out.println("rilakkuma");

	}else if (totoro.withinBounds(x,y)){
	    System.out.println("totoro");

	}else if (appa.withinBounds(x,y)){
	    System.out.println("appa");

	}else if (drawer1.withinBounds(x,y)){
	    System.out.println("d1");
	    if(key1 == inHand){
		//open drawer
		
	    }
	}else if (drawer2.withinBounds(x,y)){
	    System.out.println("d2");

	}else if (drawer3.withinBounds(x,y)){
	    System.out.println("d3");
	    
	}else if (doorpad.withinBounds(x,y)){
	    Keypad k = new Keypad(this, true);

	}else if (book.withinBounds(x,y)){
	    System.out.println("book");
	}
    }


  
    public Room() {
	setTitle("Room");
	setSize(700,900);
	setLocation(200,50);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	try {                
	    image = ImageIO.read(new File("images/room/Room.jpg"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}

	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	//sets the x y bounds of the items in the room and initiallizes
	painting = new Stuff(300,400,250,380);
	rilakkuma = new Stuff(310, 370, 416, 495);
	totoro = new Stuff(217, 292, 442, 494);
	appa = new Stuff(400,515,437,491);
	drawer1 = new Stuff(190,285,525,555);
	drawer2 = new Stuff(295,395,525,555);
	drawer3 = new Stuff(402,514,525,555);
	doorpad = new Stuff(630,665,365,445);
	book = new Stuff(109,152,390,400);
	

	//set up inventory
	inventory = new ArrayList<Stuff>();
	key1 = new Stuff("Silver Key");//idk I figure colors would be a good way for user to distinguish btwn them
	key3 = new Stuff("Gold Key");
	scissors = new Stuff("Scissors");
	phone = new Stuff("phone");
	//not sure how to handle slips
	
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
