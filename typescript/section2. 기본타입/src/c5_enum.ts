// ========== enum(열거형) ========== js 지원 X
enum Role { // 숫자형
  ADMIN, // <- 초기값 : 0
  USER, // <- 1
  GUEST, // <- 2
}

enum Language { // string 형
  korean = "ko",
  english = "en",
}

const user1 = {
  name: "이현수",
  role: Role.ADMIN,
  language: Language.korean,
};

const user2 = {
  name: "홍길동",
  role: Role.USER,
  language: Language.english,
};

const user3 = {
  name: "아무개",
  role: Role.GUEST,
};

console.log(user1, user2, user3);
