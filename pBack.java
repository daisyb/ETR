import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
  Creates window for picking up the key and slip items 
  on the back of the painting
*/

public class pBack extends Popup{
    private Container pane;
    private JPanel canvas;
    private Stuff key, slip;

    //changes image based on whether the user
    //clicked on an item or not
    public void mouseClicked(MouseEvent e) {
	int x = e.getX();
	int y = e.getY();
	if(key.withinBounds(x,y) && key.isActive()){
	
	    if(slip.isActive()){
		setImage("images/painting/pJustSlip.bmp");
	    } else {
		setImage("images/painting/pNothin.bmp");
	    }	
	    canvas.update(canvas.getGraphics());
	    key.setActive(false);

	} else if (slip.withinBounds(x,y) && slip.isActive()){

	    if(key.isActive()){
		setImage("images/painting/pJustKey.bmp");
	    }else {
		setImage("images/painting/pNothin.bmp");
	    }
	    canvas.update(canvas.getGraphics());
	    slip.setActive(false);
	}
    }

    //constructor
    public pBack(JFrame parent, boolean modal){
	super(parent,true);
	setSize(400,530);	
	setTitle("Back of Poster");
	setImage("images/painting/pBack.bmp");

	pane = getContentPane();

	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);

	key = new Stuff(100,264,116,193);
	slip = new Stuff(86,258,268,312);
	
	setVisible(true);
    }
    
    
}
