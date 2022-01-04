package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.DateTimeParser;
import utils.SqlRuDateTimeParser;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        List<String> urls = new ArrayList<>();
        int num = 1;
        while (num < 5) {
            String tempString;
            tempString = "https://www.sql.ru/forum/job-offers/" + num;
            urls.add(tempString);
            num++;
        }
        DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
        for (String str : urls) {
            Document doc = Jsoup.connect(str).get();
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
