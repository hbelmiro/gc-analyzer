package com.hbelmiro.gcanalyzer.filters;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PauseFullDurationLineFilter {

    public List<String> filter(List<String> lines) {
        return lines.stream()
                    .filter(line -> line.contains("Pause Full"))
                    .filter(line -> line.contains("->"))
                    .collect(Collectors.toUnmodifiableList());
    }

}
