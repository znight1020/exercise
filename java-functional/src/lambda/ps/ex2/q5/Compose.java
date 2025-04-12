package lambda.ps.ex2.q5;

public class Compose {

  public static void main(String[] args) {
    MyTransformer transformer = compose((String s) -> s.toUpperCase(), (String s) -> "**" + s + "**");
    System.out.println(transformer.transform("hello"));
  }

  static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
    return s -> {
      String temp = f1.transform(s);
      return f2.transform(temp);
    };
  }
}
