package Commands;

public class MinusCommand implements Command{
    private final String name;

    public MinusCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long execute(long x, long y) {
        return x - y;
    }
}
