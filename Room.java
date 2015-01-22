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
    private JPanel canvas, buttons;
    private ArrayList<Stuff> inventory; //arrayList to hold inventory items
    private Animals t,r,a; //popups for the stuffed animals
    private Drawer d1, d3; //popups for the drawers
    private Stuff painting, totoro, rilakkuma, appa, drawer1, drawer2, drawer3, doorpad, book, slip1,slip2; 
    //^items in room
    private InventoryItem inHand; //object currently holding (button pressed)
    private InventoryItem key1, key3, scissors, slips, phone; //slip1,slip2,slip3,slip4,slip5; 
    //^items you can hold and put in inventory,subclass that extends JButton, 
    private int slipCount = 0;

    private ActionListener aL = new ActionListener(){
	    public void actionPerformed(ActionEvent ae){
		InventoryItem i =(InventoryItem) ae.getSource();
		if(inHand == null){
		    inHand = i;
		    i.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		} else if(inHand == i){		    
		    inHand.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		    inHand = null;
		}else{
		    i.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		    inHand.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		    inHand = i;
		}
	    }
	};

    
  
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
	if (painting.withinBounds(x,y) && painting.isActive()) {
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

		if(slipCount == 0){
		    buttons.add(slips);
		    buttons.revalidate();
		    slipCount +=1;
		} else {
		    slipCount +=1;
		    slips.setText("Slips: " + slipCount + "/5");
		}
		buttons.add(key1);
		buttons.revalidate();
	    }
	 
	}else if (totoro.withinBounds(x,y)){
	    if(scissors == inHand){
		t.setVisible(true);
		if(t.hasSlip() && totoro.isActive()){
		    totoro.setActive(false);
		    slipCount +=1;
		    slips.setText("Slips: " + slipCount + "/5");
		}
	    }
	}else if (rilakkuma.withinBounds(x,y)){
	    if(scissors == inHand){
		r.setVisible(true);
	    }
	}else if (appa.withinBounds(x,y)){
	    if(scissors == inHand){	    
		a.setVisible(true);
		if(a.hasKey() && appa.isActive()){    
		    appa.setActive(false);

		    buttons.add(key3);
		    buttons.revalidate();
		}
	    }
	    
	}else if (drawer1.withinBounds(x,y)){
	    if(key1 == inHand){
		d1.setVisible(true);
		if(d1.hasScissors() && drawer1.isActive()){
		    drawer1.setActive(false);

		    buttons.add(scissors);
		    buttons.revalidate();
		}
	    }
	}else if (drawer2.withinBounds(x,y)){

	}else if (drawer3.withinBounds(x,y)){
	    if(key3 == inHand){
		d3.setVisible(true);
		if(d3.hasPhone() && phone.getParent() != buttons){
		    buttons.add(phone);
		    buttons.revalidate();

		}
		if(d3.hasSlip() && drawer3.isActive()){
		    slipCount +=1;
		    slips.setText("Slips: " + slipCount + "/5");
		    drawer3.setActive(false);
		}	    
	    }
	    
	}else if (doorpad.withinBounds(x,y)){
	    Keypad k = new Keypad(this, true);
	    if (k.gotOut()) {
		try {                
		    image = ImageIO.read(new File("images/endscreen.png"));
		} catch (IOException ex) {
		    System.out.println("oops");
		}
	    }
	    canvas.update(canvas.getGraphics());
	
	} else if (book.withinBounds(x,y)){
	    System.out.println("book");

	} else if (slip1.withinBounds(x,y) && slip1.isActive()){
	    if(slipCount == 0){
		buttons.add(slips);
		buttons.revalidate();
		slipCount +=1;
	    } else {
		slipCount +=1;
		slips.setText("Slips: " + slipCount + "/5");
	    }
	    slip1.setActive(false);
	  
	} else if (slip2.withinBounds(x,y) && slip2.isActive()){
	    if(slipCount == 0){
		buttons.add(slips);
		buttons.revalidate();
		slipCount +=1;
	    } else {
		slipCount +=1;
		slips.setText("Slips: " + slipCount + "/5");
	    }
	    slip2.setActive(false);
	}
    }


  
    public Room() {
	setTitle("Room");
	setSize(836,725);
	setLocation(200,50);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
	try {                
	    image = ImageIO.read(new File("images/room/Room.jpg"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}

	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	canvas.setPreferredSize(new Dimension(650,700));
	pane.add(canvas);
	canvas.addMouseListener(this);

	buttons = new JPanel();
	buttons.setLayout(new GridLayout(5,1));
	buttons.setPreferredSize(new Dimension(121,725));
	buttons.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	pane.add(buttons);

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
	slip1 = new Stuff(429,466,657,677);
	slip2 = new Stuff(99,115,465,479);
	
	t = new Animals(this,true,1);
	r = new Animals(this,true,2);
	a = new Animals(this,true,3);
	d1 = new Drawer(this,true,true);
	d3 = new Drawer(this,true,false);

	//set up inventory
	//inventory = new ArrayList<Stuff>();
	//inHand = new InventoryItem("null", "null"); //initialized but doesn't do anything yet
	key1 = new InventoryItem("silver key", "SilverKey.png");
	key1.addActionListener(aL);
	key3 = new InventoryItem("gold key", "GoldKey.png");
	key3.addActionListener(aL);
	phone = new InventoryItem("phone", "Phone.png");
	phone.addActionListener(aL);
	scissors = new InventoryItem("scissors", "Scissors.png");
	scissors.addActionListener(aL);
	slips = new InventoryItem("Slips: 1/5");
	slips.addActionListener(aL);
	
    }
	
    private class InventoryItem extends JButton{
	private BufferedImage i;

	public InventoryItem(String text){
	    super(text);     	 
	    setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));  
	}

	public InventoryItem(String name, String imageName){
	    super.setName(name);
	    setImage(imageName);
	    setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	}
	
	public void setImage(String fileName){
	    try {                
		i = ImageIO.read(new File("images/items/" + fileName));
	    } catch (IOException ex) {
		System.out.println("phone");
	    }
	}

	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.drawImage(i,0,0, null);
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
