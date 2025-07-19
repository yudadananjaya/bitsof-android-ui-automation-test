package com.bitsof.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestData {
    private String testCaseId;
    private String testPlatform;
    private String env;
    private Account account;
    private Object testData;
    private Object expectedResultData;
    private Object pushChanges;
    private Object pullChanges;
}
