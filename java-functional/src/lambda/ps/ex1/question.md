# 문제 1. filter 함수 구현하기

## 요구 사항

1. 정수 리스트가 주어졌을 때, 특정 조건에 맞는 요소들만 뽑아내는 `filter` 함수를 직접 만들어보자.
2. `filter(List<Integer> list, MyPredicate predicate)` 형식의 정적 메서드를 하나 작성한다.
 - `MyPredicate`는 함수형 인터페이스이며, `boolean test(int value);` 같은 메서드를 가진다.
3. `main()`에서 예시로 다음과 같은 상황을 실습해보자.
 - 리스트: `[-3, -2, -1, 1, 2, 3, 5]`
 - 조건 1: 음수(negative)만 골라내기
 - 조건 2: 짝수(even)만 골라내기

## 예시 실행

```
원본 리스트: [-3, -2, -1, 1, 2, 3, 5]
음수: [-3, -2, -1]
짝수: [-2, 2]
```

---

# 문제 2. map 함수 구현하기

## 요구 사항

1. 문자열 리스트를 입력받아, 각 문자열을 어떤 방식으로 변환(map, mapping)할지 결정하는 함수(map)를 만들어보자.
2. `map(List<String> list, StringFunction func)` 형태로 구현한다.
    - `StringFunction`은 함수형 인터페이스이며, `String apply(String s);` 같은 메서드를 가진다.
3. `main()`에서 다음 변환 조건들을 테스트해보자.
    - 변환 1: 모든 문자열을 **대문자**로 변경
    - 변환 2: 문자열 앞 뒤에 `***`를 붙여서 반환 (예: `"hello"` → `"***hello***"`)

## 예시 실행

```
원본 리스트: [hello, java, lambda]
대문자 변환 결과: [HELLO, JAVA, LAMBDA]
특수문자 데코 결과: [***hello***, ***java***, ***lambda***]
```
