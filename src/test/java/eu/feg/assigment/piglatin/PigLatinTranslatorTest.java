package eu.feg.assigment.piglatin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PigLatinTranslatorTest {

  private static final String INPUT_PATTERN = "-s \"%s\"";

  @Test
  public void testTranslateToPigLatinStartWithConsonant() {
    var input = "hello";
    var expected = "ellohay";
    test(input, expected);
  }


  @Test
  public void testTranslateToPigLatinStartWithVowel() {
    var input = "appleway";
    test(input, input);
  }

  @Test
  public void testTranslateToPigLatinCase() {
    var input = "Hello";
    var expected = "Ellohay";
    test(input, expected);
  }

  @Test
  public void testTranslateToPigLatinPunctuation() {
    var input = "can’t";
    var expected = "antca’y";
    test(input, expected);
  }

  @Test
  public void testTranslateToPigLatinUnmodified() {
    var input = "stairway";
    var expected = "stairway";
    test(input, expected);
  }

  @Test
  public void testTranslateToPigLatinLongText() {
    var input = "hello stairway can’t this-thing";
    var expected = "ellohay stairway antca’y histay-hingtay";
    test(input, expected);
  }

  @Test
  public void testTranslateToPigLatinHyphens() {
    var input = "this-thing";
    var expected = "histay-hingtay";
    test(input, expected);
  }

  @Test
  public void testTranslateToPigLatinCapitalization() {
    var input = "Hello Stairway can’t McCloud This-Thing";
    var expected = "Ellohay Stairway antca’y CcLoudmay Histay-Hingtay";
    test(input, expected);
  }

  private void test(String input, String expected) {
    input = String.format(INPUT_PATTERN, input);
    var translated = PigLatinTranslator.translateToPigLatin(input);
    assertEquals(expected, translated,
        String.format("Unexpected output: \"%s\" for input \"%s\"", translated, expected));
  }

}