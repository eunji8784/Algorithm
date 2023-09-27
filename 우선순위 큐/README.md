# 💡 PriorityQueue의 정렬 기준 재정의
- 주로 `Comparator`를 사용.
- Java에서는 여러 가지 방법으로 `Comparator`를 정의할 수 있다.

### 1. 익명 클래스 사용
익명 클래스를 사용하여 `Comparator`를 직접 구현할 수 있다.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2; // 오름차순
    }
});
```

### 2. 람다 표현식 사용
Java 8 이상에서는 람다 표현식을 사용하여 `Comparator`를 좀 더 간단하게 정의할 수 있다.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2); // 오름차순
```

### 3. Comparator.comparing 사용
`Comparator.comparing` 메서드를 사용하여 비교할 키를 정의할 수 있다.
```java
PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparing(String::length)); // 문자열 길이 순
```

### 4. 역순 정렬
`Collections.reverseOrder()`를 사용하면, 기본 정렬 순서를 반대로 할 수 있다.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
```

### 5. 사용자 정의 클래스에서 Comparator 정의
사용자 정의 클래스에서 `Comparator`를 정의하여 `PriorityQueue`의 정렬 기준을 재정의할 수 있다.
```java
class Pair {
    int x, y;
    // 생성자, 기타 메서드
}

PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.x == p2.x) return p1.y - p2.y; // x가 같으면 y를 기준으로 오름차순 정렬
        return p1.x - p2.x; // x를 기준으로 오름차순 정렬
    }
});
```
