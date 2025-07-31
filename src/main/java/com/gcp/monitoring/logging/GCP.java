package com.gcp.monitoring.logging;

public class GCP {

	public static void main(String[] args) throws Exception {
		
        LoggingExample.logToCloud();
        MonitoringExample.sendCustomMetric();
    }
}
