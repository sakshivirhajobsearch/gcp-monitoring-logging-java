package com.gcp.monitoring.logging;

import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.*;
import com.google.protobuf.util.Timestamps;
import com.google.api.Metric;
import com.google.api.MetricDescriptor.MetricKind;
import com.google.api.MetricDescriptor.ValueType;
import com.google.api.MonitoredResource;

import java.io.IOException;
import java.util.HashMap;

public class MonitoringExample {

	public static void sendCustomMetric() throws IOException {
		
		try (MetricServiceClient client = MetricServiceClient.create()) {
			String projectId = "your-project-id";
			ProjectName name = ProjectName.of(projectId);

			TimeSeries timeSeries = TimeSeries.newBuilder()
					.setMetric(Metric.newBuilder().setType("custom.googleapis.com/myapp/custom_metric"))
					.setResource(MonitoredResource.newBuilder().setType("global").putAllLabels(new HashMap<>() {
						{
							put("project_id", projectId);
						}
					}))
					.addPoints(Point.newBuilder()
							.setInterval(TimeInterval.newBuilder()
									.setEndTime(Timestamps.fromMillis(System.currentTimeMillis())))
							.setValue(TypedValue.newBuilder().setDoubleValue(1.0)))
					.build();

			client.createTimeSeries(name, java.util.Collections.singletonList(timeSeries));
			System.out.println("Custom metric sent to Cloud Monitoring.");
		}
	}
}