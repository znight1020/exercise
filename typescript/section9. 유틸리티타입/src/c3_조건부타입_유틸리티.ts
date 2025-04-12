/**
 * Exclude<T, U>
 * -> T에서 U에 해당하는 타입을 제외한 나머지 타입을 만들어주는 타입
 */

type A = Exclude<string | boolean, boolean>;

/**
 * Extract<T, U>
 * -> T에서 U에 해당하는 타입만 추출하여 새로운 타입을 만들어주는 타입
 */

type B = Extract<string | boolean, boolean>;

/**
 * ReturnType<T>
 * -> 함수 타입 T의 반환값 타입을 추출하여 새로운 타입을 만들어주는 타입
 */

function fucnA(): string {
  return "hello";
}

type ReturnA = ReturnType<typeof fucnA>;
