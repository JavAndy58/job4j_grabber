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
        for (int counter = 1; counter < 6; counter++) {
            Post postTemp;
            String stringUrl = link + counter;
            String strLink;
            Document doc = Jsoup.connect(stringUrl).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element parent = td.parent();
                strLink = parent.child(1).child(0).attr("href");
                postTemp = detail(strLink);
                if ((postTemp.getTitle().contains("java") || postTemp.getTitle().contains("Java"))
                    && (!postTemp.getTitle().contains("Javascript") || !postTemp.getTitle().contains("javascript"))) {
                    posts.add(postTemp);
                }
            }
        }
        return posts;
    }

    @Override
    public Post detail(String link) throws Exception {
        Post postTemp;
        PostParser postParser = new PostParser(dateTimeParser);
        postTemp = postParser.parse(link);
        return postTemp;
    }
}
