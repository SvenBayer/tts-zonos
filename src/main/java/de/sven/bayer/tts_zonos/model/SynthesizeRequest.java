package de.sven.bayer.tts_zonos.model;

import java.util.List;

public record SynthesizeRequest(
        String model_choice,
        String text,
        String language,
        List<String> unconditional_keys,
        Emotion emotion
) {}