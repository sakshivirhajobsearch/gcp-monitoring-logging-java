package com.gcp.monitoring.logging;

import org.junit.jupiter.api.Test;

public class GCPTest {

	@Test
	public void testLogging() {
		LoggingExample.logToCloud();
	}

	@Test
	public void testMonitoring() throws Exception {
		MonitoringExample.sendCustomMetric();
	}
}
