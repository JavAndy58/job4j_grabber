package ru.job4j.cache;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    private boolean validation(String nameFile) {
        boolean temp = false;
        File dir = new File(cachingDir);
        if (dir.isDirectory()) {
            for (File fileNames : Objects.requireNonNull(dir.listFiles())) {
                if (fileNames.getName().equals(nameFile)) {
                    temp = true;
                }
            }
        }
        return temp;
    }

    @Override
    protected String load(String key) {
        String textFile = "";
        String nameDir = get(key);

        if (validation(key)) {
            if (nameDir == null) {
                put(key, key);
                nameDir = get(key);
            }
        }

        try {
            File dir = new File(nameDir);
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
