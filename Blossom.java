
import java.awt.Color;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class Blossom extends Flower
{
    private static final Color DEFAULT_COLOR = Color.GREEN;
    private static final double DARKENING_FACTOR = 0.05;
    private int lifeSpan;

    // lose 5% of color value in each step

    /**
     * Constructs a pink flower.
     */
    public Blossom()
    {
        setColor(DEFAULT_COLOR);
        lifeSpan = 10;
    }
    
    public Blossom(int life)
    {
		setColor(DEFAULT_COLOR);
		lifeSpan = life;
	}

    /**
     * Constructs a flower of a given color.
     * @param initialColor the initial color of this flower
     */
    public Blossom(Color initialColor)
    {
        setColor(initialColor);
    }

    /**
     * Causes the color of this flower to darken.
     */
    public void act()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
        
        lifeSpan--;

        setColor(new Color(red, green, blue));
        
        if(lifeSpan==0)
        {
			removeSelfFromGrid();
		}
    }
}
