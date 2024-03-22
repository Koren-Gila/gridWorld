import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
	public ArrayList<Location> getMoveLocations()
    {
		Grid<Actor> gr = getGrid();
		
        ArrayList<Location> locs = new ArrayList<Location>();
        
        Location left = getLocation().getAdjacentLocation(getDirection()+ Location.LEFT).getAdjacentLocation(getDirection()+ Location.LEFT);
        Location leftA = getLocation().getAdjacentLocation(getDirection()+ Location.LEFT);
        Location rightA = getLocation().getAdjacentLocation(getDirection()+ Location.RIGHT);
        Location right = getLocation().getAdjacentLocation(getDirection()+ Location.RIGHT).getAdjacentLocation(getDirection()+ Location.RIGHT);
        
        boolean entered = false;
        if(gr.get(right)==null && gr.get(rightA) ==null)
        {
			locs.add(right);
			entered = true;
		}
		if(gr.get(left)==null && gr.get(leftA) ==null)
		{
			locs.add(left);
			entered = true;
		}
		if(!entered)
		{
			super.getMoveLocations();
		}        
        
        return locs;
    }
}
