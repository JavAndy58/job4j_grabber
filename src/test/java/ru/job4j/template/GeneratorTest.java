package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

public class GeneratorTest {

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenProduceNotKey() {
        Generator generator = new GeneratorText();
        Map<String, String> valueMap = Map.of("key1", "value1");
        String sampleText = "I am a ${name}, Who are ${subject}?";
        generator.produce(sampleText, valueMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenProduceExtraKey() {
        Generator generator = new GeneratorText();
        Map<String, String> valueMap = Map.of("key1", "value1", "key2", "value2");
        String sampleText = "I am a ${name}, Who are ${subject}?";
        generator.produce(sampleText, valueMap);
    }
}
