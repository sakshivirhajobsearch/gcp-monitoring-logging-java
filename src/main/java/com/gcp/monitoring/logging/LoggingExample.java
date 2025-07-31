package com.gcp.monitoring.logging;

import java.util.Collections;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Severity;

public class LoggingExample {

	public static void logToCloud() {
		LoggingOptions options = LoggingOptions.newBuilder().setProjectId("your-gcp-project-id") // ✅ Replace with
																									// actual project ID
				.build();

		Logging logging = options.getService();

		LogEntry entry = LogEntry.newBuilder(Payload.StringPayload.of("Test log message")).setSeverity(Severity.INFO)
				.setLogName("my-log").setResource(MonitoredResource.newBuilder("global").build()).build();

		logging.write(Collections.singleton(entry));
		System.out.println("Log written to Cloud Logging.");
	}

}
