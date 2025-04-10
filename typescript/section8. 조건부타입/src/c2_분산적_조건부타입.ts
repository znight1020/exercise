type StringNumberSwitch<T> = T extends string ? number : string;
let a: StringNumberSwitch<number>; // a의 type === string
let b: StringNumberSwitch<string>; // a의 type === number

/**
 * 다음 변수는 조건부타입에 의해 결과가 string이 예상되지만
 * 실제 결과는 string | number 유니온 타입인 것을 확인할 수 있다.
 * 이는 다음과 같이 실행되기 때문이다.
 *
 * 1. StringNumberSwitch<string>;
 * 2. StringNumberSwitch<number>;
 * 3. 이후 각각의 결과를 다시 union 한다.
 */
let c: StringNumberSwitch<string | number>;

/**
 * 동일 타입 제거
 */
type Exclude<T, U> = T extends U ? never : T;
type A = Exclude<number | string | boolean, string>;
/**
 * 1단계
 * Exclude<number, string>
 * Exclude<string, string>
 * Exclude<boolean, string>
 *
 * 2단계
 * number |
 * never |
 * boolean
 *
 * 결과
 * number | boolean <- never는 공집합이므로 union 시 사라진다.
 */

/**
 * 동일 타입 추출
 */
type Extract<T, U> = T extends U ? T : never;
type B = Extract<number | string | boolean, string>; // 결과 : string
