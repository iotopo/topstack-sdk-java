package com.iotopo.topstack.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.*;

public class OffsetDateTimeSerializationTest {
    
    @Test
    public void testOffsetDateTimeSerialization() throws Exception {
        // 使用 TopstackClient 中的 ObjectMapper
        TopstackClient client = new TopstackClient("http://localhost:80", "app-id", "app-secret");
        ObjectMapper objectMapper = client.getObjectMapper();
        
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        String json = objectMapper.writeValueAsString(now);
        
        System.out.println("OffsetDateTime serialized as: " + json);
        
        // 验证是否是 ISO-8601 格式
        assertTrue("Should be ISO-8601 format", json.matches("\"\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?Z\""));
    }
    
    @Test
    public void testReportRequestSerialization() throws Exception {
        // 使用 TopstackClient 中的 ObjectMapper
        TopstackClient client = new TopstackClient("http://localhost:80", "app-id", "app-secret");
        ObjectMapper objectMapper = client.getObjectMapper();
        
        // 创建一个测试用的 ReportRequest 对象
        TestReportRequest request = new TestReportRequest();
        request.setStart(OffsetDateTime.now(ZoneOffset.UTC));
        request.setEnd(OffsetDateTime.now(ZoneOffset.UTC).plusHours(1));
        
        String json = objectMapper.writeValueAsString(request);
        System.out.println("ReportRequest serialized as: " + json);
        
        // 验证 start 和 end 字段是否是 ISO-8601 格式
        assertTrue("start should be ISO-8601 format", json.contains("\"start\":\""));
        assertTrue("end should be ISO-8601 format", json.contains("\"end\":\""));
        
        // 验证格式是否正确
        assertTrue("start should contain T and Z", json.contains("T") && json.contains("Z"));
        assertTrue("end should contain T and Z", json.contains("T") && json.contains("Z"));
    }
    
    // 测试用的内部类
    private static class TestReportRequest {
        private OffsetDateTime start;
        private OffsetDateTime end;
        
        public OffsetDateTime getStart() { return start; }
        public void setStart(OffsetDateTime start) { this.start = start; }
        public OffsetDateTime getEnd() { return end; }
        public void setEnd(OffsetDateTime end) { this.end = end; }
    }
} 