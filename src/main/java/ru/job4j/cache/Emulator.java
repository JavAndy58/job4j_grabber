package ru.job4j.cache;


import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кешируемую директорию");
        String nameDir = in.nextLine();
        System.out.println("Введите имя файла");
        String nameFile = in.nextLine();
        DirFileCache dirFileCache = new DirFileCache(nameDir);
        System.out.println(dirFileCache.get(nameFile));
    }
}
