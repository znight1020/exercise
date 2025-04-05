const promise = new Promise<number>((resolve, reject) => {
  setTimeout(() => {
    // resolve(20);
    reject("작업 실패");
  }, 3000);
});

// 비동기 실행 결과의 타입 추론을 자동으로 진행하지 않는다.
// number type인 20을 인자로 넘겨주었지만, then의 response는 unknown type으로 넘어온다.
// 인스턴스 생성 시 Promise의 Type을 number로 지정해주면 된다.
promise.then((response) => {
  console.log(response * 10);
});

promise.catch((err) => {
  if (typeof err === "string") {
    console.log(err);
  }
});

/**
 * 프로미스를 반환하는 함수의 타입을 정의
 */

interface Post {
  id: number;
  title: string;
  content: string;
}

function fetchPost(): Promise<Post> {
  return new Promise((resolve, reject) => {
    resolve({
      id: 1,
      title: "post title",
      content: "content1",
    });
  });
}

const req = fetchPost();

req.then((post) => {
  console.log(post.id);
});
