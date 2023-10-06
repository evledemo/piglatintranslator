package eu.feg.assigment.piglatin.translator.impl;

import eu.feg.assigment.piglatin.translator.Translator;

public class SkipTranslator extends Translator {

  private final String SKIP_AFFIX = "way";

  @Override
  public StringBuilder translate(StringBuilder word) {
    if (word.toString().endsWith(SKIP_AFFIX)) {
      return word;
    }
    return translateNext(word);
  }
}
