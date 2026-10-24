package sk.train;

import java.util.logging.Logger;

import org.junit.jupiter.api.*;



public class FixtureDemoTest {



  static final Logger LOG = Logger.getLogger( FixtureDemoTest.class.getName() );



  @BeforeAll

  public static void beforeClass() { LOG.info( "@BeforeAll" ); }



  @AfterAll

  public static void afterClass() { LOG.info( "@AfterAll" ); }



  @BeforeEach

  public void setUp() { LOG.info( "@Before" ); }



  @AfterEach

  public void tearDown() { LOG.info( "@After" ); }



  @Test

  public void test1() { LOG.info( "test 1" ); }



  @Test

  public void test2() { LOG.info( "test 2" ); }

}