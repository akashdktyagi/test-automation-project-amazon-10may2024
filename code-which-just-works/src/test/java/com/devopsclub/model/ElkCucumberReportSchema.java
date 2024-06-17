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
    String runId;
    String env;
    String appName;
    String release;

    String name;
    String steps;
    String status;
    String tags;
    String startTimeStamp;
    String endTimeStamp;

    //Jira details
    String storyId;
    String xrayId;



}
