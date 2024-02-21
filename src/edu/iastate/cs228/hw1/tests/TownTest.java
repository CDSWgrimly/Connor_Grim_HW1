package edu.iastate.cs228.hw1.tests;

import edu.iastate.cs228.hw1.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Connor Grim
 */
public class TownTest {
    Town t;
    @BeforeEach
    void init(){
        t = new Town(2, 3);
        t.randomInit(1);
    }

    @Test
    void testLength(){
        assertEquals(2, t.getLength());
    }

    @Test
    void testWidth(){
        assertEquals(3, t.getWidth());
    }
}
