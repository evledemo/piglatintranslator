package eu.feg.assigment.piglatin.translator.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.feg.assigment.piglatin.translator.Translator;
import org.junit.Test;

public class PunctuationAlignTranslatorTest {

  private static final Translator translator = Translator.link(
      new SkipTranslator(),
      new PunctuationAlignTranslator(),
      new CaseAlignTranslator(),
      new VowelTranslator(),
      new ConsonantTranslator()
  );

  @Test
  public void testConsonantTranslator() {
    var input = new StringBuilder("can’t");
    var expected = new StringBuilder("antca’y");
    var translate = translator.translate(input);
    assertEquals(translate.toString(), expected.toString(),
        String.format("Unexpected output: %s for input %s", translate, expected));

  }

}
