/**
 * Pick<T, K>
 * -> 객체 타입으로부터 특정 property만 선택하여 새로운 객체 타입을 만들어주는 타입
 */

interface Post {
  title: string;
  tags: string[];
  content: string;
  thumbnailURL?: string;
}

type Pick<T, K extends keyof T> = {
  [key in K]: T[key];
};

const legacyPost: Pick<Post, "title" | "content"> = {
  title: "옛날 글",
  content: "옛날 컨텐츠",
};

/**
 * Omit<T, K>
 * -> 객체 타입으로부터 특정 property를 제외한 나머지 property로 새로운 객체 타입을 만들어주는 타입
 */
type Omit<T, K extends keyof T> = {
  [key in Exclude<keyof T, K>]: T[key];
};

const noTitlePost: Omit<Post, "title"> = {
  tags: ["ts"],
  content: "제목 없는 글",
  thumbnailURL: "www.example.com",
};

/**
 * Record<K, T>
 * -> 특정 property K와 value T로 이루어진 객체 타입을 만들어주는 타입
 */

// 중복 property가 다수 존재한다.
type ThumbnailLegacy = {
  large: {
    url: string;
  };
  medium: {
    url: string;
  };
  small: {
    url: string;
  };
  watch: {
    url: string;
  };
};

type Thumbnail = Record<"large" | "medium" | "small" | "watch", { url: string; size: number }>;
