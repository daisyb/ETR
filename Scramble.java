import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*; 

public class Scramble extends JDialog{

    /*-------------------------Instance variables-------------------*/
    private Random rnd = new Random(); 
    private BufferedImage image; //stores image
    private Container pane;     //holds everything
    private JPanel grid,userInfo; //contains image pieces(boxes)
    private JButton submit, clear; //'submit' checks puzzle, 'clear' clears onscren meassages
    private JTextArea instructions,t; //text area to hold instructions
    private Box[] boxList; //array of buttons with pieces of the image on it, Box is a custom class
    private int[][] key; // holds the cordinates of the correct puzzle configuration
    private int clicked, middle; //keeps track of which button was pressed
    private boolean winner;


    /*---------------------------Listeners---------------------------*/

    //Listener for the submit and clear buttons
    //if 'submit' checks if the current formation of images is correct
    //and adds 'instructions' to a box
    //if 'clear' clears the 'instructions' box of text
    private ActionListener aL = new ActionListener(){
	    public void actionPerformed(ActionEvent ae){
		middle = 27;
		if(ae.getSource() == submit && t.getParent() != boxList[middle]){
		    if(isCorrect(key,boxList)){
			t = new JTextArea(" Success!\n Close\n window\n to continue");
			t.setEditable(false);
			t.setBackground(Color.YELLOW);
			boxList[middle].add(t);
			boxList[middle].revalidate();
			winner = true;
			unEnable(boxList);
		    }else {
			t = new JTextArea("\n Incorrect,\n Click 'Clear'\n to continue");
			t.setEditable(false);
			t.setBackground(Color.RED);
			boxList[middle].add(t);
			boxList[middle].revalidate();
		    }
		} else if (ae.getSource() == clear){    
		    try{
			boxList[middle].remove(t);
		    } catch(Exception e){}
		    boxList[middle].repaint();
		}
		    
	    }
	};

    //Listener for box's in the picture puzzle
    //stores the index of the currently clicked box in 'clicked' and
    //switches the images on two box's if one box is already clicked
    private  ActionListener actionListener = new ActionListener() {
	    public void actionPerformed(ActionEvent actionEvent) {
		Box b = (Box) actionEvent.getSource();
		if(clicked == -1){
		    b.setSelected(true);
		    b.setBorder(BorderFactory
				 .createLineBorder(Color.GREEN));
		     clicked = b.getBoxNum();
		} else if (b.getBoxNum() == clicked){
		    boxList[clicked].setSelected(false);
		    boxList[clicked].setBorder(BorderFactory
						 .createLineBorder(Color.BLUE));
		    clicked = -1;
		} else {
		    switchPlaces(boxList[clicked],b);
		    boxList[clicked].setSelected(false);
		    boxList[clicked].setBorder(BorderFactory
						 .createLineBorder(Color.BLUE));
		    clicked = -1;
		    b.setSelected(false);
		    b.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
	    }
	};

    /*----------------------Constructor--------------------------*/

    public Scramble(JFrame parent,boolean modal){
	super(parent, true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setTitle("Picture Scramble");
	setSize(800,600);
	setLocation(200,150);

	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	//setResizable(false);
	pane = getContentPane();        
	pane.setLayout(new BoxLayout(pane,BoxLayout.X_AXIS));
	
	grid = new JPanel();
	grid.setMaximumSize(new Dimension(450,600));
	grid.setMinimumSize(new Dimension(450,600));
	grid.setLayout(new GridLayout(8,6));
	try {                
	    image = ImageIO.read(new File("images/pokecenter.jpg"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}
	boxList = new Box[48];
	makeBoxes(boxList);
	makeKey();
       	shuffle(boxList);
	ColorBorders(boxList);
        for(int i = 0; i < boxList.length;i++){
	    boxList[i].setBoxNum(i);
	    grid.add(boxList[i]);
	}
	pane.add(grid);
	winner = false;
	clicked = -1;
	userInfo = new JPanel();
	userInfo.setMaximumSize(new Dimension(350,200));
	userInfo.setLayout(new BoxLayout(userInfo,BoxLayout.Y_AXIS));
	t = new JTextArea();
	String s = new String();
	s = " Complete the picture by reorganizing the frames.\n To switch a frame's location click on the frame and\n then click the frame you'd like to switch it with.\n Frames bordered in grey cannot be switched.\n Click 'Submit' when done.\n Click 'Clear' to clear on screen messages.";
	instructions = new JTextArea(s);
	instructions.setColumns(10);
	instructions.setRows(100);
	instructions.setBorder(BorderFactory.createLineBorder(Color.red,2));
	instructions.setEditable(false);
	userInfo.add(instructions);
	submit = new JButton("Submit");
	submit.setAlignmentX(Component.CENTER_ALIGNMENT);
	submit.addActionListener(aL);
	clear = new JButton("Clear");
	clear.setAlignmentX(Component.CENTER_ALIGNMENT);
	clear.addActionListener(aL);	
	userInfo.add(submit);
	userInfo.add(clear);
	pane.add(userInfo);

	setVisible(true);

	
    }
    

    /*---------------------------Methods-----------------------------*/

    //switches boxes in boxList to shuffle the image formation
   public void shuffle(Box[] buttons){
	for(int i = buttons.length -1; i > 0;i--){
	    if(i%3 == 0){
		int index = rnd.nextInt(i + 1);
      	        Box temp = buttons[index];
		buttons[index] = buttons[i];
		buttons[i] = temp;
		buttons[index].setEnabled(true);
		buttons[i].setEnabled(true);		
	    }
	}
	} 

    //initializes the boxes in boxList
    public void makeBoxes(JToggleButton[] buttons){
	int index = 0;
	for(int k = 0; k < 8;k++){
	    int y = k*75;
	    for(int j = 0; j < 6; j++){
		int x= j*75;
		buttons[index] = new Box(0,x,y);
		buttons[index].update(buttons[index].getGraphics());
		buttons[index].setEnabled(false);
		index += 1;
	    }
	}

    }
    
    //switches the images depicted on two buttons(boxes)
    public void switchPlaces(Box b1, Box b2){
	int x1 = b1.getx();
	int y1 = b1.gety();
	int x2 = b2.getx();
	int y2 = b2.gety();
	b1.setCoordinates(x2,y2);
	b2.setCoordinates(x1,y1);
	b1.repaint();
	b2.repaint();
    }
    
    //sets up the game by changing the colors of the bordes of enabled and unenabled boxes
    public void ColorBorders(JToggleButton[] buttons){
	for(int i = 0;i< buttons.length;i++){
	    if(!buttons[i].isEnabled()){
		buttons[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    } else {
		buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
		buttons[i].addActionListener(actionListener);
	    }
	}
    }
    
    //creates a key which hold the coordinates of a correct picture configuration
    public void makeKey(){
	int y = 0;
	int x = 0;
	int index = 0;
	key = new int[48][2];
	for(int k=0;k<8 ;k++){
	    y = k*75;
	    for(int j=0;j<6;j++){
		x=j*75;
		key[index][0] = x;
		key[index][1] = y;
		index +=1;
	    }
	}

    }

    //checks the information stored in key[][] against boxList[]
    public boolean isCorrect(int[][] ans, Box[] submit){
      	for(int i = 0; i < ans.length; i ++){
	    if(submit[i].getx() != ans[i][0] ||
	       submit[i].gety() != ans[i][1]){
		
		return false;
	    }
	}
	return true;
    }

    //unenables all boxes for end game sequence
    public void unEnable(Box[] b){
	for(int i = 0; i < b.length;i++){
	    b[i].setEnabled(false);
	    b[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}
    }

    public boolean getWinner(){
	return winner;
    }
    
    

    /*----------------------------------Classes-----------------------------------*/

    /*
      Box is a JToggleButton which stores information about 
      which piece of 'image' is depicted on the button with a 
      paintComponent method to paint this piece on the button
    */

    private class Box extends JToggleButton {
	int dstx1;
	int dsty1;
	int srcx1;
	int srcy1;
	int serialNum = 0; //stores index in boxList

	public Box(int dst, int srcx, int srcy){
	    dstx1 = dst;
	    dsty1 = dst;
	    srcx1 = srcx;
	    srcy1 = srcy;
	}

	public int getBoxNum(){
	    return serialNum;
	}

	public void setBoxNum(int n){
	    serialNum = n;
	}

	public void setCoordinates(int srcx, int srcy){
	    srcx1 = srcx;
	    srcy1 = srcy;
	}

	public int getx(){
	    return srcx1;
        }
	
	public int gety(){
	    return srcy1;
	}


	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, dstx1, dsty1, dstx1+75, dsty1+75, 
		        srcx1, srcy1, srcx1+75, srcy1+75, null);
	}
    }



}
