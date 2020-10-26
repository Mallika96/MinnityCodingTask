package com.minnity.report;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ReportService {

  //task 1: Return number of requests that were made for each company. (e.g. companyId -> requestNumber)
  public Map<Integer, Integer> calculateNumberOfRequestsPerCompany(List<RequestLog> requestLogs) {
	  Map<Integer, Integer> requestPerCompany = new HashMap<Integer, Integer>();
	  int count = 0;
	  for (RequestLog requestLog : requestLogs) {
		
		if(!requestPerCompany.isEmpty()) {
			if(requestPerCompany.containsKey(requestLog.getCompanyId())) {
				requestPerCompany.put(requestLog.getCompanyId(), requestPerCompany.get(requestLog.getCompanyId()+1));
			}else {
				requestPerCompany.put(requestLog.getCompanyId(), count+1);
			}
		}else {			
			requestPerCompany.put(requestLog.getCompanyId(), count+1);
		}
	}
	return requestPerCompany; 
    //throw new NotImplementedException("TODO implement this method");
  }

  //task 2: Count and return requests per company that finished with an error HTTP response code (>=400)
  public Map<Integer, List<RequestLog>> findRequestsWithError(List<RequestLog> requestLogs) {
	  Map<Integer, List<RequestLog>> requestPerCompany = new HashMap<Integer, List<RequestLog>>();
	  
	  for (RequestLog requestLog : requestLogs) {
		  if (requestLog.getRequestStatus() >= 400) {
			  requestPerCompany.computeIfAbsent(requestLog.getCompanyId(), k -> new ArrayList<RequestLog>()).add(requestLog);
		}
	  }
	  return requestPerCompany;
    //throw new NotImplementedException("TODO implement this method");
  }

  //task 3: find and print API (requests path) that on average takes the longest time to process the request.
  public String findRequestPathWithLongestDurationTime(List<RequestLog> requestLogs) {
	  
	  Map<String, List<RequestLog>> requestPerPath = new HashMap<String, List<RequestLog>>();

	  for (RequestLog requestLog : requestLogs) {
	      requestPerPath.computeIfAbsent(requestLog.getRequestPath(), k -> new ArrayList<RequestLog>()).add(requestLog);
	  }
	  
	  
	  Map<String, Long> requestAvgDuration = new HashMap<String, Long>();
	  for(Map.Entry<String, List<RequestLog>> entry : requestPerPath.entrySet()) {
		  String path = entry.getKey();
		  List<RequestLog> val = entry.getValue();
		  int noOfRequests = val.size();
		  Long duration = 0L;
		  Long avg = 0L;
		  for (RequestLog requestLog : val) {
			duration += requestLog.getRequestDuration(); 
		}
		  avg = duration/noOfRequests;
		  
		  requestAvgDuration.put(path, avg);
	  }
	  
	  
	  Long max = Collections.max(requestAvgDuration.values());
	  
	  //List<String> paths = new ArrayList<String>();
	  String path = "";
	  for (Entry<String, Long> entry : requestAvgDuration.entrySet()) {
	      if (entry.getValue()==max) {
	          //paths.add(entry.getKey());
	    	  path = entry.getKey();
	      }
	  }
	  //    throw new NotImplementedException("TODO implement this method");
  return path;
  }
}
