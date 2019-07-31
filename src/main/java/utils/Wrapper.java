package utils;

public abstract class Wrapper implements AutoCloseable {
    @Override
    public void close() throws Exception {}

    public abstract void initialize() throws NullPointerException;
}
