package com.minnity.report;

import org.junit.Test;


public class ReportServiceTest {

  @Test
  public void todo() {
    RequestLog sampleRequest = SampleDataGenerator.aRequestLog();
    // Unit test cases for task1, task2 and task 3
    //task1
    /* 1. Send list of random requestLogs for same company and expect to return only one item in the map
     * 2. Send list of random requestLogs for multiple companies and expect to return more than one item in the map
     * 
     * task2
     * 1. Send list of random requestLogs for company having requeststatus ranging from 200 to 500 
     * and see if the request logs returns the company having error greater than or equal to 400
     * 
     * task3
     * 1. Send only one requestLog in the list and see if it returns the path of the same requestLog
     * 2. Send two requestLogs in the list and see if it returns the path of the requestLog having longer response time
     * 3. Send multiple requestLog in the list and see if it returns the path of the requestLog taking highest response time at an average
     */
  }
}