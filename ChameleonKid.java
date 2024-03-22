import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;

public class ChameleonKid extends ChameleonCritter{

	public ArrayList<Actor> getActors()
	{
		Grid<Actor> gr = getGrid();
		ArrayList<Actor> list = new ArrayList<Actor>();
		Location front = getLocation().getAdjacentLocation(getDirection());
		Location back = getLocation().getAdjacentLocation(getDirection() + 180);
		
		Actor ac1 = new Actor();
		Actor ac2 = new Actor();
		if(gr.isValid(front))
		{
			ac1 = gr.get(front);
		}
		if(gr.isValid(back))
		{
			ac2 = gr.get(back);
		}
		
		
		
		if(ac1 != null)
			list.add(ac1);
		if(ac2!=null)
			list.add(ac2);
		return list;
		
	}


}
