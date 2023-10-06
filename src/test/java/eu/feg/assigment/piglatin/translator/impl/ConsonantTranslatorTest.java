package eu.feg.assigment.piglatin.translator.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

public class ConsonantTranslatorTest {

  private final ConsonantTranslator consonantTranslator = new ConsonantTranslator();

  @Test
  public void testConsonantTranslator() {
    var input = new StringBuilder("hello");
    var expected = new StringBuilder("ellohay");
    var translate = consonantTranslator.translate(input);
    assertEquals(translate.toString(), expected.toString(),
        String.format("Unexpected output: %s for input %s", translate, expected));

  }

  @Test
  public void testConsonantTranslatorNullReturn() {
    var input = new StringBuilder("ello");
    assertNull(consonantTranslator.translate(input),
        String.format("Word %s should not be processed", input));
  }
}
