package ru.job4j.ood.dip;

import java.security.MessageDigest;

public class A {
    void someMethod() {
        B b = new B();
        b.someMethodOfB();
    }

    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }
    }
}
class B {
    void someMethodOfB() {
        System.out.println("Hello world");
    }
}

class BackEndDeveloper {
    public void writeJava() {
    }
}

class FrontEndDeveloper {
    public void writeJavascript() {
    }
}

class Project {
    private BackEndDeveloper backEndDeveloper = new BackEndDeveloper();
    private FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();

    public void implement() {
        backEndDeveloper.writeJava();
        frontEndDeveloper.writeJavascript();
    }
}
