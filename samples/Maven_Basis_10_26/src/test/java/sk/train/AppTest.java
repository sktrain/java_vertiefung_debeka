package sk.train;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
     /**
     * Rigourous Test :-)
     * @throws Exception 
     */
     @Test
     public void testApp() throws Exception
    {
        App.main();
        assertTrue( true , "Fatal Error");
    }
}
