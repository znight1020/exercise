// 함수를 설명하는 가장 좋은 방법
// 어떤 [타입]의 매개변수를 받고, 어떤 [타입]의 결과값을 반환하는지 작성

/**
 * 기본 함수 정의
 */
function func(a: number, b: number): number {
  return a + b;
}

/**
 * 화살표 함수 정의
 */
const add = (a: number, b: number) => a + b;

/**
 * 함수의 매개변수
 * 1. 선택적 매개변수 허용
 * 2. 필수 매개변수는 반드시 선택적 매개변수 앞에 와야한다.
 */
function introduce(name = "이현수", age?: number) {
  console.log(`name : ${name}`);

  if (typeof age === "number") {
    console.log(`age : ${age + 5}`);
  }
}
introduce("이현수", 27);
introduce("이현수");

function getSum(...rest: number[]) {
  let sum = 0;
  rest.forEach((i) => (sum += i));
}
