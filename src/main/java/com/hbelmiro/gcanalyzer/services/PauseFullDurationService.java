package com.hbelmiro.gcanalyzer.services;

import com.hbelmiro.gcanalyzer.analyzers.MaxPauseFullDurationAnalyzer;
import com.hbelmiro.gcanalyzer.exceptions.AnalyzerException;
import com.hbelmiro.gcanalyzer.model.PauseFullDuration;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PauseFullDurationService {

    private final MaxPauseFullDurationAnalyzer analyzer;

    public PauseFullDurationService(MaxPauseFullDurationAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public List<PauseFullDuration> getDurationsFromFile(Path path, int numberOfDurations) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new AnalyzerException("Unable to read the file " + path.getFileName(), e);
        }

        return analyzer.analyze(lines)
                       .stream()
                       .limit(numberOfDurations)
                       .collect(Collectors.toList());
    }

}
