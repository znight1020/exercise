// 다른 타입 내의 특정 property 추출

// ===== 객체 =====
interface Post {
  title: string;
  content: string;
  author: {
    id: number;
    name: string;
  };
}

// ===== 배열 =====
type PostArray = {
  title: string;
  content: string;
  author: {
    id: number;
    name: string;
  };
}[];

// author 라는 인덱스를 이용해서 특정 객체의 property에 접근한다.
// Post["author"]["id"] 와 같이 중첩 가능하다.
function printAuthorInfo(author: Post["author"]) {
  console.log(`${author.name}-${author.id}`);
}

const postInClass: Post = {
  title: "게시글 제목",
  content: "게시글 본문",
  author: {
    id: 1,
    name: "이현수",
  },
};

const postInArray: PostArray[number] = {
  title: "게시글 제목",
  content: "게시글 본문",
  author: {
    id: 1,
    name: "이현수",
  },
};

type Tup = [number, string, boolean];
