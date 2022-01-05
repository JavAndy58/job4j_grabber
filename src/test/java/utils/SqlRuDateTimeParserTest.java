import org.junit.Assert;
import org.junit.Test;
import utils.SqlRuDateTimeParser;

import java.time.LocalDateTime;

public class SqlRuDateTimeParserTest {

    @Test
    public void whenParse() {
        SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
        LocalDateTime actual = LocalDateTime.of(2021, 9, 11, 20, 10);
        LocalDateTime expected = sqlRuDateTimeParser.parse("11 сен 21, 20:10");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenParseToday() {
        SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
        LocalDateTime actual = LocalDateTime.now();
        LocalDateTime expected = sqlRuDateTimeParser.parse("сегодня, 15:54");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenParseYesterday() {
        SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
        LocalDateTime actual = LocalDateTime.now().minusDays(1);
        LocalDateTime expected = sqlRuDateTimeParser.parse("вчера, 14:37");
        Assert.assertEquals(expected, actual);
    }
}
