/**
 * 기본 타입의 호환성
 */

let num1: number = 10;
let num2: 10 = 10;
num1 = num2;
// num2 = num1;

/**
 * 객체 타입간의 호환성
 * property를 기준으로 super, sub 관계를 가진다.
 * property의 개수가 적은 객체 = super
 */

type Animal = {
  name: string;
  color: string;
};

type Dog = {
  name: string;
  color: string;
  breed: string;
};

let animal: Animal = {
  name: "기린",
  color: "brown",
};

let dog: Dog = {
  name: "방울이",
  color: "white",
  breed: "말티즈",
};

animal = dog; // 업캐스팅
// dog = animal; // 다운캐스팅(일반적인 경우 허용하지 않는다.)

/**
 * 초과 프로퍼티 검사
 * super 타입의 객체에서 '객체 리터럴 타입' 사용 시 컴파일 오류가 발생한다.
 */

// let animal2: Animal = {
//    name: "돌돌이",
//    color: "orange",
//    breed: "시츄"
// }
