/**
 * Type의 이름을 지어주는 또 다른 문법
 * 1. 객체 구조를 정의하는데 특화
 * 2. 상속, 합침 등의 특수한 기능 제공
 */
interface Person {
  readonly name: string;
  age?: number;
  sayHi(): void;
  // 오버로딩 메서드 작성 시 property의 식별자가 중복되기 때문에 함수 표현식으로 선언할 수 없다.
  // 호출 시그니처 사용
  // sayHi: (a: number, b: number) => void; X
  sayHi(a: number, b: number): void;
}

const person: Person = {
  name: "이현수",
  sayHi: function () {
    console.log("Hi");
  },
};
