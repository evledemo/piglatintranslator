package eu.feg.assigment.piglatin;

import eu.feg.assigment.piglatin.translator.Translator;
import eu.feg.assigment.piglatin.translator.impl.CaseAlignTranslator;
import eu.feg.assigment.piglatin.translator.impl.ConsonantTranslator;
import eu.feg.assigment.piglatin.translator.impl.PunctuationAlignTranslator;
import eu.feg.assigment.piglatin.translator.impl.SkipTranslator;
import eu.feg.assigment.piglatin.translator.impl.VowelTranslator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class PigLatinTranslator {

  private static final String INPUT_TEXT_2 = "-s \"(.*?)\"";

  private static final Set<Character> SEPARATOR = Set.of(' ', '-', '.', ',');

  private static final Translator translator = Translator.link(
      new SkipTranslator(),
      new PunctuationAlignTranslator(),
      new CaseAlignTranslator(),
      new VowelTranslator(),
      new ConsonantTranslator()
  );

  public static void main(String[] args) {

    var inputString = new StringBuilder();
    for (var arg : args) {
      inputString.append(arg).append(" ");
    }

    if (!validateInput(inputString.toString())) {
      var scanner = new Scanner(System.in);
      while (scanner.hasNext()) {
        inputString.append(scanner.next());
      }
    }

    var translate = translateToPigLatin(inputString.toString());

    System.out.println(translate);
  }

  public static String translateToPigLatin(String inputString) {

    if (!validateInput(inputString)) {
      throw new UnsupportedOperationException(
          String.format(
              "Input doesn't match expected pattern. Expected pattern is: -s \"Translated string\" current: %s",
              inputString));
    }

    var translatedString = extractTranslatedString(inputString);

    return translate(translatedString);
  }

  private static String translate(String translated) {
    var translatedSB = new StringBuilder(translated);
    var wordStart = 0;
    var result = new StringBuilder();

    for (var i = 0; i <= translatedSB.length(); i++) {
      if (i == translatedSB.length()) {
        var word = new StringBuilder(translatedSB.substring(wordStart, i));
        result.append(translator.translate(word));
      } else if (SEPARATOR.contains(translatedSB.charAt(i))) {
        var word = new StringBuilder(translatedSB.substring(wordStart, i));
        result.append(translator.translate(word));
        result.append(translatedSB.charAt(i));
        wordStart = ++i;
      }
    }

    return result.toString();
  }

  private static String extractTranslatedString(String inputString) {
    var matcher = Pattern.compile(INPUT_TEXT_2).matcher(inputString);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return null;
  }

  private static boolean validateInput(String inputString) {
    var matcher = Pattern.compile(INPUT_TEXT_2).matcher(inputString);
    return matcher.find();
  }
}