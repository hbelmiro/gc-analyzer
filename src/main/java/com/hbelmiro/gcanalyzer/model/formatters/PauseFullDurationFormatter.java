package com.hbelmiro.gcanalyzer.model.formatters;

import com.hbelmiro.gcanalyzer.model.PauseFullDuration;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PauseFullDurationFormatter {

    public String format(PauseFullDuration pauseFullDuration) {
        return "PauseFullDuration{" +
                "dateTime=" + pauseFullDuration.getDateTime() +
                ", duration=" + pauseFullDuration.getDuration().toMillis() + "ms" +
                '}';
    }

}
