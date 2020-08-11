package com.hbelmiro.gcanalyzer;

import com.hbelmiro.gcanalyzer.model.formatters.PauseFullDurationFormatter;
import com.hbelmiro.gcanalyzer.services.PauseFullDurationService;
import picocli.CommandLine;

import javax.inject.Inject;
import java.nio.file.Paths;

@CommandLine.Command
public class Command implements Runnable {

    @CommandLine.Option(names = {"-f", "--file"}, description = "Log file name", required = true)
    private String fileName;

    @CommandLine.Option(names = {"-n", "--number"}, description = "The number of durations to be printed", required = true)
    private String numberOfDurations;

    @Inject
    PauseFullDurationService pauseFullDurationService;

    @Inject
    PauseFullDurationFormatter pauseFullDurationFormatter;

    @SuppressWarnings("unused")
    Command(PauseFullDurationService pauseFullDurationService) {
        this.pauseFullDurationService = pauseFullDurationService;
    }

    @Override
    public void run() {
        this.pauseFullDurationService.getDurationsFromFile(Paths.get(this.fileName), Integer.parseInt(this.numberOfDurations))
                                     .stream()
                                     .map(this.pauseFullDurationFormatter::format)
                                     .forEach(System.out::println);
    }

}
