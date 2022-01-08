package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.Post;
import ru.job4j.grabber.Parse;
import ru.job4j.utils.DateTimeParser;
import ru.job4j.utils.PostParser;
import ru.job4j.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public List<Post> list(String link) {
        List<Post> posts = new ArrayList<>();
        for (int counter = 1; counter < 6; counter++) {
            Post postTemp;
            String stringUrl = String.format("link/%d", counter);
            String stringLink;
            Document doc = null;
            try {
                doc = Jsoup.connect(stringUrl).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements row = Objects.requireNonNull(doc).select(".postslisttopic");
            for (Element td : row) {
                Element parent = td.parent();
                stringLink = parent.child(1).child(0).attr("href");
                postTemp = detail(stringLink);
                if (postTemp.getTitle().toLowerCase().contains("java")
                        && !postTemp.getTitle().toLowerCase().contains("javascript")) {
                    posts.add(postTemp);
                }
            }
        }
        return posts;
    }

    @Override
    public Post detail(String link) {
        Post postTemp = new Post();
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String parseSub = (Objects.requireNonNull(doc).select(".msgFooter").get(0).text()).substring(0, 16);
        postTemp.setTitle(doc.select(".messageHeader").get(0).ownText());
        postTemp.setLink(link);
        postTemp.setDescription(doc.select(".msgBody").get(1).text());
        try {
            postTemp.setCreated(dateTimeParser.parse(parseSub));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postTemp;
    }
}
