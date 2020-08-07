package com.hbelmiro.gcanalizer.filters;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class PauseFullDurationLineFilterTest {

    @Inject
    PauseFullDurationLineFilter filter;

    @Test
    void filter() {
        List<String> inputLines = List.of(
                "[2020-08-05T14:32:12.285-0300] GC(1) Pause Young (Metadata GC Threshold) 10M->6M(153M) 6.459ms",
                "[2020-08-05T14:32:12.285-0300] GC(1) User=0.01s Sys=0.00s Real=0.01s",
                "[2020-08-05T14:32:12.285-0300] GC(2) Pause Full (Metadata GC Threshold)",
                "[2020-08-05T14:32:12.285-0300] GC(2) Marking Phase",
                "[2020-08-05T14:32:12.295-0300] GC(2) Marking Phase 9.976ms",
                "[2020-08-05T14:32:12.313-0300] GC(2) Pause Full (Metadata GC Threshold) 6M->6M(153M) 28.641ms",
                "[2020-08-05T14:32:12.313-0300] GC(2) User=0.06s Sys=0.01s Real=0.02s",
                "[2020-08-05T14:32:13.479-0300] GC(4) User=0.03s Sys=0.01s Real=0.01s",
                "[2020-08-05T14:32:13.479-0300] GC(5) Pause Full (Metadata GC Threshold)",
                "[2020-08-05T14:32:13.479-0300] GC(5) Marking Phase",
                "[2020-08-05T14:32:13.492-0300] GC(5) Marking Phase 13.285ms",
                "[2020-08-05T14:32:15.152-0300] GC(7) Metaspace: 55460K->55460K(1101824K)",
                "[2020-08-05T14:32:15.152-0300] GC(7) Pause Full (Metadata GC Threshold) 33M->32M(217M) 123.234ms",
                "[2020-08-05T14:32:15.152-0300] GC(7) User=0.39s Sys=0.01s Real=0.12s",
                "[2020-08-05T14:32:18.145-0300] GC(8) Pause Young (Allocation Failure)"
        );

        List<String> expectedLines = List.of(
                "[2020-08-05T14:32:12.313-0300] GC(2) Pause Full (Metadata GC Threshold) 6M->6M(153M) 28.641ms",
                "[2020-08-05T14:32:15.152-0300] GC(7) Pause Full (Metadata GC Threshold) 33M->32M(217M) 123.234ms"
        );

        assertThat(this.filter.filter(inputLines))
                .containsExactlyElementsOf(expectedLines);
    }

}