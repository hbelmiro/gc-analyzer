package com.hbelmiro.gcanalizer.model;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Objects;

public class PauseFullDuration {

    private final ZonedDateTime dateTime;

    private final Duration duration;

    private PauseFullDuration(ZonedDateTime dateTime, Duration duration) {
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public static PauseFullDuration createPauseFullDuration(ZonedDateTime dateTime, Duration duration) {
        return new PauseFullDuration(dateTime, duration);
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PauseFullDuration that = (PauseFullDuration) o;
        return dateTime.equals(that.dateTime) &&
                duration.equals(that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, duration);
    }
}
