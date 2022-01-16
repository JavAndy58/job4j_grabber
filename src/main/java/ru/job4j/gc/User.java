package ru.job4j.gc;

public class User {

    private int id;
    private long password;

    public User(int id, long password) {
        this.id = id;
        this.password = password;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %d%n", id, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 33000; i++) {
            new User(i, i * 1000);
        }
    }
}
