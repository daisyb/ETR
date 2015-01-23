import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
  creates window for inside stuffed animals
  changes behaivior based on int animalnum
  if animalnum == 1 --> totoro
  2 --> rilakkuma
  3 --> appa
*/

public class Animals extends Popup{
    private Container pane;
    private JPanel canvas;
    private Stuff key, slip;
    private boolean foundKey, foundSlip;
    private int animalnum;

    //changes the background image based on whether the user
    //clicked on an item or not
    public void mouseClicked(MouseEvent e){
	String folder = "images/stuffed/";
	int x = e.getX();
	int y = e.getY();
	if(animalnum == 1){
	    if(slip.withinBounds(x,y) && isActive()){
		foundSlip = true;
		setImage(folder + "stuffedEmpty.bmp");
		canvas.update(canvas.getGraphics());
		slip.setActive(false);
	    }
	} else if (animalnum == 3){
	    if(key.withinBounds(x,y) && isActive()){
		foundKey = true;
		setImage(folder + "stuffedEmpty.bmp");
		canvas.update(canvas.getGraphics());
		key.setActive(false);
	    }
	}


    }

    //constructor
    public Animals(JFrame parent, boolean modal, int whichAnimal){
	super(parent, true);
	animalnum = whichAnimal;
	setSize(475,375);
	if(animalnum == 1){
	    setTitle("Inside Totoro");
	    setImage("images/stuffed/stuffedSlip.bmp"); //setImage() from Popup.java
	}else if (animalnum == 2){
	    setTitle("Inside Rilakkuma");
	    setImage("images/stuffed/stuffedEmpty.bmp");
	}else{
	    setTitle("Inside Appa");
	    setImage("images/stuffed/stuffedKey.bmp");
	}

	pane = getContentPane();
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
	canvas.addMouseListener(this);
	
	key = new Stuff(81,265,133,197);
	slip = new Stuff(211,387,189,286);

	foundSlip = false;
	foundKey = false;

    }



    //methods to tell Room.java which items
    //the user picked up
    public boolean hasKey(){
	return foundKey;
    }

    public boolean hasSlip(){
	return foundSlip;
    }

}
