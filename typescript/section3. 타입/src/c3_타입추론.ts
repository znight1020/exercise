/**
 * 타입 추론
 */

// 초기값, 반환값, 구조 분해값을 통해 타입 추론 + 타입 넓히기(범용 집합)
let a = 10;
let b = "hello";
let c = {
  id: 1,
  name: "이현수",
  profile: {
    nickname: "leehs",
  },
};

let { id, name, profile } = c;
let [one, two, three] = [1, "hello", true];

function func() {
  return "hello";
}

// 함수의 매개 변수의 타입은 초기값이 없으면 추론할 수 없다.
// function func(param) {}

// ========== const ==========
const num = 10; // const의 경우 number Type이 아닌 number literal Type을 가진다.

// ========== array ==========
let arr = [1, "string"]; // 배열의 경우 대수(union : number | string) Type을 가진다.

// any Type의 진화 : 유지보수 관점에서 지양해야 한다.
let var1; // 초기값이 없는 경우 '암묵적 any Type'을 가진다. <-> 명시적으로 any를 선언한 경우 모든 scope에서 any Type이다.

var1 = 10; // type = number
var1.toFixed();

var1 = "hello"; // type = string
var1.toUpperCase();
