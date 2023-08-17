package Commands;

public class DoublePlusCommand implements Command{
    private final String name;

    public DoublePlusCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long execute(long x, long y) {
        return x + y + y;
    }
}
