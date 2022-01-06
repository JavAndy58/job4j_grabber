package ru.job4j.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.Post;
import java.io.IOException;
import java.time.LocalDateTime;

public class PostParser {
    public Post parse(String link) throws Exception {
        Post post = new Post();
        Document doc = Jsoup.connect(link).get();
        post.setTitle(doc.select(".messageHeader").get(0).ownText());
        post.setLink(link);
        Elements row = doc.select("#content-wrapper-forum");
        for (Element element : row) {
            Element parent = element.parent();
            post.setDescription(parent.child(1).child(3).child(0).child(1).child(1).text());
            post.setCreated(parseDate(parent.child(1).child(3).child(0).child(2).child(0).text()));
        }
        return post;
    }

    private LocalDateTime parseDate(String parse) throws IOException {
        String parseSub = parse.substring(0, 16);
        DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
        return dateTimeParser.parse(parseSub);
    }
}
