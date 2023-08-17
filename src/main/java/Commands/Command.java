package Commands;

public interface Command {
    long execute(long x, long y);
    String getName();
}
