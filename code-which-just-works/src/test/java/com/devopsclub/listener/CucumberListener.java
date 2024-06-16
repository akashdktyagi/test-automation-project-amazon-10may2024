package com.devopsclub.listener;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.devopsclub.contexts.ScnContext;
import com.devopsclub.model.ElkCucumberReportSchema;
import com.google.common.base.Throwables;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Log4j2
public class CucumberListener implements ConcurrentEventListener {
    RestClient restClient;
    ElasticsearchTransport transport;
    ElasticsearchClient esClient;

    ScnContext scnContext = new ScnContext();
    ElkCucumberReportSchema elkCucumberReportSchema = new ElkCucumberReportSchema();


    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::testRunStarted);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::testCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::testCaseFinish);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::testRunFinished);
    }

    private void testRunStarted(TestRunStarted event){

        log.debug("Test Run Started");
        String elasticSearchHost = scnContext.getProperties().getProperty("elasticsearch.host");
        Integer elasticSearchPort = Integer.parseInt(scnContext.getProperties().getProperty("elasticsearch.port"));

        restClient = RestClient.builder(new HttpHost(elasticSearchHost, elasticSearchPort)).build();
        transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        esClient = new ElasticsearchClient(transport);


        log.debug("Camel Context Started");

    }

    private void testCaseStarted(TestCaseStarted event){
        elkCucumberReportSchema.setScnName(event.getTestCase().getName());
        elkCucumberReportSchema.setScnTags(event.getTestCase().getTags().toString());
        elkCucumberReportSchema.setScnStartTimeStamp(event.getInstant().toString());

        log.debug("Test Case Started: " + event.getTestCase().getName());
    }

    private void testCaseFinish(TestCaseFinished event)  {
        elkCucumberReportSchema.setScnSteps(getTestSteps(event));
        elkCucumberReportSchema.setScnStatus(event.getResult().getStatus().toString());
        elkCucumberReportSchema.setScnEndTimeStamp(event.getInstant().toString());

        log.debug("Test Case Finished: " + event.getTestCase().getName());
        log.debug(getTestCaseStepsWithStatusAndErrorLogs(event).toString());
        writeToFiles("results/"+event.getTestCase().getName()+".txt", getTestCaseStepsWithStatusAndErrorLogs(event).toString());

        //Push to ElasticSearch
        try {
            IndexResponse response = esClient.index(i -> i
                    .index("cucumber-test-reports")
    //                .id(product.getSku())
                    .document(elkCucumberReportSchema)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void testRunFinished(TestRunFinished event){

        log.debug("Test Run Finished");

    }

    private String getTestSteps(TestCaseFinished event){
        List<TestStep> testStepList = event.getTestCase().getTestSteps();
        StringBuffer testStepListString = new StringBuffer();
        testStepList.forEach(x->{
            if (x instanceof PickleStepTestStep){
                testStepListString.append(
                        ((PickleStepTestStep) x).getStep().getKeyword() + " " +
                                ((PickleStepTestStep) x).getStep().getText() + " \n"
                );
                if (((PickleStepTestStep) x).getStep().getArgument() != null) {
                    if (((PickleStepTestStep) x).getStep().getArgument() instanceof DocStringArgument) {

                        testStepListString.append(
                                ("\"\"\"\n") +
                                        (((DocStringArgument) ((PickleStepTestStep) x).getStep().getArgument()).getContent()) +
                                        ("\n\"\"\"\n")
                        );
                    }
                    if (((PickleStepTestStep) x).getStep().getArgument() instanceof DataTableArgument) {

                        List<List<String>> ParamDataTable = (((DataTableArgument) ((PickleStepTestStep) x).getStep().getArgument()).cells());
                        ParamDataTable.forEach(ParamRow -> {
                                    ParamRow.forEach(ParamCol -> {
                                        testStepListString.append(
                                                "|" + ParamCol
                                        );
                                    });
                                    testStepListString.append("|\n");
                                }
                        );
                    }
                }

            }
        });
        return testStepListString.toString();
    }

    private StringBuffer getTestCaseStepsWithStatusAndErrorLogs(TestCaseFinished event){
        StringBuffer testStepListString = new StringBuffer();
        testStepListString.append("Scenario Steps: ");
        testStepListString.append("\n Scenario: " + event.getTestCase().getName() + " \n \n");
        testStepListString.append(getTestSteps(event));

//        testStepListString.append("\n \n ----------------------------------------------------------");
//        testStepListString.append("\n --------------------  ERROR LOGS  -----------------------");
//        testStepListString.append("\n  ----------------------------------------------------------");
        if (event.getResult().getError() !=null){
            testStepListString.append("\n Execution Error Log: \n \n " + Throwables.getStackTraceAsString(event.getResult().getError()));
        }
        return testStepListString;
    }

    private void writeToFiles(String fileName, String content){
        // Create a FileWriter object
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            // Write the content to the file
            fileWriter.write(content);
            log.debug("File written successfully.");
        } catch (IOException e) {
            // Handle any I/O errors
            System.err.println("An IOException was caught: " + e.getMessage());
        }
    }
}
