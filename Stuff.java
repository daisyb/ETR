

//class for items in the room
public class Stuff{
    private int[] coord; //holds cordinates of item in order x1,x2,y1,y2
    private String name;
    private boolean active;

    public Stuff(){
	coord = new int[4];
	active = true;
    }

    public Stuff(int x1, int x2, int y1, int y2){
        this();
	setXY(x1,x2,y1,y2);
    }
    //names apply to inventory items only
    public Stuff(String name){
	this.name = name;
    }

    public String toString(){
	return name;
    }

    public void setXY(int x1, int x2, int y1, int y2){
	coord[0] = x1;
	coord[1] = x2;
	coord[2] = y1;
	coord[3] = y2;
    }

    //returns array with all 4 coordinates in it
    public int[] getXY(){
	return coord;
    }
	
    //tests if the given (x,y) is within the bounds of the item
    public boolean withinBounds(int xLocation, int yLocation){
	if( xLocation >= coord[0] &&
	    xLocation <= coord[1] &&
	    yLocation >= coord[2] &&
	    yLocation <= coord[3]){
	    return true;
	}
	return false;
    }
	
    public void setName(String s){
	name = s;
    }

    public String getName(){
	return name;
    }

    public boolean isActive(){
	return active;
    }

    public void setActive(boolean b){
	active = b;
    }
}
