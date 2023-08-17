package Commands;

import Exceptions.Error0;

public class DivisionCommand implements Command{
    private final String name;

    public DivisionCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long execute(long x, long y) {
        if (y == 0) {
            throw new Error0("ERROR_0");
        } else {
            return x / y;
        }
    }
}
