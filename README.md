Caisy's Room
===

Camille Casino

Daisy Barbanel

Period 1

##Concept

Welcome to Caisy's Room.
This is a point and click puzzle game, and your objective is to escape the room.
Click around to explore the environment.
If you pick something up, it will show on the right as an inventory item. Click on the inventory item to use it. You can use the items to interact with the environment.
Remember to think outside the box!

##ChangeLog

12/22
- Created Office/Image.java and added code for opening images using gui

12/28-1/1
- Daisy: created & completed Scramble.java which runs an image based puzzle

1/4
- Camille & Daisy: finalized outline for the puzzles

1/5
- Camille & Daisy: began Keypad.java, the final way to exit the room
  - implemented MouseListener interface

1/6
- Camille: worked on visuals of Keypad.java
- Daisy: Changed Scramble.java to work with new visuals

1/7
- Daisy: worked on Stuff sub-class of Room.java for items
  - set up clickability for said items

1/9 - 1/10
- Daisy: got Scramble.java to act as a modal dialog box
  - started working on an inventory array in Room.java

1/11
- Daisy: Added clickable properties to a new item in the room, the book
  - made Stuff.java its own file outside of Room.java
  - created pBack.java which runs after the Scramble.java puzzle is completed
    - pBAck lets the user click on items that will enter their inventory

1/12
- Daisy: Added Popup.java, an abstract class for all popup JDialog Boxes
  - started Drawer.java which is similar to pBack except for the Drawers
  - modified pBack and Drawer.java to extend Popup.java

1/13
- Camille: remade image for Keypad.java (screen was crooked)
  - converted Keypad.java into a modal dialog box

1/15
- Daisy: Completed Drawer.java and instantiated in Room.java
  - Created Animals.java which runs the popups for the stuffed animals in the room

1/17
- Daisy: Completed Animals.java

1/19
- Daisy: Instantiated Aniamls.java in Room.java
  - Modified the way popups work in Room.java
    - This way even after the user has taken items, they can still open the window

1/21
- Daisy: Completed inventory in Room.java
  - Basically a JPanel() with buttons for each item in it
- Camille and Daisy: created ImagePopups class, which is a simple subclass of Popup except with only the image and no Action/MouseListener

1/22
- Camille: made endscreen for the end of the puzzle
  - commented code
- Daisy: Final modifications, cleaned up code, added comments, etc.


## 