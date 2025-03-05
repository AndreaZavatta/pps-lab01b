package e2;

import java.util.Random;

public class RandomPositionImpl implements RandomPosition{
    Random random = new Random();
    int size;
    public RandomPositionImpl(int size){
        this.size = size;
    }
    @Override
    public Position generate() {
        return new Position(this.random.nextInt(this.size), this.random.nextInt(this.size));
    }

    @Override
    public Position generateDifferentFrom(Position pos) {
        Position rand = generate();
        return pos != null && pos.equals(rand) ? generateDifferentFrom(pos) : rand;

    }

}
