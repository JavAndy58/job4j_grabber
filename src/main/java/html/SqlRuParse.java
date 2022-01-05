package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.DateTimeParser;
import utils.SqlRuDateTimeParser;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
        int num = 1;
        while (num < 5) {
            String stringUrl = "https://www.sql.ru/forum/job-offers/" + num;
            Document doc = Jsoup.connect(stringUrl).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element parent = td.parent();
                System.out.println(parent.child(1).child(0).attr("href"));
                System.out.println(parent.child(1).text());
                System.out.println(dateTimeParser.parse(parent.child(5).text()));
            }
            num++;
        }
    }
}
