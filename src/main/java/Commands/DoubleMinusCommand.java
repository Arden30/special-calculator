package Commands;

public class DoubleMinusCommand implements Command{
    private final String name;

    public DoubleMinusCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long execute(long x, long y) {
        return x - y - y;
    }
}
