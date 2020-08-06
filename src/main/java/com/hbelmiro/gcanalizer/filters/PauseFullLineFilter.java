package com.hbelmiro.gcanalizer.filters;

import java.util.List;
import java.util.stream.Collectors;

public class PauseFullLineFilter {

    public List<String> filter(List<String> lines) {
        return lines.stream().filter(line -> line.contains("Pause Full")).collect(Collectors.toUnmodifiableList());
    }

}
