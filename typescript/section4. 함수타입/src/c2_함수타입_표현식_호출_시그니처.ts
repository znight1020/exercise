/**
 * 함수 타입 표현식
 */

type Operation1 = (a: number, b: number) => number;
const add1: Operation1 = (a, b) => a + b;
const sub1: Operation1 = (a, b) => a - b;
const multiply1: Operation1 = (a, b) => a * b;
const divide1: Operation1 = (a, b) => a / b;

/**
 * 호출 시그니처 (콜 시그니처)
 */

type Operation2 = {
  (a: number, b: number): number;
  name: string; // property 정의 가능 : 하이브리드 타입
};

const add2: Operation2 = (a, b) => a + b;
add2.name;

const sub2: Operation2 = (a, b) => a - b;
const multiply2: Operation2 = (a, b) => a * b;
const divide2: Operation2 = (a, b) => a / b;
