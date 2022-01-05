package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.utils.DateTimeParser;
import ru.job4j.utils.SqlRuDateTimeParser;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
        for (int counter = 1; counter < 6; counter++) {
            String stringUrl = "https://www.sql.ru/forum/job-offers/" + counter;
            Document doc = Jsoup.connect(stringUrl).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element parent = td.parent();
                System.out.println(parent.child(1).child(0).attr("href"));
                System.out.println(parent.child(1).text());
                System.out.println(dateTimeParser.parse(parent.child(5).text()));
            }
        }
    }
}
