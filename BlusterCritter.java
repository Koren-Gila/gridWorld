import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;
import info.gridworld.grid.Grid;
import java.util.List;


public class BlusterCritter extends Critter{

	private int courage;
	
	public BlusterCritter(int c)
	{
		courage  = c;
	}
	public ArrayList<Actor> getActors()
    {
		ArrayList<Actor> list = new ArrayList<Actor>();
		
		Grid<Actor> gr = getGrid();
		
        Location loc = getLocation();
        int row = loc.getRow();
        int col = loc.getCol();
        
        for(int r = -2; r<3; r++)
			for(int c = -2; c<3; c++)
			{
				Location l = new Location(row + r, col + c);
				
				if(gr.isValid(l))
					if(gr.get(l) instanceof Critter)
						list.add(gr.get(l));
				
			
			}
		return list;
        
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
        int k = actors.size();
        if(k>courage)
        {
			Color c = getColor();
			int red = (int) (c.getRed() * (1 - 0.05));
			int green = (int) (c.getGreen() * (1 - 0.05));
			int blue = (int) (c.getBlue() * (1 - 0.05));

			setColor(new Color(red, green, blue));
		}
		else
		{
			Color c = getColor();
			int red = (int) (c.getRed() * (1 + 0.05));
			int green = (int) (c.getGreen() * (1 + 0.05));
			int blue = (int) (c.getBlue() * (1 + 0.05));

			setColor(new Color(red, green, blue));
		}
    }


}
