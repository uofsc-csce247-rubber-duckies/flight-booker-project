package org.rubberduckies;

// import org.rubberduckies.BookingController;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class BookingControllerTest {

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
    public void initControllerNotNull() {
        BookingController controller = BookingController.getController();
        assertNotNull(controller);
    }

}
