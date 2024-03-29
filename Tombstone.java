
import java.awt.Color;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class Tombstone extends Actor
{

    private int lifeSpan;




    public Tombstone()
    {
        lifeSpan = 20;
    }
    

    public void act()
    {
        lifeSpan--;
        
        if(lifeSpan==0)
        {
			removeSelfFromGrid();
		}
    }
}
