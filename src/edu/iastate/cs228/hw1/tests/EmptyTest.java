package edu.iastate.cs228.hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import edu.iastate.cs228.hw1.Empty;
import edu.iastate.cs228.hw1.State;
import edu.iastate.cs228.hw1.Town;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmptyTest {
    @Test
    void testA(){
        Town t = new Town(2, 2);

        t.grid[0][0] = new Empty(t, 0, 0);
        t.grid[0][1] = new Empty(t, 0, 1);
        t.grid[1][0] = new Empty(t, 1, 0);
        t.grid[1][1] = new Empty(t, 1, 1);

        Assertions.assertEquals(State.CASUAL, t.grid[0][0].next(t).who());

    }
}
