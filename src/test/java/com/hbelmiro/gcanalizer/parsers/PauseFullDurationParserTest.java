package com.hbelmiro.gcanalizer.parsers;

import com.hbelmiro.gcanalizer.model.PauseFullDuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class PauseFullDurationParserTest {

    @Test
    void parse() {
        PauseFullDurationParser parser = new PauseFullDurationParser();

        String text = "[2020-08-05T14:32:13.508-0300] GC(5) Pause Full (Metadata GC Threshold) 17M->12M(217M) 1229.626ms";

        PauseFullDuration expectedDuration = new PauseFullDuration(
                ZonedDateTime.parse("2020-08-05T14:32:13.508-0300",
                        DateTimeFormatter.ofPattern(PauseFullDurationParser.DATE_TIME_FORMAT)),
                Duration.ofNanos(1229626000)
        );

        assertThat(parser.parse(text)).isEqualTo(expectedDuration);
    }

}