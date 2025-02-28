package de.sven.bayer.tts_zonos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class TtsZonosApplicationTests {

	@Test
	void contextLoads() {
	}

}
