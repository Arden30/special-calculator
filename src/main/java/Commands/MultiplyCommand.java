package Commands;

public class MultiplyCommand implements Command{
    private final String name;

    public MultiplyCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long execute(long x, long y) {
        return x * y;
    }
}
