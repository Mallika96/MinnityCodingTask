package com.minnity.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReportService rs = new ReportService();
		SampleDataGenerator dg = new SampleDataGenerator();
		
		Map<Integer, Integer> task1 = new HashMap<Integer, Integer>();
		Map<Integer, List<RequestLog>> task2 = new HashMap<Integer, List<RequestLog>>();
		String task3 = "";
		
		List<RequestLog> requestLogs = new ArrayList<RequestLog>();
		requestLogs.add(dg.aRequestLog());
		requestLogs.add(dg.aRequestLog());
		requestLogs.add(dg.aRequestLog());
		requestLogs.add(dg.aRequestLog());
		requestLogs.add(dg.aRequestLog());
		requestLogs.add(dg.aRequestLog());
		
		task1 = rs.calculateNumberOfRequestsPerCompany(requestLogs);
		task2 = rs.findRequestsWithError(requestLogs);
		task3 = rs.findRequestPathWithLongestDurationTime(requestLogs);
		System.out.println("this is task 3 : "+task3);
		
	}

}
