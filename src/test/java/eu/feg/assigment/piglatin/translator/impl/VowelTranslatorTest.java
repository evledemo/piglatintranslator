package eu.feg.assigment.piglatin.translator.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

public class VowelTranslatorTest {

  private final VowelTranslator vowelTranslator = new VowelTranslator();

  @Test
  public void testVowelTranslator() {
    var expected = new StringBuilder("appleway");
    var translate = vowelTranslator.translate(new StringBuilder("apple"));
    assertEquals(translate.toString(), expected.toString(),
        String.format("Unexpected output: %s for input %s", translate, expected));

  }

  @Test
  public void testVowelTranslatorNullReturn() {
    var input = new StringBuilder("llo");
    assertNull(vowelTranslator.translate(input),
        String.format("Word %s should not be processed", input));
  }

}
