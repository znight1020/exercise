/**
 * 사용자 정의 타입가드
 */

type Dog = {
  name: string;
  isBark: boolean;
};

type Cat = {
  name: string;
  isScratch: boolean;
};

type Animal = Dog | Cat;

// 타입스크립트는 사용자 정의 함수의 반환값을 가지고 타입 좁히기로 타입을 추론할 수 없다.
// 함수 자체를 타입가드 역할을 하게한다.
function isDog(animal: Animal): animal is Dog {
  return (animal as Dog).isBark !== undefined;
}
function isCat(animal: Animal): animal is Cat {
  return (animal as Cat).isScratch !== undefined;
}

function warning(animal: Animal) {
  if (isDog(animal)) {
    console.log("우리 개는 물어요.");
  } else if (isCat(animal)) {
    console.log("우리 고양이는 긁어요.");
  }
}
