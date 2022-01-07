package ru.job4j.grabber;

import ru.job4j.Post;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("driver-class-name"));
            cnn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }
}