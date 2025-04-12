/**
 * Partial<T>
 * -> 특정 객체 타입의 모든 property를 선택적 property로 바꿔주는 타입
 */
interface Post {
  title: string;
  tags: string[];
  content: string;
  thumbnailURL?: string;
}

type Partial<T> = {
  [key in keyof T]?: T[key];
};

const draft: Partial<Post> = {
  title: "제목1",
  content: "초안...",
};

/**
 * Required<T>
 * -> 특정 객체 타입의 모든 property를 필수 property로 바꿔주는 타입
 */
type Required<T> = {
  [key in keyof T]-?: T[key];
};

const withThumbnailPost: Required<Post> = {
  title: "제목2",
  tags: ["ts"],
  content: "",
  thumbnailURL: "www.example.com",
};

/**
 * Readonly<T>
 * -> 특정 객체 타입에서 모든 property를 읽기 전용으로 만들어주는 타입
 */
type ReadOnly<T> = {
  readonly [key in keyof T]: T[key];
};

const readonlyPost: Readonly<Post> = {
  title: "제목3",
  tags: ["ts"],
  content: "",
};
