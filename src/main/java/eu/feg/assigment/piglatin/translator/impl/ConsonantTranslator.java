package eu.feg.assigment.piglatin.translator.impl;

import static eu.feg.assigment.piglatin.translator.impl.VowelTranslator.VOWELS;

import eu.feg.assigment.piglatin.translator.Translator;

public class ConsonantTranslator extends Translator {

  private final String AFFIX = "ay";

  @Override
  public StringBuilder translate(StringBuilder word) {

    var firstchar = word.charAt(0);
    if (VOWELS.indexOf(firstchar) < 0) {
      var result = new StringBuilder(word);
      result.deleteCharAt(0);
      result.append(firstchar);
      result.append(AFFIX);
      return result;
    }

    return translateNext(word);
  }
}
