package com.devopsclub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElkCucumberReportSchema {
    String scnName;
    String scnSteps;
    String scnStatus;
    String scnTags;
    String executionEnv;
    String scnEndTimeStamp;
    String scnStartTimeStamp;
}
