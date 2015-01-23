import java.awt.*;
import javax.swing.*;

public class ImagePopups extends Popup {

    private Container pane;
    private JPanel canvas;
    
    public ImagePopups(JFrame parent, boolean modal, int o) {
	super(parent, true);
	
	if (o == 1) {
	    setTitle("Phone");
	    setImage("images/items/phonePop.png");
	} else if (o == 2) {
	    setTitle("Slips");
	    setImage("images/items/Slip.png");
	} else {
	    setTitle("Darwin's Book");
	    setImage("images/items/Book.png");
	}

	pane = getContentPane();
	canvas = new Canvas();
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
    }
}

	
	    
