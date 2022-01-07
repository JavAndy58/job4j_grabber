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
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public List<Post> list(String link) throws Exception {
        List<Post> posts = new ArrayList<>();
        posts.add(detail(link));
        return posts;
    }

    @Override
    public Post detail(String link) throws Exception {
        PostParser postParser = new PostParser();
        Post postTemp = new Post();
        for (int counter = 1; counter < 6; counter++) {
           String stringUrl = link + counter;
           Document doc = Jsoup.connect(stringUrl).get();
           Elements row = doc.select(".postslisttopic");
           for (Element td : row) {
               Element parent = td.parent();
               postTemp = postParser.parse(parent.child(1).child(0).attr("href"));
           }
        }
        return postTemp;
    }

    public static void main(String[] args) throws Exception {
        List<Post> posts;
        String stringUrl = "https://www.sql.ru/forum/job-offers/";
        DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
        SqlRuParse sqlRuParse = new SqlRuParse(dateTimeParser);
        posts = sqlRuParse.list(stringUrl);
    }
}
