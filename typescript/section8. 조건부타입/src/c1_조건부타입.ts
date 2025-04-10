type A = number extends string ? string : number;

// 오버로드 시그니처를 정의하여 호출 시 정확한 반환 타입을 추론할 수 있도록 한다.
function removeSpaces<T>(text: T): T extends string ? string : undefined;

// 함수 내부에서는 조건부 타입의 결과가 어떤 타입인지 알 수 없다. 따라서, 컴파일러는 문자열이 매개변수로 들어와도 string 이라고 확정지을 수 없다.
// 함수 내부에서 T의 타입은 unknown
// function removeSpaces<T>(text: T): T extends string ? string : undefined {
function removeSpaces<T>(text: T) {
  // typeof 를 사용하여 string 을 명시하였지만 반환 시점에서는 type이 string인지 undefined 인지 확정짓지 못한다.
  if (typeof text === "string") {
    return text.replaceAll(" ", "");
  } else {
    return undefined;
  }
}

let result1 = removeSpaces("Hi, nice to meet you."); // string
result1.toUpperCase();

let result2 = removeSpaces(undefined); // undefined

/** 흐름을 정리하면 다음과 같다
 * 1. removeSpaces("Hi, I'm Lee") 호출 → 입력값이 string임을 기반으로 T = string 추론
 * 2. 오버로드 시그니처에서 T extends string 조건을 만족하니 반환 타입 = string
 * 3. 함수 내부 실행: 문자열이면 replaceAll 실행하고 리턴
 * 4. 최종 반환값은 string이 되고, result 변수의 타입도 string으로 인식됨
 */
