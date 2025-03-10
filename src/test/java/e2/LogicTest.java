package e2;
import org.junit.jupiter.api.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  Logics logicsSimple;
  Logics logicsRandom;
  RandomPosition randomPosition;

  @BeforeEach
  void setup() {
    logicsSimple = new LogicsImpl(8, new Position(5,5), new Position(6,7));
    logicsRandom = new LogicsImpl(8);
    randomPosition = new RandomPositionImpl(8);
  }

  @Test
  public void testPawnCreation() {
    assertTrue(logicsSimple.hasPawn(5,5));
  }

  @Test
  public void testKnightCreation(){
    assertTrue(logicsSimple.hasKnight(6,7));
  }

  @Test
  public void testPawnCapture(){
    assertTrue(logicsSimple.hit(5,5));
  }

  @Test
  public void testKnightMove(){
    assertFalse(logicsSimple.hit(7,5));
  }


  @Test
  public void testIndexOutOfBoundsException(){
    assertThrows(IndexOutOfBoundsException.class, ()-> logicsSimple.hit(8,9));
  }

  @Test
  public void testRandomPosition(){
    assertTrue(randomPosition.generate().getX() < 8);
    assertTrue(randomPosition.generate().getY() < 8);
  }

  @Test
  public void testDifferentPosition(){
    Position differentPair = new Position(0,0);
    Position randPos = randomPosition.generateDifferentFrom(differentPair);

    Boolean xNotEqual = !Objects.equals(randPos.getX(), differentPair.getX());
    Boolean yNotEqual = !Objects.equals(randPos.getY(), differentPair.getY());
    assertTrue(xNotEqual || yNotEqual);
  }




}
