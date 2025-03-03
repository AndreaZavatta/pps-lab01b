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
    logicsSimple = new LogicsImpl(8, new Pair<Integer, Integer>(5,5), new Pair<Integer, Integer>(6,7));
    logicsRandom = new LogicsImpl(8);
    randomPosition = new RandomPositionGenerator();
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
    assertTrue(randomPosition.generate(8).getX() < 8);
    assertTrue(randomPosition.generate(8).getY() < 8);
  }

  @Test
  public void testDifferentPosition(){
    Pair<Integer, Integer> differentPair = new Pair<Integer, Integer>(0,0);
    Pair<Integer, Integer> randPos = randomPosition.generateDifferentFrom(2, differentPair);

    Boolean xNotEqual = !Objects.equals(randPos.getX(), differentPair.getX());
    Boolean yNotEqual = !Objects.equals(randPos.getY(), differentPair.getY());
    assertTrue(xNotEqual || yNotEqual);
  }




}
