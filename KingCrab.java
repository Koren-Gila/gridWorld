import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter
{
	 public void processActors(ArrayList<Actor> actors)
	{
		Grid<Actor> gr = getGrid();
		for (Actor a : actors)
		{
			Location loc = getLocation().getAdjacentLocation(getLocation().getDirectionToward(a.getLocation()));
			if(gr.isValid(loc))
			{
				a.moveTo(loc);
			}
			else
			{
				a.removeSelfFromGrid();
			}
		}
	}
}
