package edu.iastate.cs228.hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import edu.iastate.cs228.hw1.ISPBusiness;
import edu.iastate.cs228.hw1.State;
import edu.iastate.cs228.hw1.Town;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

/**
 * @author Connor Grim
 */
public class ISPBusinessTest {
    Town t;
    @BeforeEach
    void init() throws FileNotFoundException{
        t = new Town("ISP4x4.txt");
    }

    @Test
    void testUpdatePlain(){
        t = ISPBusiness.updatePlain(t);
        Assertions.assertEquals(State.EMPTY, t.grid[0][0].who());
    }

    @Test
    void testProfit(){
        assertEquals(1, ISPBusiness.getProfit(t));
    }

}
