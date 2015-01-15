import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
  creates window for inside stuffed animals
  changes behaivior based on int animalnum
  if animalnum == 1 --> totoro
  2 --> rilakuma
  3 --> appa
*/

public class Animals extends Popup{
    private Container pane;
    private JPanel canvas;
    private Stuff key, slip;
    private boolean foundKey, foundSlip;
    private int animalnum;

    private void mouseClicked(MouseEvent e){
	String folder = "images/stuffed/";
	int x = e.getX();
	int y = e.getY();
    }

    public Animals(JFrame parent, boolean modal, int whichAnimal){
	super(parent, true);
	animalnum = whichAnimal;
	setSize(200,400);
	if(animalnum == 1){
	    setTitle("Inside Totoro");
	    setImage("images/stuffed/somethinf");
	}
    }

}
