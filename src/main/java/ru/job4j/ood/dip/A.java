package ru.job4j.ood.dip;

public class A {

    void someMethod() {
        B b = new B();
        b.someMethodOfB();
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
