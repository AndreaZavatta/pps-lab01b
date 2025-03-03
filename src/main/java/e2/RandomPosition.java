package e2;

public interface RandomPosition {
    Pair<Integer, Integer> generate(int size);
    Pair<Integer, Integer> generateDifferentFrom(int size, Pair<Integer, Integer> pos);
}
