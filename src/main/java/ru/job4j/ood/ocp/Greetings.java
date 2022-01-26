package ru.job4j.ood.ocp;

import java.util.Objects;

public class Greetings {

    private String formality;

    public Greetings(String formality) {
        this.formality = formality;
    }

    public String greet() {
        String temp;
        if (Objects.equals(formality, "formal")) {
            temp = "Good evening, sir.";
        } else if (Objects.equals(formality, "casual")) {
            temp = "Sup bro?";
        } else if (Objects.equals(formality, "intimate")) {
            temp = "Hello Darling!";
        } else {
            temp = "Hello.";
        }
        return temp;
    }

    public static void main(String[] args) {
        Greetings greetings = new Greetings("formal");
        System.out.printf("%s, Petr", greetings.greet());
    }
}
