package ru.job4j.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PostParser {
    public void parse() throws Exception {
        String stringUrl = "https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t";
        Document doc = Jsoup.connect(stringUrl).get();
        Elements row = doc.select("forummenu");
        for (Element td : row) {
            Element parent = td.parent();
            System.out.println(parent.child(1).child(0).child(1).text());
        }
    }

    public static void main(String[] args) throws Exception {
        PostParser postParser = new PostParser();
        postParser.parse();
    }
}
