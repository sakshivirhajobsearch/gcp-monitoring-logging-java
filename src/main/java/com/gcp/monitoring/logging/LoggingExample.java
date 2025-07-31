package com.gcp.monitoring.logging;

import java.util.Collections;

import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Severity;

public class LoggingExample {

	public static void logToCloud() {
		
		Logging logging = LoggingOptions.newBuilder().setProjectId("your-gcp-project-id").build().getService();

		LogEntry entry = LogEntry.newBuilder(StringPayload.of("Test log entry")).setSeverity(Severity.INFO)
				.setLogName("my-log").build();

		logging.write(Collections.singleton(entry));

	}
}
