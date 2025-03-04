package e2;

public interface RandomPosition {
    Position generate(int size);
    Position generateDifferentFrom(int size, Position pos);
}
