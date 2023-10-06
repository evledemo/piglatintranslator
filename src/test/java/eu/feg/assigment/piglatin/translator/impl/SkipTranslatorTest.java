package eu.feg.assigment.piglatin.translator.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

public class SkipTranslatorTest {

  private SkipTranslator skipTranslator = new SkipTranslator();

  @Test
  public void testSkipTranslatorUnmodified() {
    var input = new StringBuilder("stairway");
    var translate = skipTranslator.translate(input);
    assertEquals(translate.toString(), input.toString(),
        String.format("Unexpected output: %s for input %s", translate, input));
  }

  @Test
  public void testSkipTranslatorNullReturn() {
    var input = new StringBuilder("stairwayy");
    assertNull(skipTranslator.translate(input),
        String.format("Word %s should not be processed", input));
  }

}
