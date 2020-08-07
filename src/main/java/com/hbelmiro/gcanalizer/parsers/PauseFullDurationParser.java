package com.hbelmiro.gcanalizer.parsers;

import com.hbelmiro.gcanalizer.model.PauseFullDuration;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class PauseFullDurationParser {

    public static final String DATE_TIME_FORMAT = "y-M-d'T'H:mm:ss.SSSZ";

    public PauseFullDuration parse(String text) {
        ZonedDateTime dateTime = ZonedDateTime.parse(
                text.substring(1, 29),
                DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
        );

        String durationStringInMillis = text.substring(text.indexOf(")", text.indexOf("->")) + 2, text.length() - 2);

        BigDecimal nanos = new BigDecimal(durationStringInMillis).multiply(new BigDecimal(1000000));

        Duration duration = Duration.ofNanos(nanos.longValue());

        return new PauseFullDuration(dateTime, duration);
    }

}
