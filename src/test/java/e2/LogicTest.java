package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  Logics logics;

  @BeforeEach
  void setup() {
    logics = new LogicsImpl(8, new Pair<Integer, Integer>(5,5), new Pair<Integer, Integer>(6,7));
  }

  @Test
  public void testPawnCreation() {
    assertTrue(logics.hasPawn(5,5));
  }

  @Test
  public void testKnightCreation(){
    assertTrue(logics.hasKnight(6,7));
  }

  @Test
  public void testPawnCapture(){
    assertTrue(logics.hit(5,5));
  }

  @Test
  public void testKnightMove(){
    assertFalse(logics.hit(7,5));
  }


  @Test
  public void testIndexOutOfBoundsException(){
    assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(8,9));
  }



}
