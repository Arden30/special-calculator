package Commands;

import Exceptions.Error3;

public class PowCommand implements Command{
    private final String name;

    public PowCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long execute(long x, long y) {
        if (y < 0) {
            throw new Error3("ERROR_2");
        } else if (y == 0) {
            return 1;
        } else {
            return (long) Math.pow((double) x, (double) y);
        }
    }
}
