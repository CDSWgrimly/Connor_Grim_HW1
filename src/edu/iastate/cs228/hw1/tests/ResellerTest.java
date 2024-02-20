package edu.iastate.cs228.hw1.tests;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ResellerTest {
    @Test
    void testA(){
        //Tests Reseller's Rule 1
        Town t = new Town(4, 4);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j <= 3; j++){
                t.grid[i][j] = new Empty(t, i, j);
            }
        }
        for (int i = 0; i < 3; i++){
            t.grid[3][i] = new Reseller(t, 3, i);
        }

        assertEquals(State.EMPTY, t.grid[3][0].next(t).who());
    }

}
