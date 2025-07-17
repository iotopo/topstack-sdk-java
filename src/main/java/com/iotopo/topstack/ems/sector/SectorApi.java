package com.iotopo.topstack.ems.sector;

import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

public class SectorApi {
    
    public static SectorListResponse query(TopstackClient client, SectorListRequest request) throws TopstackException {
        return client.get("/ems/open_api/v1/sector", request, SectorListResponse.class);
    }
    
    public static DetailResponse getDetail(TopstackClient client, DetailRequest request) throws TopstackException {
        return client.get("/ems/open_api/v1/sector/" + request.getId(), null, DetailResponse.class);
    }
    
    public static ReportResponse getReport(TopstackClient client, ReportRequest request) throws TopstackException {
        return client.post("/ems/open_api/v1/report/sector/hourly", request, ReportResponse.class);
    }
    
    public static HourlyReportResponse getHourlyReport(TopstackClient client, ReportRequest request) throws TopstackException {
        return client.get("/ems/open_api/v1/report/sector/hourly", request, HourlyReportResponse.class);
    }
} 