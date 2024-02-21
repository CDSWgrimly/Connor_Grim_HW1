package edu.iastate.cs228.hw1.tests;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Connor Grim
 */
public class TownCellTest {
    Town t;
    @BeforeEach
    void init(){
        t = new Town(2, 3);

        t.grid[0][0] = new Casual(t, 0, 0);
        t.grid[0][1] = new Casual(t, 0, 1);
        t.grid[0][2] = new Casual(t, 0, 2);
        t.grid[1][0] = new Reseller(t, 1, 0);
        t.grid[1][1] = new Casual(t, 1, 1);
        t.grid[1][2] = new Casual(t, 1, 2);
    }

    @Test
    void testWho(){
        assertEquals(State.RESELLER, t.grid[1][0].who());
    }
}
