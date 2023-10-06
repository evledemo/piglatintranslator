package eu.feg.assigment.piglatin.translator;

public abstract class Translator {

  private Translator next;

  public abstract StringBuilder translate(StringBuilder word);

  public static Translator link(Translator first, Translator... chain) {
    var head = first;
    for (var nextInChain : chain) {
      head.next = nextInChain;
      head = nextInChain;
    }
    return first;
  }

  protected StringBuilder translateNext(StringBuilder word) {
    if (next == null) {
      return null;
    }
    return next.translate(word);
  }

}
