package Commands;

import Exceptions.Error0;
import Exceptions.Error3;

public class ModCommand implements Command{
    private final String name;

    public ModCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long execute(long x, long y) {
        if (y < 0) {
            throw new Error3("ERROR_3");
        } else if (y == 0) {
            throw new Error0("ERROR_0");
        } else {
            return x % y;
        }
    }
}
