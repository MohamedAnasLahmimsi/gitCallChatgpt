package com.izicap.chatgptcall.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.izicap.chatgptcall.models.Answer;
import com.izicap.chatgptcall.models.Request;
import com.izicap.chatgptcall.models.Response;

@RestController
@RequestMapping
public class QuestionsController {
    @Value("${chatgpt.api.key}")
    private String apiKey;

    @GetMapping("/ask")
    public ResponseEntity<Response> answerQuestion(@RequestParam String question) {
        Response res = new Response(question, ask(question).getAnswerText());
        saveCSV(res);
        return ResponseEntity.ok(res);
    }

    private Answer ask(String question) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri;
        try {
            uri = new URI("https://api.openai.com/v1/completions");

            Request req = new Request(question);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey);

            HttpEntity<Request> httpEntity = new HttpEntity<>(req, headers);

            ResponseEntity<Answer> result =
                    restTemplate.postForEntity(uri, httpEntity, Answer.class);


            return result.getBody();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveCSV(Response res) {
        String path = Paths.get("data/data.csv").toUri().getPath();
        File file = new File(path);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(System.getProperty("line.separator"));
            fr.write(res.getQuestion() + ";" + res.getAnswer().replaceAll("\\n", ""));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
