/**
 * 타입 단언
 * 위험한 문법: 컴파일러를 속이는 것과 같다.
 */

type Person = {
  name: string;
  age: number;
};

// let person: Person = {}; 와 같이 타입 추론에 의해 property 값을 생략하는 경우 컴파일 오류가 발생한다.

// 별칭(as)를 사용하여 Type Assertion(타입 단언)을 적용한다.
let person = {} as Person;
person.name = "이현수";
person.age = 27;

// 기존 초과 프로퍼티 검사로 인해 추가 속성을 선언할 수 없는 경우에도 사용할 수 있다.
let extendPerson: Person = {
  name: "이현수",
  age: 27,
  color: "blue",
} as Person;

/**
 * 타입 단언의 규칙
 * 값 as 단언 <- 단언식
 * A as B : A가 B의 super Type | sub Type
 */
let num1 = 10 as never; // 10은 never 의 super Type
let num2 = 10 as unknown; // 10은 never 의 sub Type

// let num3 = 10 as string; number, string의 집합은 서로소이다.

/**
 * const 단언 : 모든 property가 readonly 속성으로 변한다.
 */
let cat = {
  name: "야옹이",
  color: "yellow",
} as const;

/**
 * Non Null 선언
 */

type Post = {
  title: string;
  author?: string;
};

let post: Post = {
  title: "게시글",
  author: "이현수",
};

const len1 = post.author?.length; // '?': Optional Chaining(undefined 할당)
const len2: number = post.author!.length; // '!' : 해당 값이 non null(string) 단언
