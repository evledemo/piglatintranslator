package eu.feg.assigment.piglatin.translator.impl;

import eu.feg.assigment.piglatin.translator.Translator;

public class VowelTranslator extends Translator {

  public static final String VOWELS = "aeiou";
  public static final String AFFIX = "way";

  @Override
  public StringBuilder translate(StringBuilder word) {
    var firstChar = word.charAt(0);
    if (VOWELS.indexOf(firstChar) >= 0) {
      word = new StringBuilder(word);
      word.append(AFFIX);
      return word;
    }

    return translateNext(word);
  }

}
