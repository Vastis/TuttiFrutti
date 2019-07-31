package utils;

public interface Wrapper extends AutoCloseable {
    @Override
    default void close() throws Exception {}

    void initialize() throws NullPointerException;
}
