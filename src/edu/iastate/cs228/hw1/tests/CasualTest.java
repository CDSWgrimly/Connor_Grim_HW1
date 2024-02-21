package edu.iastate.cs228.hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Connor Grim
 */
public class CasualTest {

    @Test
    void testA(){
        Town t = new Town(2, 2);

        t.grid[0][0] = new Casual(t, 0, 0);
        t.grid[0][1] = new Casual(t, 0, 1);
        t.grid[1][0] = new Casual(t, 1, 0);
        t.grid[1][1] = new Casual(t, 1, 1);

        Assertions.assertEquals(State.RESELLER, t.grid[0][0].next(t).who());
    }

    @Test
    void testB(){
        Town t = new Town(2, 2);

        t.grid[0][0] = new Casual(t, 0, 0);
        t.grid[0][1] = new Streamer(t, 0, 1);
        t.grid[1][0] = new Empty(t, 1, 0);
        t.grid[1][1] = new Empty(t, 1, 1);

        assertEquals(State.STREAMER, t.grid[0][0].next(t).who());

    }

    @Test
    void testC(){
        Town t = new Town(2, 2);

        t.grid[0][0] = new Casual(t, 0, 0);
        t.grid[0][1] = new Casual(t, 0, 1);
        t.grid[1][0] = new Empty(t, 1, 0);
        t.grid[1][1] = new Empty(t, 1, 1);

        assertEquals(2, ISPBusiness.getProfit(t));
    }
}
