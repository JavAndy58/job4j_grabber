package ru.job4j.cache;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String strTemp = get(key);
        if (strTemp == null) {
            put(key, key);
            strTemp = get(key);
        }
        return strTemp;
    }
}
