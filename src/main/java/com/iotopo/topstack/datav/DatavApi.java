package com.iotopo.topstack.datav;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;

public class DatavApi {
    public static class Param {
        private String name;
        private String value;

        public Param(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }

    public static String getPageUrl(String baseUrl, String pageID, String token, String username, String op, Param... params) throws Exception {
        long ts = Instant.now().toEpochMilli();

        Mac h = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(token.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        h.init(secretKey);
        h.update(pageID.getBytes(StandardCharsets.UTF_8));
        h.update("|".getBytes(StandardCharsets.UTF_8));
        h.update(String.valueOf(ts).getBytes(StandardCharsets.UTF_8));
        h.update("|".getBytes(StandardCharsets.UTF_8));
        h.update(username.getBytes(StandardCharsets.UTF_8));
        h.update("|".getBytes(StandardCharsets.UTF_8));
        h.update(op.getBytes(StandardCharsets.UTF_8));

        String signature = Base64.getEncoder().encodeToString(h.doFinal());

        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append("/topv/public/viewer/").append(pageID).append("?");
        url.append("time=").append(ts);
        url.append("&username=").append(URLEncoder.encode(username, StandardCharsets.UTF_8.name()));
        url.append("&op=").append(URLEncoder.encode(op, StandardCharsets.UTF_8.name()));
        url.append("&signature=").append(URLEncoder.encode(signature, StandardCharsets.UTF_8.name()));

        for (Param param : params) {
            url.append("&").append(param.getName()).append("=").append(URLEncoder.encode(param.getValue(), StandardCharsets.UTF_8.name()));
        }

        return url.toString();
    }
} 