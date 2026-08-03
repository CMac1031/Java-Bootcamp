package com.northstar.crm.exception;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorResponse {

    private final Instant timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String correlationId;
    private final Map<String, String> errors;

    public ErrorResponse(
            int status,
            String error,
            String message,
            String correlationId,
            Map<String, String> errors) {

        this.timestamp = Instant.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.correlationId = correlationId;

        Map<String, String> safeErrors =
                errors == null ? Map.of() : errors;

        this.errors = Collections.unmodifiableMap(
                new LinkedHashMap<>(safeErrors));
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();

        json.append("{");
        json.append("\"timestamp\":\"")
                .append(escape(timestamp.toString()))
                .append("\",");
        json.append("\"status\":")
                .append(status)
                .append(",");
        json.append("\"error\":\"")
                .append(escape(error))
                .append("\",");
        json.append("\"message\":\"")
                .append(escape(message))
                .append("\",");
        json.append("\"correlationId\":\"")
                .append(escape(correlationId))
                .append("\",");
        json.append("\"errors\":{");

        boolean first = true;

        for (Map.Entry<String, String> entry : errors.entrySet()) {
            if (!first) {
                json.append(",");
            }

            json.append("\"")
                    .append(escape(entry.getKey()))
                    .append("\":\"")
                    .append(escape(entry.getValue()))
                    .append("\"");

            first = false;
        }

        json.append("}");
        json.append("}");

        return json.toString();
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }

        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}