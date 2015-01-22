import java.awt.*;
import javax.swing.*;

public class ImagePopups extends Popup {

    private Container pane;
    private JPanel canvas;
    
    public ImagePopups(JFrame parent, boolean modal, int o) {
	super(parent, true);
	setSize(550, 550);
	
	if (o == 1) {
	    setTitle("Phone");
	    setImage("images/phone.bmp");
	} else if (o == 2) {
	    setTitle("Slips");
	    setImage("images/appa.bmp");
	} else {
	    setTitle("Darwin's Book");
	    setImage("images/totoro.jpg");
	}

	pane = getContentPane();
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
    }
}

	
	    
