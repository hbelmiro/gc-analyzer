package com.hbelmiro.gcanalyzer.parsers;

import com.hbelmiro.gcanalyzer.model.PauseFullDuration;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class PauseFullDurationParserTest {

    @Inject
    PauseFullDurationParser parser;

    @Test
    void parse() {
        String text = "[2020-08-05T14:32:13.508-0300] GC(5) Pause Full (Metadata GC Threshold) 17M->12M(217M) 1229.626ms";

        PauseFullDuration expectedDuration = PauseFullDuration.createPauseFullDuration(
                ZonedDateTime.parse("2020-08-05T14:32:13.508-0300",
                        DateTimeFormatter.ofPattern(PauseFullDurationParser.DATE_TIME_FORMAT)),
                Duration.ofNanos(1229626000)
        );

        assertThat(this.parser.parse(text)).isEqualTo(expectedDuration);
    }

}