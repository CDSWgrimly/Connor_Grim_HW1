package edu.iastate.cs228.hw1.tests;

import edu.iastate.cs228.hw1.Outage;
import edu.iastate.cs228.hw1.State;
import edu.iastate.cs228.hw1.Town;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Connor Grim
 */
public class OutageTest {
    @Test
    void testA(){
        Town t = new Town(2, 2);
        t.grid[0][0] = new Outage(t, 0, 0);
        t.grid[0][1] = new Outage(t, 0, 1);
        t.grid[1][0] = new Outage(t, 1, 0);
        t.grid[1][1] = new Outage(t, 1, 1);

        Assertions.assertEquals(State.EMPTY, t.grid[0][0].next(t).who());
    }
}
