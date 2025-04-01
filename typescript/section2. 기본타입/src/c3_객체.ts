// user.id -> object 형식에 'id' 속성을 사용할 수 없음
let userA: object = {
  id: 1,
  name: "이현수",
};

// 객체 리터럴 타입, 속성의 type을 지정한 후 사용 : Property Based Type System
// 구조적 타입 시스템 : property로 구분 <-> 명목적 타입 시스템 : 이름으로 구분
let userB: { id: number; name: string } = {
  id: 1,
  name: "이현수",
};
userB.id;

// 선택적 property : 속성뒤에 '?'를 붙이게 되면 해당 속성을 생략해도 된다.
let dog: { name: string; isCute?: boolean } = {
  name: "방울이",
  isCute: true,
};

dog = {
  name: "돌돌이",
};

// 읽기 전용 속성
let config: { readonly apiKey: string } = {
  apiKey: "MY API KEY",
};
// config.apiKey = "hacked"; // 예외발생
