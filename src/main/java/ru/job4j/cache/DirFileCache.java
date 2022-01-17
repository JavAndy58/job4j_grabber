package ru.job4j.cache;

import java.io.File;
import java.util.Scanner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String textFile = get(key);
        String strFile = cachingDir + "\\" + key;
        if (textFile == null) {
            put(key, loadScanner(strFile));
            textFile = get(key);
        }
        return textFile;
    }

    private String loadScanner(String strFile) {
        String textFile = "";
        try {
            File dir = new File(strFile);
            Scanner input = new Scanner(dir);
            while (input.hasNextLine()) {
                textFile = textFile.concat(input.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return textFile;
    }
}
