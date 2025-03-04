package e2;

import java.util.Random;

public class RandomPositionGenerator implements RandomPosition{
    Random random = new Random();

    @Override
    public Position generate(int size) {
        return new Position(this.random.nextInt(size), this.random.nextInt(size));
    }

    @Override
    public Position generateDifferentFrom(int size, Position pos) {
        Position rand = generate(size);
        return pos != null && pos.equals(rand) ? generateDifferentFrom(size, pos) : rand;

    }

}
