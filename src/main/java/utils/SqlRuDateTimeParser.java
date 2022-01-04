package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS = Map.ofEntries();

    @Override
    public LocalDateTime parse(String parse) {
        LocalDateTime localDateTime = LocalDateTime.parse(parse);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy. HH:mm");
        localDateTime.format(formatter);
        return localDateTime;
    }
}
