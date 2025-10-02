package org.example;

public class ApiService {
    private final ApiClient client;

    public ApiService(ApiClient client) {
        this.client = client;
    }

    public String fetchUppercasedData() {
        return client.getData().toUpperCase();
    }

    public boolean hasData() {
        return client.getData() != null;
    }
}