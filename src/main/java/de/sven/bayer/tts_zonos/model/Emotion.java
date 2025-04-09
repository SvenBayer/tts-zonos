package de.sven.bayer.tts_zonos.model;

public record Emotion(
        double happiness,
        double sadness,
        double disgust,
        double fear,
        double surprise,
        double anger,
        double other,
        double neutral
) {}