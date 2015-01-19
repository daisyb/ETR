import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
  creates window for looking inside either drawer
  chages behaivior based on the boolean drawer1
*/

public class Drawer extends Popup{
    private Container pane;
    private JPanel canvas;
    private Stuff scissors, slip, phone;
    private boolean Drawer1,foundScissors,foundPhone,foundSlip;

    //changes the background image based on whether the user
    //clicked on an item or not
    public void mouseClicked(MouseEvent e) {
	String folder = "images/drawers/";
	int x = e.getX();
	int y = e.getY();
	if(Drawer1){
	    if(scissors.withinBounds(x,y) && isActive()){
		foundScissors = true;
		setImage(folder + "dempty.png");
		canvas.update(canvas.getGraphics());
		scissors.setActive(false);
	    }
	} else {
	    if(phone.withinBounds(x,y) && isActive()){
		foundPhone = true;
		if(slip.isActive()){
		    setImage(folder+"d2NoPhone.png");
		}else{
		    setImage(folder+"dempty.png");
		}
		canvas.update(canvas.getGraphics());
		phone.setActive(false);
	    }else if(slip.withinBounds(x,y) && isActive()){
		foundSlip = true;
		if(phone.isActive()){
		    setImage(folder+"d2NoSlip.png");
		}else{
		    setImage(folder+"dempty.png");
		}
		canvas.update(canvas.getGraphics());
		slip.setActive(false);
	    }
	}
    }

    //constructor
    public Drawer(JFrame parent, boolean modal,boolean isDrawer1){
	super(parent, true);
	Drawer1 = isDrawer1;
	setSize(500,600);
	setTitle("Inside the Drawer");

	if(Drawer1){
	    setImage("images/drawers/d1.png"); //setImage() from Popup class
	}else{
	    setImage("images/drawers/d2.png");
	}

	pane = getContentPane();
       	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	scissors = new Stuff(154,358,171,400);
	slip = new Stuff(110,200,462,500);
	phone = new Stuff(212,313,167,343);

	foundScissors = false;
	foundPhone = false;
	foundSlip = false;

    }
 
    //methods to tell Room.java which items
    //the user picked up
    public boolean hasScissors(){
	return foundScissors;
    }
    
    public boolean hasPhone(){
	return foundPhone;
    }

    public boolean hasSlip(){
	return foundSlip;
    }
    
}
