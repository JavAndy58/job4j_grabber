package ru.job4j.utils;

import java.time.LocalDateTime;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {
    private static final Map<String, Integer> MONTHS = Map.ofEntries(
            Map.entry("янв", 1),
            Map.entry("фев", 2),
            Map.entry("мар", 3),
            Map.entry("апр", 4),
            Map.entry("май", 5),
            Map.entry("июн", 6),
            Map.entry("июл", 7),
            Map.entry("авг", 8),
            Map.entry("сен", 9),
            Map.entry("окт", 10),
            Map.entry("ноя", 11),
            Map.entry("дек", 12)
    );

    @Override
    public LocalDateTime parse(String parse) {
        LocalDateTime localDateTime;
        String[] lines = parse.split(", ");
        if (lines[0].equals("сегодня")) {
            localDateTime = LocalDateTime.now();
        } else if (lines[0].equals("вчера")) {
            localDateTime = LocalDateTime.now().minusDays(1);
        } else {
            String[] linesData = lines[0].split(" ");
            String[] linesTime = lines[1].split(":");
            String year = String.format("20%s", linesData[2]);
            localDateTime = LocalDateTime.of(
                    Integer.parseInt(year),
                    MONTHS.get(linesData[1]),
                    Integer.parseInt(linesData[0]),
                    Integer.parseInt(linesTime[0]),
                    Integer.parseInt(linesTime[1])
            );
        }
        return localDateTime;
    }
}