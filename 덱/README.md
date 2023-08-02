# 💡 덱 (Deque)
- "Double Ended Queue"의 약자로, 양쪽 끝에서 삽입과 삭제가 모두 가능한 자료구조.
- Java에서 Deque는 인터페이스로 제공되며, LinkedList 클래스와 ArrayDeque 클래스가 이를 구현함.

```java
Deque<Integer> deque = new LinkedList<>();
Deque<Integer> deque = new ArrayDeque<>();
```
## 메소드 종류
1. `add(E e)`: Deque의 끝에 요소를 추가. 요소를 추가하는 데 실패하면 (예: 공간 부족), `IllegalStateException`을 던짐.
2. `offer(E e)`: Deque의 끝에 요소를 추가. 요소를 추가하는 데 실패하면 `false`를 반환.
3. `remove()`: Deque의 처음에서 요소를 제거하고 반환. Deque가 비어 있는 경우 `NoSuchElementException`을 던짐.
4. `poll()`: Deque의 처음에서 요소를 제거하고 반환. Deque가 비어 있는 경우 `null`을 반환.
5. `element()`: Deque의 첫 번째 요소를 반환하지만 제거하지는 않음. Deque가 비어 있는 경우 `NoSuchElementException`을 던짐.
6. `peek()`: Deque의 첫 번째 요소를 반환하지만 제거하지는 않음. Deque가 비어 있는 경우 `null`을 반환.
7. `push(E e)`: Deque의 처음에 요소를 추가. 이는 스택 연산으로 간주.
8. `pop()`: Deque의 처음에서 요소를 제거하고 반환. 이는 스택 연산으로 간주. Deque가 비어 있는 경우 `NoSuchElementException`을 던짐.
9. `offerFirst(E e)`: Deque의 처음에 요소를 추가. 요소를 추가하는 데 실패하면 `false`를 반환.
10. `offerLast(E e)`: Deque의 끝에 요소를 추가. 요소를 추가하는 데 실패하면 `false`를 반환.
11. `pollFirst()`: Deque의 처음에서 요소를 제거하고 반환. Deque가 비어 있는 경우 `null`을 반환.
12. `pollLast()`: Deque의 끝에서 요소를 제거하고 반환. Deque가 비어 있는 경우 `null`을 반환.
13. `getFirst()`: Deque의 첫 번째 요소를 반환하지만 제거하지는 않음. Deque가 비어 있는 경우 `NoSuchElementException`을 던짐.
14. `getLast()`: Deque의 마지막 요소를 반환하지만 제거하지는 않음. Deque가 비어 있는 경우 `NoSuchElementException`을 던짐.
15. `peekFirst()`: Deque의 첫 번째 요소를 반환하지만 제거하지는 않음. Deque가 비어 있는 경우 `null`을 반환.
16. `peekLast()`: Deque의 마지막 요소를 반환하지만 제거하지는 않음. Deque가 비어 있는 경우 `null`을 반환.
17. `removeFirstOccurrence(Object o)`: Deque에서 첫 번째로 나타나는 지정된 요소를 제거. 요소가 성공적으로 제거되면 `true`를 반환하고, 그렇지 않으면 `false`를 반환.
18. `removeLastOccurrence(Object o)`: Deque에서 마지막으로 나타나는 지정된 요소를 제거. 요소가 성공적으로 제거되면 `true`를 반환하고, 그렇지 않으면 `false`를 반환.

- 위에 나열된 메소드 외에도 `Deque` 인터페이스는 `java.util.Collection` 인터페이스에서 상속받은 여러 가지 메소드를 포함함. 
- 이들 메소드에는 `clear()`, `contains(Object o)`, `iterator()`, `toArray()`, `remove(Object o)`, `size()` 등이 있음.
