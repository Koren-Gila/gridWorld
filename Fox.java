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
public class Fox extends Critter{
	
	private int steps;

	
	public Fox()
	{
		steps = 0;
		setColor(null);
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(getLocation());
		return locs;
	}
	
	public Location selectMoveLocation(ArrayList<Location> locationsEntered)
	{
		double distance = 100000;
		int closest = 0;
		ArrayList<Location> locs = getGrid().getOccupiedLocations();
		int [] duplicates = new int[locs.size()];
		duplicates[0] = 12345;
		for(int k = 0; k<locs.size(); k++)
		{
			if((getGrid().get(locs.get(k)) instanceof Chicken))
			{
				int x = locs.get(k).getRow() - getLocation().getRow();
				int y = locs.get(k).getCol() - getLocation().getCol();
				
				if(Math.sqrt(x*x + y*y)==distance)
				{
					int count = 0;
					while(duplicates[count] != 12345)
					{
						count++;
					}
					duplicates[count] = k;
				}
				else if(Math.sqrt(x*x + y*y) < distance)
				{
					distance = Math.sqrt(x*x + y*y);
					closest = k;
					for(int z  = 0; z<duplicates.length; z++)
					{
						duplicates[z] = 12345;
					}
					duplicates[0] = k;
				}
				
			}
		}
		int ch = 0;
		if(duplicates[0] == 12345)
		{
			return super.selectMoveLocation(locationsEntered);
		}
		else if(duplicates[1] != 12345)
		{
			int k = 0;
			while(duplicates[k]!=12345)
			{
				k++;
			}
			
			ch = (int)(Math.random()*(k));
			ch = duplicates[ch];
		}
		else
		{
			ch = duplicates[0];
		}
		
		int direction = getLocation().getDirectionToward(locs.get(ch));
		
		Location next = getLocation().getAdjacentLocation(direction);
		
		for(int k = 0; k<locationsEntered.size(); k++)
		{
			if(next.equals(locationsEntered.get(k)))
			{
				return next;
			}
		}
		return super.selectMoveLocation(locationsEntered);
		

	}
	
	public void makeMove(Location loc)
	{
		
		steps++;
		
		if(steps==20)
		{
			die();
		}
		else if(steps>=0)
		{
			if(loc == null)
			{
				removeSelfFromGrid();
			}
			else
			{
				if(loc != getLocation())
				{
					setDirection(getLocation().getDirectionToward(loc));
					moveTo(loc);
				}
				else
				{
					int k = (int)(Math.random()*8);
					setDirection(k*45);
				}
				
			}
		}
		
		
		
	
		
		
		
	}
	
	public void processActors(ArrayList<Actor> actors)
	{
		int count = 0;
		
		if(steps>=0)
		{
			for (Actor a : actors)
        {
            if ((a instanceof Chicken))
               count++;
        }
        if(count==1)
        {
			steps = -10;
			for (Actor a : actors)
			{
				if ((a instanceof Chicken))
				   ((Chicken)a).die();
			}
		}
		else if(count>1)
		{
			steps = -10;
			int rand = (int)(Math.random()*count+1);
			for (Actor a : actors)
			{
				if ((a instanceof Chicken))
				{
					rand--;
					if(rand==0)
					{
						((Chicken)a).die();
					}
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
}
	
