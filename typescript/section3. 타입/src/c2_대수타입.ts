/**
 * 대수 타입
 * -> 여러개의 타입을 합성해서 새롭게 만들어낸 타입
 * -> 합칩합 타입과 교집합 타입 존재
 */

/**
 * 1. 합집합 - Union Type
 */

let a: string | number;
a = 1;
a = "string";

let arr: (number | string | boolean)[] = [1, "hello", true];

type Dog = {
  name: string;
  color: string;
};

type Person = {
  name: string;
  language: string;
};

type UnionC = Dog | Person;
let union1: UnionC = {
  name: "방울이",
  color: "white",
};

let union2: UnionC = {
  name: "이현수",
  language: "ko",
};

let union3: UnionC = {
  name: "이현수",
  color: "blue",
  language: "ko",
};

/**
 * 2. 교집합 타입 - Intersection 타입 : 모든 property가 포함되어야 한다.
 */

let variable: number & string; // never 타입

type IntersectC = Dog & Person;
let intersect1: IntersectC = {
  name: "이현수",
  color: "blue",
  language: "ko",
};
