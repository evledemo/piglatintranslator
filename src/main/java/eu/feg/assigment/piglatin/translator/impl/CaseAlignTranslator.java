package eu.feg.assigment.piglatin.translator.impl;

import eu.feg.assigment.piglatin.translator.Translator;

public class CaseAlignTranslator extends Translator {

  @Override
  public StringBuilder translate(StringBuilder word) {
    var result = translateNext(word);
    var alignedResult = new StringBuilder(result.toString().toLowerCase());

    for (var i = 0; i < word.length(); i++) {
      if (Character.isUpperCase(word.charAt(i))) {
        var upperCase = String.valueOf(Character.toUpperCase(alignedResult.charAt(i)));
        alignedResult.replace(i, i + 1, upperCase);
      }
    }

    return alignedResult;
  }

}
