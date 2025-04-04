/**
 * 함수 오버로딩
 * 하나의 함수를 매개변수의 개수, 타입에 따라 여러가지 버전으로 정의
 */

// 버전 -> 오버로드 시그니처
function func(a: number): void;
function func(a: number, b: number, c: number): void;

// 실제 구현부 -> 구현 시그니처
function func(a: number, b?: number, c?: number) {
  if (typeof b === "number" && typeof c === "number") {
    console.log(a + b + c);
  } else {
    console.log(a * 20);
  }
}

func(1);
func(1, 3, 5);
