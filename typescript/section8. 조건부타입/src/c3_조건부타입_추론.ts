/**
 * infer = 조건부타입 내에서 타입 추론
 */

type FuncA = () => string;
type FuncB = () => number;

// 함수의 리턴 타입을 확인하는 코드를 살펴보자.
// T가 R의 서브 타입이 될 수 있도록 R을 추론한다.
type ReturnType<T> = T extends infer R ? R : never;
type A = ReturnType<FuncA>; // typeof A === "string"
type B = ReturnType<FuncB>; // typeof B === "number"

type C = ReturnType<number>; // typeof C === "never" : 이 경우에는 함수 타입이 아닌 number 타입이 넘어갔으므로 never를 반환 (추론 불가)

/**
 * 문제. 다음 PromiseA, PromiseB 가 number, string 타입이 되도록 any 부분을 수정
 * type PromiseUnpack<T> = any;
 */

// 1. T는 Promise 타입이어야 한다.
// 2. Promise 타입의 결과값 타입을 반환해야 한다.
type PromiseUnpack<T> = T extends Promise<infer R> ? R : never;

type PromiseA = PromiseUnpack<Promise<number>>;
type PromiseB = PromiseUnpack<Promise<string>>;
