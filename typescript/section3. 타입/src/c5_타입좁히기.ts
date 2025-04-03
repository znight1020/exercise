/**
 * 타입 좁히기
 * 조건문 등을 이용해 넓은타입에서 좁은타입으로
 * 타입을 상황에 따라 좁히는 방법
 * */

type Person = {
  name: string;
  age: number;
};

function func(value: number | string | null | Date | Person) {
  if (typeof value === "number") {
    console.log(value.toFixed());
  } else if (typeof value === "string") {
    console.log(value.toUpperCase());
  }

  // 내장 객체의 경우 typeof 대신 instanceof 를 사용하자.
  else if (value instanceof Date) {
    console.log(value.getTime());
  }

  // 직접 type으로 정의한 instanceof를 사용할 수 없다.
  // type의 경우 value가 존재하고, property가 속해있는지 확인하는 in 키워드를 사용해야한다.
  else if (value && "age" in value) {
    console.log(`${value.name}은 ${value.age}살 입니다.`);
  }
}
