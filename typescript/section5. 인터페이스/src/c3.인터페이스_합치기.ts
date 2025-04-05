/**
 * 인터페이스 합치기(선언 합침)
 * 동일한 이름을 가진 interface는 합쳐진다.
 */
interface Person {
  name: string;
}

interface Person {
  age: number;
}
