// ========== type alias ==========
type User = {
  id: number;
  name: string;
  nickname: string;
  birth: string;
  location?: string;
};

let userA: User = {
  id: 1,
  name: "이현수",
  nickname: "leehs",
  birth: "1999.10.20",
  location: "의정부시",
};

let userB: User = {
  id: 2,
  name: "홍길동",
  nickname: "honggd",
  birth: "1000.00.00",
};

// ========== index signature ========== key, value 의 규칙을 기준으로 객체의 타입 정의
type CountryCodes = {
  [key: string]: string;
};

type CountryNumberCodes = {
  [key: string]: number;
  Korea: number; // 반드시 Korea 라는 property 가 포함되어야 한다.
};

let countryCodes: CountryCodes = {
  Korea: "ko",
  UnitedState: "us",
  UnitedKingdom: "uk",
};

let countryNumberCodes: CountryNumberCodes = {
  Korea: 410,
  UnitedState: 840,
  UnitedKingdom: 826,
};
