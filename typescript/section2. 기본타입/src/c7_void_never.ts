// ========== void ========== 아무것도 없음을 의미한다.
// undefined, null (함수의 return 명시 필요) <-> void (명시 불필요)
let var1: void;
var1 = undefined; // void 타입은 오직 undefined 만이 할당가능하다.

function func1(): string {
  return "hello";
}

function func2(): void {} // 반환값이 없는 경우: 반환 타입 = void

// ========== never ========== 불가능한 타입(반환 자체가 모순인 경우)
function func3(): never {
  while (true) {}
}

function func4(): never {
  throw new Error();
}
