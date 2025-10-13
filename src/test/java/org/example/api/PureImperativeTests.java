package org.example.api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class PureImperativeTests {

    private String BASE_URL;
    private HttpClient client;

    @BeforeClass
    public void setup() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/config.properties"));
            BASE_URL = prop.getProperty("api_url");
        } catch (IOException e) {
            e.printStackTrace();
        }

        client = HttpClient.newHttpClient();
    }

    @Test
    public void testGetPost() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(response.statusCode(), 200);
        System.out.println("GET Response: " + response.body());
    }

    @Test
    public void testCreatePost() throws Exception {
        String json = """
                {
                  "title": "Imperative Post",
                  "body": "Created without Carina",
                  "userId": 1
                }
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(response.statusCode(), 201);
        System.out.println("POST Response: " + response.body());
    }

    @Test
    public void testUpdatePost() throws Exception {
        String json = """
                {
                  "title": "Updated Imperative Post",
                  "body": "Updated body imperatively",
                  "userId": 1
                }
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(response.statusCode(), 200);
        System.out.println("PUT Response: " + response.body());
    }

    @Test
    public void testDeletePost() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(response.statusCode(), 200);
        System.out.println("DELETE Response: " + response.body());
    }

    @Test
    public void testPatchPost() throws Exception {
        String json = """
                {
                  "title": "Patched Imperative"
                }
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/posts/1"))
                .method("PATCH", HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(response.statusCode(), 200);
        System.out.println("PATCH Response: " + response.body());
    }
}
