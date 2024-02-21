package edu.iastate.cs228.hw1.tests;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Connor Grim
 */
public class StreamerTest {
    Town t;
    @BeforeEach
    void init() {
        t = new Town(2, 2);
    }
    @Test
    void testA(){
        t.grid[0][0] = new Streamer(t, 0, 0);
        t.grid[0][1] = new Outage(t, 0, 1);
        t.grid[1][0] = new Outage(t, 1, 0);
        t.grid[1][1] = new Reseller(t, 1, 1);

        assertEquals(State.OUTAGE, t.grid[0][0].next(t).who());
    }
    @Test
    void testB(){
        t.grid[0][0] = new Streamer(t, 0, 0);
        t.grid[0][1] = new Outage(t, 0, 1);
        t.grid[1][0] = new Outage(t, 1, 0);
        t.grid[1][1] = new Outage(t, 1, 1);

        assertEquals(State.EMPTY, t.grid[0][0].next(t).who());
    }
}
