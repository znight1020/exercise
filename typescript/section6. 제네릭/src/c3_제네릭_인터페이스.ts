interface KeyPair<K, V> {
  key: K;
  value: V;
}

let keyPair1: KeyPair<string, number> = {
  key: "key",
  value: 0,
};

let keyPair2: KeyPair<boolean, string[]> = {
  key: true,
  value: ["1"],
};

// ========== 인덱스 시그니처 ==========
interface NumberMap {
  [key: string]: number;
}

let numberMap: NumberMap = {
  key1: 1,
  key2: 2,
};

// ========== 제네릭 인터페이스 && 인덱스 시그니처 ==========
interface Map<V> {
  [key: string]: V;
}

let stringMap: Map<string> = {
  key: "string",
};
let booleanMap: Map<boolean> = {
  key: true,
};

// ========== 제네릭 타입 별칭 ==========
type Map2<V> = {
  [key: string]: V;
};

let stringMap2: Map2<string> = {
  key: "hello",
};

/**
 * 제네릭 인터페이스 활용 예제
 * -> 유저 관리 프로그램 : 학생, 개발자 구분
 */

interface Student {
  type: "student";
  school: string;
}

interface Developer {
  type: "developer";
  skill: string;
}

interface User<T> {
  name: string;
  profile: T;
}

function goToSchool(user: User<Student>) {
  // 타입 좁히기 과정 없이 Student Type으로 지정된다.
  const school = user.profile.school;
  console.log(`${school}로 등교 완료`);
}

const developerUser: User<Developer> = {
  name: "이현수",
  profile: {
    type: "developer",
    skill: "ts",
  },
};

const studentUser: User<Student> = {
  name: "홍길동",
  profile: {
    type: "student",
    school: "냉장고",
  },
};
