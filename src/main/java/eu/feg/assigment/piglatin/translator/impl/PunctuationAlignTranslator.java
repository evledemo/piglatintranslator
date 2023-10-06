package eu.feg.assigment.piglatin.translator.impl;

import eu.feg.assigment.piglatin.translator.Translator;

public class PunctuationAlignTranslator extends Translator {

  private final String APOSTROPHE = "’";

  @Override
  public StringBuilder translate(StringBuilder word) {
    var result = translateNext(word);

    var apostropheIndex = result.indexOf(APOSTROPHE);
    if (apostropheIndex > 0) {
      result.deleteCharAt(apostropheIndex);
      result.insert(result.length() - 1, APOSTROPHE);
    }
    var alignedResult = new StringBuilder(result);

    return alignedResult;
  }

}
