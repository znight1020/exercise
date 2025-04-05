// any를 사용해도 되지만 타입 검사 시 any 타입으로 인식 -> 컴파일 에러 검사 X
// 함수 호출 시 타입을 지정할 수 있도록 타입 변수 사용
function func<T>(val: T): T {
  return val;
}
let num = func(10);
let arr = func<[number, number, number]>([10, 20, 30]);

/**
 * 다중 타입 변수
 */
function swap<T, U>(a: T, b: U) {
  return [b, a];
}
const [a, b] = swap(1, "string");

/**
 * 타입 변수 - 배열
 */
function returnFirstValueV1<T>(data: T[]) {
  return data[0];
}

function returnFirstValueV2<T>(data: [T, ...unknown[]]) {
  return data[0];
}

let n1 = returnFirstValueV1([1, 2, 3]);
// V1의 경우 T의 type은 number | stirng으로 추론이 된다.
// V2와 같이 정확한 타입 지정을 위해 첫번째 요소를 타입 변수로 지정해주면 number로 추론이 된다.
let n2 = returnFirstValueV2([1, "string", "string"]);

/**
 * 타입 변수의 확장
 * - interface의 확장을 생각하면 이해하기 쉽다.
 */

function getLength<T extends { length: number }>(data: T) {
  return data.length;
}
let var1 = getLength([1, 2, 3]);
let var2 = getLength("string");
let var3 = getLength({ length: 10 });
// let var4 = getLength(10); number Tpye은 length property를 가지지않는다.
