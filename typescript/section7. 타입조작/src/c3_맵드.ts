interface User {
  id: number;
  name: string;
  age: number;
}

type PartialUser = {
  [key in keyof User]?: User[key];
};

type BooleanUser = {
  [key in keyof User]: boolean;
};

type ReadonlyUser = {
  readonly [key in keyof User]: User[key];
};

function fetchUser(): User {
  return {
    id: 1,
    name: "이현수",
    age: 27,
  };
}

function updateUser(user: PartialUser) {
  // 사용자 정보 수정...
}

updateUser({
  age: 25,
});
