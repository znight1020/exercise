/**
 * 서로소 유니온 타입
 * 교집합이 없는 타입들로만 만든 유니온 타입을 말한다. 예) string Type | number Type
 */

type Admin = {
  tag: "ADMIN";
  name: string;
  kickCount: number;
};

type Member = {
  tag: "MEMBER";
  name: string;
  point: number;
};

type Guest = {
  tag: "GUEST";
  name: string;
  visitCount: number;
};

type User = Admin | Member | Guest;

// 타입 좁히기 조건문만 보고 다른 개발자가 직관적으로 객체의 타입을 확인할 수 없다.
function loginV1(user: User) {
  if ("kickCount" in user) {
    console.log(`${user.name}님 현재까지 ${user.kickCount}명 강퇴했습니다.`);
  } else if ("point" in user) {
    console.log(`${user.name}님 현재까지 ${user.point}점을 모았습니다.`);
  } else {
    console.log(`${user.name}님 현재까지 ${user.visitCount}번 방문하셨습니다.`);
  }
}

// tag property 사용, string literal type으로 선언되어있다.
// 따라서, (ADMIB, MEMBER, GUEST) type 간 교집합은 존재할 수 없다. == 결국 User는 서로소 유니온 타입
function loginV2(user: User) {
  switch (user.tag) {
    case "ADMIN": {
      console.log(`${user.name}님 현재까지 ${user.kickCount}명 강퇴했습니다.`);
      break;
    }

    case "MEMBER": {
      console.log(`${user.name}님 현재까지 ${user.point}점을 모았습니다.`);
      break;
    }

    case "GUEST": {
      console.log(`${user.name}님 현재까지 ${user.visitCount}번 방문하셨습니다.`);
      break;
    }
  }
}

// 비동기 작업의 결과를 처리하는 객체
type Loading = {
  state: "LOADING";
};

type Failed = {
  state: "FAILED";
  error: {
    message: string;
  };
};

type Success = {
  state: "SUCCESS";
  response: {
    data: number | string;
  };
};

type AsyncTask = Loading | Failed | Success;

// loading -> 콘솔에 로딩중 출력
// 실패 -> 에러메시지를 출력
// 성공 -> 데이터를 출력
function processResult(task: AsyncTask) {
  switch (task.state) {
    case "LOADING": {
      console.log("로딩 중...");
      break;
    }
    case "FAILED": {
      console.log(task.error.message);
      break;
    }
    case "SUCCESS": {
      console.log(task.response.data);
      break;
    }
  }
}
