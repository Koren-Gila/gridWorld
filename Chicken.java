import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;
import info.gridworld.grid.Grid;
import java.util.List;

/**
 * 
 */
public class Chicken extends Critter{
	
	private int steps;

	
	public Chicken()
	{
		setColor(Color.WHITE);
		steps = 0;
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		Grid<Actor> gr = getGrid();
		if(Math.random()>0.5)
		{
			Location loc = getLocation().getAdjacentLocation(getDirection());
			if(gr.isValid(loc))
			{
				if(gr.get(loc) == null)
					locs.add(loc);
			}
			
		}
		
		return locs;
	}
	
	public Location selectMoveLocation(ArrayList<Location> locs)
    {
		int n = locs.size();
		if (n == 0)
		{
		   return getLocation();
		   
		}
		return locs.get(0);
        
    }
    
    public void makeMove(Location loc)
    {
		if(loc == getLocation())
		{
			int k = (int)(Math.random()*8);
		   k = k *45;
		   setDirection(k);
		}
		steps++;
		if(steps==300)
		{
			die();
		}
		else if(steps>=280)
		{
			
			Color c = getColor();
			int red = (int) (c.getRed() * (0.95));
			int green = (int) (c.getGreen() * (0.95));
			int blue = (int) (c.getBlue() * (0.95));

			setColor(new Color(red, green, blue));
			
			if(steps%4==0)
			{
				if (loc == null)
					removeSelfFromGrid();
				else
					moveTo(loc);
			}
		}
		else if(steps>=200)
		{
			if(steps%2==0)
			{
				if (loc == null)
					removeSelfFromGrid();
				else
					moveTo(loc);
			}
		}
		else
		{
			if (loc == null)
				removeSelfFromGrid();
			else
			{
				Location current = getLocation();
				if(loc != current)
				{
					moveTo(loc);
					if(Math.random()*20<1)
					{
						Egg eg = new Egg();
						eg.putSelfInGrid(getGrid(), current);
					}
				}
				
			}
		}
		
	}
    
    public void die()
    {
		Location loc = getLocation();
		Tombstone tom = new Tombstone();
		tom.putSelfInGrid(getGrid(), loc);
	}
	
	public void processActors(ArrayList<Actor> list)
	{
		
	}
	
}
