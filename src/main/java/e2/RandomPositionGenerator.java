package e2;

import java.util.Random;

public class RandomPositionGenerator implements RandomPosition{
    Random random = new Random();

    @Override
    public Pair<Integer, Integer> generate(int size) {
        return new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
    }

    @Override
    public Pair<Integer, Integer> generateDifferentFrom(int size, Pair<Integer, Integer> pos) {
        Pair<Integer, Integer> rand = generate(size);
        return pos != null && pos.equals(rand) ? generateDifferentFrom(size, pos) : rand;
    }

}
