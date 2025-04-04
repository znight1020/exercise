/**
 * 함수 타입 호환성
 * 특정 함수 타입을 다른 함수 타입으로 취급이 가능한지 검사
 * 1. 반환값의 타입이 호환되는가
 * 2. 매개변수의 타입이 호환되는가
 */

// 기준1. 반환값이 호환되는가
type A = () => number;
type B = () => 10;

let a: A = () => 10; // number
let b: B = () => 10; // number literal
a = b;
// b = a; 불가능

// 기준2. 매개변수가 호환되는가
type C = (value: number) => void;
type D = (value: 10) => void;

// 위 예시와 다르게 업캐스팅 시 호환이 되지않는다.
// TS에서 함수 = 객체이다. 객체의 호환성을 생각하면 이해하기 쉽다.
let c: C = () => {};
let d: D = () => {};

// c = d; 불가능, ()
d = c;

type Animal = {
  name: string;
};
type Dog = {
  name: string;
  color: string;
};

let animalFunc = (animal: Animal) => {
  console.log(animal.name);
};
let dogFunc = (dog: Dog) => {
  console.log(dog.name);
  console.log(dog.color);
};
/**
 * animalFunc = dogFunc;
 * Animal = super Type, Dog = sub Type
 * Animal 객체를 매개변수로 넣었을 때 sub Type인 Dog의 property는 접근할 수 없다.
 * */
