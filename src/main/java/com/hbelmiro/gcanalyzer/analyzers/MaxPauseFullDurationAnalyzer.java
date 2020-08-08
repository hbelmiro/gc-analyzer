package com.hbelmiro.gcanalyzer.analyzers;

import com.hbelmiro.gcanalyzer.filters.PauseFullDurationLineFilter;
import com.hbelmiro.gcanalyzer.model.PauseFullDuration;
import com.hbelmiro.gcanalyzer.parsers.PauseFullDurationParser;

import javax.enterprise.context.ApplicationScoped;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MaxPauseFullDurationAnalyzer {

    private final PauseFullDurationLineFilter pauseFullDurationLineFilter;

    private final PauseFullDurationParser pauseFullDurationParser;

    public MaxPauseFullDurationAnalyzer(PauseFullDurationLineFilter pauseFullDurationLineFilter,
                                        PauseFullDurationParser pauseFullDurationParser) {
        this.pauseFullDurationLineFilter = pauseFullDurationLineFilter;
        this.pauseFullDurationParser = pauseFullDurationParser;
    }

    public List<PauseFullDuration> analize(List<String> lines) {
        List<String> filteredLines = this.pauseFullDurationLineFilter.filter(lines);

        return filteredLines.stream()
                            .map(this.pauseFullDurationParser::parse)
                            .sorted(Comparator.comparing(PauseFullDuration::getDuration).reversed())
                            .collect(Collectors.toUnmodifiableList());
    }

}
