package ru.job4j.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.time.LocalDateTime;

public class PostParser {
    public void parse() throws Exception {
        String stringUrl = "https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t";
        Document doc = Jsoup.connect(stringUrl).get();
        Elements row = doc.select("#content-wrapper-forum");

        for (Element element : row) {
            Element parent = element.parent();
            System.out.println(parent.child(1).child(3).child(0).child(1).child(1).text());
            System.out.println(parseDate(parent.child(1).child(3).child(0).child(2).child(0).text()));
        }
    }

    private LocalDateTime parseDate(String parse) throws IOException {
        String parseSub = parse.substring(0, 16);
        DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
        return dateTimeParser.parse(parseSub);
    }

    public static void main(String[] args) throws Exception {
        PostParser postParser = new PostParser();
        postParser.parse();
    }
}
