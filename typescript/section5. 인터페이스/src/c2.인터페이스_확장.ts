/**
 * 인터페이스 확장
 * 1. 중복 property 제거
 */

interface Animal {
  name: string;
  age: number;
}

interface Dog extends Animal {
  // name: "string"; // 부모 property의 sub Type으로 선언해야한다. (string -> String literal)
  name: string;
  isBark: boolean;
}

interface Cat extends Animal {
  isScratch: boolean;
}

interface DogCat extends Dog, Cat {
  isCute: boolean;
}
