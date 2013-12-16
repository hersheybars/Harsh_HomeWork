

/** 
 * A AmericanFlag object sets up and draws a American flag on the GUI through the 
 * specified height and width. It extends the JPanel in order to draw 2D Shapes
 * on the GUI
 *@author Arpit Khatri
 */

// Import all the needed libraries to build the flag
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class AmericanFlag extends JPanel
{	
	private double height; // Represents the height of the entire flag
	private double width;  // Represents the width of the entire flag
	
	/**
	 * Constructor of AmericanFlag class that initializes the width and the height 
	 * of the American flag
	 * @param tempWidth the width of the flag
	 * @param tempHeight the height of the flag
	 */
	public AmericanFlag(double tempWidth, double tempHeight)
	{
		width = tempWidth;
		height = tempHeight;	
	}
	
	/**
	 * Sets up the American flag based on the width and the height specified and 
	 * puts it on the GUI through Graphics. Gets automatically called when used 
	 * with GUI and initializing an AmericanFlag object
	 * @param g the Graphics component used to draw the 2D shapes on the GUI
	 */
	public void paintComponent(Graphics g)
	{
		// Get the Graphics2D version of the Graphics g by casting
		Graphics2D g2 = (Graphics2D) g;
		
		// Represents the width and the x coordinate of drawing the red and white
		// rectangles in the panel. Initially set to the value of drawing the 
		// rectangles to the right of the union.
		double rectWidth = .6*width;
		double xCoord = .4*width;
		
		// Draw the Union on the panel
		g2.setPaint(Color.BLUE);
		g2.fill(new Rectangle2D.Double(0,0,.4*width,.53846*height));		
		
		// Draw the thirteen red and white rectangular stripes on the panel
		for(int i=0; i<13; i++)
		{
			// Change the x coordinate and the width of the stripes when it is 
			// time to draw the eigth stripe on the flag as it should be drawn 
			// below the union 
			if(i==7)
			{
				xCoord = 0;
				rectWidth = width;	
			}
			
			// Alternate the color for each stripe between red and white	
			if(i%2==0)
				g2.setPaint(Color.RED);
			else
				g2.setPaint(Color.WHITE);
			
			// Draw the rectangle on the panel. It will be added with the specified color.
			// Keeps changing the yCoord of the stripes to be down number of rectangles 
			// already drawn * (.0769 * height) which represents the height of each stripe	
			g2.fill(new Rectangle2D.Double(xCoord,i*.0769*height,rectWidth,.0769*height));	
		}
		
		
		// Set up the general coordinates of the star  based on height and width such that a 
		// line can be drawn from each set of x and y points to be formed into a new star
		// shape with five points
		double x[] = {.0002105*width, .0126*width, .0163*width, .02*width, .0324*width, 
					  .0217*width, .02574*width, .0163*width, .0069*width, .0109*width};
        double y[] = {.02*height, .02*height, 0, .02*height, .02*height, .03*height, 
        			  .05*height, .04*height, .05*height, .03*height};
		
		// Initialize a general path object that helps in drawing the line of the points
		// designated in the array of x and y
		GeneralPath star = new GeneralPath();
        
       	// Move the star to point to the initial point to start the drawing of the star
       	star.moveTo((float)x[0],(float)y[0]);
        
        // Draws the general line for the star
        for(int i=1; i<x.length; i++)
        {
        	star.lineTo((float)x[i],(float)y[i]);
        }
        	 
        // Close the path to the star and thus a star with 5 points shape is form
        star.closePath();
        
        // Set up the initial point of the corner of the left square where the star will be 
        // drawn and let the g2 draw the inital star.
        g2.translate(.017*width,.0232*height); 
        g2.setPaint(Color.WHITE);
        g2.fill(star);
        
        // Add the first row of stars to the flag by adding the rest of 5 stars
        // in the first row
        for(int i=0; i<5; i++)
        {
        	g2.translate(.066316*width,0); 
	        g2.fill(star);
        }
        
        // Draw the remaining 8 rows of stars in sets of two rows each
        for(int i=0; i<4; i++)
        {
        	// Set up the initial point of the corner of the left square where
        	// the star will be drawn
        	g2.translate(-.03316*width,.054*height); 
	        g2.fill(star);
	        
	        // Draw the rest of the 4 stars in that row
	        for(int j=0; j<4; j++)
	        {
	        	g2.translate(-.066316*width,0); 
		        g2.fill(star);
	        }
	      
	      	// Go to next row...
	      	
	        // Set up the initial point of the corner of the left square where
        	// the star will be drawn
	        g2.translate(-.03316*width,.054*height); 
	        g2.fill(star);
	        
	        // Draw the rest of the 5 stars in that row
	        for(int k=0; k<5; k++)
	        {
	        	g2.translate(.066316*width,0); 
		        g2.fill(star);
	        }
        }      
	}
}