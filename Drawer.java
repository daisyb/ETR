import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//NON-RUNABLE
//still in the works till I make the drawer images


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
		setImage(folder + "dempty");
		canvas.update(canvas.getGraphics());
		scissors.setActive(false);
	    }
	} else {
	    if(phone.withinBounds(x,y) && isActive()){
		foundPhone = true;
		if(slip.isActive()){
		    setImage(folder+"d2NoPhone");
		}else{
		    setImage(folder+"dempty");
		}
		canvas.update(canvas.getGraphics());
		phone.setActive(false);
	    }else if(slip.withinBounds(x,y) && isActive()){
		foundlip = true;
		if(key.isActive()){
		    setImage(folder+"d2NoSlip");
		}else{
		    setImage(folder+"dempty");
		}
		canvas.update(canvas.getGraphics());
		phone.setActive(false);
	    }
	}
    }

    //constructor
    public Drawer(JFrame parent, boolean modal,boolean isDrawer1){
	super(parent, true);
	Drawer1 = isDrawer1;
	setSize(400,400);
	setTitle("Inside the Drawer");

	if(Drawer1){
	    setImage("images/drawers/d1");
	}else{
	    setImage("images/drawers/d2");
	}

	pane = getContnentPane();
	
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	/*
	  have to figure out the coordinates for these 
	  once the image is done:
	    scissors = new Stuff(blahlabladlhg);
	    slip = new Stuff(badjgfhasdjkghs);
	    phone = new Stuff(blahblahabval);
	*/

	setVisible(true);
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
