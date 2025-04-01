// ========== Array ==========
let numArr: number[] = [1, 2, 3];
let strArr: string[] = ["hello", "GoodBye"];
let boolArr: Array<boolean> = [true, false, true]; // Generic

// 배열에 들어가는 요소들의 타입이 다양할 경우
let multiArr: (number | string)[] = [1, "hello"];

// 다차원 배열의 타입을 정의하는 방법
let doubleArr: number[][] = [
  [1, 2, 3],
  [4, 5],
];

// ========== tuple ========== 길이와 타입이 고정된 배열
let tup1: [number, number] = [1, 2];
let tup2: [number, string, boolean] = [1, "2", true];

// 요소의 순서가 중요한 경우 튜플을 사용한다.
const users: [string, number][] = [
  ["이현수", 1],
  ["홍길동", 2],
  ["남도일", 3],
  // [4, "짱구"], // string 영역에 number를 할당할 수 없어 컴파일 오류가 발생한다.
];
