package ru.job4j.cache;

import java.io.File;
import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кешируемую директорию");
        String nameDir = in.nextLine();
        System.out.println("Введите имя файла");
        String nameFile = in.nextLine();
        DirFileCache dirFileCache = new DirFileCache(nameDir);
        System.out.println(dirFileCache.load(nameFile));
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
