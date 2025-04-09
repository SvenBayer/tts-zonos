package de.sven.bayer.tts_zonos.service;

import de.sven.bayer.tts_zonos.model.Emotion;
import de.sven.bayer.tts_zonos.model.SynthesizeRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TtsService {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:7861";

    public TtsService() {
        this.restTemplate = new RestTemplate();
    }

    public byte[] synthesizeSentence(String sentence) {
        SynthesizeRequest request = new SynthesizeRequest(
                "Zyphra/Zonos-v0.1-hybrid",
                sentence,
                "en-us",
                List.of("pitch_std"),
                new Emotion(1, 0.05, 0.05, 0.1, 0.3, 0.1, 0.1, 0.2)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SynthesizeRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(
                baseUrl + "/synthesize",
                HttpMethod.POST,
                entity,
                byte[].class
        );

        return response.getBody();
    }
}