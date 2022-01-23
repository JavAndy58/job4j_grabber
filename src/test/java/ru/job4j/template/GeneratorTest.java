package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratorTest {
    @Ignore
    @Test
    public void whenProduceOk() {
        Generator generator = new GeneratorText();
        Map<String, String> valueMap = Map.of("name", "Petr", "subject", "you");
        String sampleText = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Petr, Who are you?";
        String actual = generator.produce(sampleText, valueMap);
        assertThat(actual, is(expected));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenProduceNotKey() {
        Generator generator = new GeneratorText();
        Map<String, String> valueMap = Map.of("nickname", "Petr", "who", "you");
        String sampleText = "I am a ${name}, Who are ${subject}?";
        generator.produce(sampleText, valueMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenProduceExtraKey() {
        Generator generator = new GeneratorText();
        Map<String, String> valueMap =
                Map.of("name", "Petr", "subject", "you", "nickname", "Petr", "who", "you");
        String sampleText = "I am a ${name}, Who are ${subject}?";
        generator.produce(sampleText, valueMap);
    }
}
