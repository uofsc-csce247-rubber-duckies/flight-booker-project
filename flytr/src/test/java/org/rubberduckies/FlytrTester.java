package org.rubberduckies;

// import org.rubberduckies.BookingController;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class FlytrTester {

    // Runs before first test is run
    @BeforeClass
    public static void oneTimeSetup() {

    }

    // Runs before each test
    @Before
    public static void setup() {

    }

    // Runs after each test
    @After
    public static void tearDown() {

    }

    // Runs after last test
    @AfterClass
    public static void oneTimeTearDown() {

    }

    @Test
    public void flytrNotNull(){
        Flytr flytr = Flytr.getInstance();
        assertNotNull(flytr);
    }

    @Test
    public void 
    {

    }


}

