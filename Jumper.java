
import info.gridworld.grid.Location;

import java.awt.Color;

import info.gridworld.grid.Grid;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Actor;
/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Jumper extends Bug
{
    /**
     * Constructs a red bug.
     */
     
     private int num;
     private int length;
     private int steps;
    public Jumper()
    {
        setColor(Color.BLUE);
        num = 0;
        length = 5;
    }

    /**
     * Constructs a bug of a given color.
     * @param bugColor the color for this bug
     */
    public Jumper(Color bugColor)
    {
        setColor(bugColor);
        num = 0;
        length = 5;
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
		boolean moved = false;
		
		if(steps<length)
		{
			while(num<8 && !moved)
			{
				num++;
				if (newCanMove())
				{
					steps++;
					newMove();
					num = 0;
					moved = true;	
				}
				else
					turn();
			}
			num = 0;
			if(!moved)
			{
				if (canMove())
				{
						newMove2();
						steps++;
					}
					else
						turn();
			}
		}
		else
		{
			turn();
			steps = 0;
		}
		
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void newMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
            
        int life = (int)(Math.random()*20+1);
        Blossom blossom = new Blossom(life);
        blossom.putSelfInGrid(gr, loc);
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public boolean newCanMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower) && !(neighbor instanceof Blossom);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
    public void newMove2()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        int life = (int)(Math.random()*20+1);
        Blossom blossom = new Blossom(life);
        blossom.putSelfInGrid(gr, loc);
    }
}
