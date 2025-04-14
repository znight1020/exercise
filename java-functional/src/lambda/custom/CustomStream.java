package lambda.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomStream<T> {
  private List<T> internalList;

  private CustomStream(List<T> internalList) {
    this.internalList = internalList;
  }

  // static Factory
  public static <T> CustomStream<T> of(List<T> internalList) {
    return new CustomStream<>(internalList);
  }

  public CustomStream<T> filter(Predicate<T> predicate) {
    List<T> filtered = new ArrayList<>();
    for(T element : internalList) {
      if(predicate.test(element)) {
        filtered.add(element);
      }
    }
    return new CustomStream<>(filtered);
  }

  public <R> CustomStream<R> map(Function<T, R> mapper) {
    List<R> mapped = new ArrayList<>();
    for(T element : internalList) {
      mapped.add(mapper.apply(element));
    }
    return new CustomStream<>(mapped);
  }

  public List<T> toList() {
    return internalList;
  }

  public void forEach(Consumer<T> consumer) {
    for(T element : internalList) {
      consumer.accept(element);
    }
  }
}
