package ru.job4j.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ru.job4j.Post;
import java.io.IOException;
import java.time.LocalDateTime;

public class PostParser {
    private DateTimeParser dateTimeParser;

    public PostParser(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public Post parse(String link) throws Exception {
        Post post = new Post();
        Document doc = Jsoup.connect(link).get();
        post.setTitle(doc.select(".messageHeader").get(0).ownText());
        post.setLink(link);
        post.setDescription(doc.select(".msgBody").get(1).text());
        post.setCreated(parseDate(doc.select(".msgFooter").get(0).text()));
        return post;
    }

    private LocalDateTime parseDate(String parse) throws IOException {
        String parseSub = parse.substring(0, 16);
        return dateTimeParser.parse(parseSub);
    }
}
