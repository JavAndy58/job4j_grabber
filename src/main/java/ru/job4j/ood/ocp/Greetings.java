package ru.job4j.ood.ocp;

import java.util.Objects;

public class Greetings {

    private Year year;
    private String formality;


    public Greetings(String formality, Year year) {
        this.formality = formality;
        this.year = year;
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
        return temp + " " + year.yearning();
    }

    public static void main(String[] args) {
        Greetings greetings = new Greetings("formal", new Year());
        System.out.printf("%s, Petr", greetings.greet());
    }
}
