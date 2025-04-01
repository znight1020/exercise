// ========== any ========== 특정 변수의 타입을 확정지을 수 없을때, 모든 타입 검사 통과
let anyVar: any;

anyVar = 10;
anyVar = "string";
anyVar = {};
anyVar = () => {};
anyVar.toUpperCase();

let num: number;
num = anyVar;

// ========== unknown ========== any와 마찬가지로 모든 타입 검사가 통과된다.
let unknownVar: unknown;
unknownVar = 10;
unknownVar = "string";
unknownVar = {};
unknownVar = () => {};

// unknownVar.toUpperCase(); 1. 특정 타입의 함수를 사용할 수 없다.
// num = unknownVar; 2. 타입이 지정된 변수에 할당할 수 없다.
// 다음과 같이 타입을 확정지은 상태에서는 사용이 가능하다. (타입 정제)
if (typeof unknownVar === "number") {
  unknownVar.toFixed();
  num = unknownVar;
}
