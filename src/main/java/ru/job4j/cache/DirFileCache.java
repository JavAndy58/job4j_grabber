package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String textFile = "";
        try {
            textFile = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFile;
    }


    //        String textFile = get(key);
//        String strFile = cachingDir + "\\" + key;
//        if (textFile == null) {
//            put(key, loadScanner(strFile));
//            textFile = get(key);
//        }
}
