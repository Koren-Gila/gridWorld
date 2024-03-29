
import java.awt.Color;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class Egg extends Actor
{

    private int steps;

    public Egg()
    {
		setColor(Color.WHITE);
        steps=0;
    }
    

    public void act()
    {
		steps++;
		if(steps<45)
		{
			Color c = getColor();
			int red = (int) (c.getRed() * (0.95));
			int green = (int) (c.getGreen() * (0.95));
			int blue = (int) (c.getBlue() * (0.95));

			setColor(new Color(red, green, blue));
		}
		else if(steps<50)
		{
			setColor(Color.RED);
		}
		else if(steps==50)
		{
			Chicken chic = new Chicken();
			chic.putSelfInGrid(getGrid(), getLocation());
		}
		
		
    }
}
