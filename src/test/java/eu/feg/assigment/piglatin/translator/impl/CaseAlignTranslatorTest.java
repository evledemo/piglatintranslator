package eu.feg.assigment.piglatin.translator.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.feg.assigment.piglatin.translator.Translator;
import org.junit.Test;

public class CaseAlignTranslatorTest {

  private static final Translator translator = Translator.link(
      new SkipTranslator(),
      new CaseAlignTranslator(),
      new VowelTranslator(),
      new ConsonantTranslator()
  );

  @Test
  public void testConsonantTranslator() {
    var input = new StringBuilder("Hello");
    var expected = new StringBuilder("Ellohay");
    var translate = translator.translate(input);
    assertEquals(translate.toString(), expected.toString(),
        String.format("Unexpected output: %s for input %s", translate, expected));

  }

}
