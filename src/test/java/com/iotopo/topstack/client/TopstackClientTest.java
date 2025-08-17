package com.iotopo.topstack.client;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TopstackClientTest {
    private TopstackClient client;

    @Before
    public void setUp() {
        client = new TopstackClient("http://localhost:800", "test-app-id", "test-app-secret");
    }

    @Test
    public void testClientInitialization() {
        assertNotNull(client);
        assertNotNull(client.getObjectMapper());
    }

    @Test
    public void testObjectMapperConfiguration() {
        assertNotNull(client.getObjectMapper());
    }
} 