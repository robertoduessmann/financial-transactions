package karate;

import com.intuit.karate.junit5.Karate;

public class KarateTests {

  @Karate.Test
  Karate testAll() {
    return new Karate().relativeTo(getClass());
  }
}