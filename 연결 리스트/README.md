# 💡 LinkedList
- 자바의 `java.util` 패키지에 있는 컬렉션 프레임워크의 일부.
- 내부적으로 ```이중 연결 리스트(doubly linked list)```로 구현되어 있으며, 각 요소가 이전 요소와 다음 요소를 참조하는 구조.

### 1. 임의 접근 성능
`LinkedList`는 임의 접근(random access)에 대해 O(n)의 시간 복잡도를 가집니다. 이는 배열 기반의 `ArrayList`와 비교했을 때 불리한 측면인데, 배열은 인덱스를 통해 O(1)의 시간에 임의 접근이 가능하지만, `LinkedList`는 특정 인덱스에 접근하기 위해서는 처음이나 끝에서 해당 위치까지 순차적으로 이동해야 합니다.

### 2. 삽입 및 삭제 성능
`LinkedList`는 리스트의 시작, 끝, 혹은 중간 어느 위치에서든 요소의 삽입과 삭제를 O(1)의 시간 복잡도로 수행할 수 있습니다. 단, 중간 위치에서의 삽입/삭제를 하기 위해서는 해당 위치를 먼저 찾아야 하므로, 이 경우 전체적인 작업 시간은 O(n)이 됩니다.

### 3. 메모리 사용
각 `LinkedList` 요소는 데이터와 함께 두 개의 참조(이전 요소와 다음 요소를 가리키는 포인터)를 유지합니다. 이로 인해 `ArrayList`에 비해 추가적인 메모리 공간을 소비합니다.

### 4. List 인터페이스 구현
`LinkedList`는 `List` 인터페이스를 구현하므로, 리스트 관련 메소드(`add`, `get`, `remove`, `indexOf` 등)를 모두 사용할 수 있습니다. 또한 `Deque` 인터페이스도 구현하여 큐, 데크 또는 스택으로 사용할 수 있습니다.

### 사용 사례
`LinkedList`는 큐, 데크, 스택의 구현체로 사용되거나, 요소의 삽입과 삭제가 빈번하게 발생하고 임의 접근이 적은 경우에 적합합니다. 대규모 데이터 처리에서는 `ArrayList`와 비교해 성능이 떨어질 수 있으므로 사용 상황에 따라 적절한 자료구조 선택이 중요합니다.

### 예시
```java
LinkedList<String> linkedList = new LinkedList<>();
linkedList.add("A");
linkedList.add("B");
linkedList.addFirst("C");
linkedList.addLast("D");
linkedList.remove("B");
```

`LinkedList`는 자바에서 제공하는 표준 라이브러리이므로 별도의 구현 없이 위와 같이 사용할 수 있습니다.  

Java의 `LinkedList` 클래스는 `List` 인터페이스와 `Deque` 인터페이스를 모두 구현하고 있어, 다양한 메소드를 제공합니다. 다음은 `LinkedList`에서 주로 사용되는 몇 가지 메소드들입니다:

### 📚 기본 List 메소드들

1. **add(E e)**: 리스트의 끝에 요소를 추가합니다.
2. **add(int index, E element)**: 지정된 위치에 요소를 추가합니다.
3. **addAll(Collection<? extends E> c)**: 지정된 컬렉션의 모든 요소를 리스트의 끝에 추가합니다.
4. **get(int index)**: 지정된 위치에 있는 요소를 반환합니다.
5. **remove(int index)**: 지정된 위치의 요소를 제거하고 그 요소를 반환합니다.
6. **remove(Object o)**: 지정된 요소를 처음 만나는 위치에서 제거합니다.
7. **size()**: 리스트의 요소 개수를 반환합니다.
8. **clear()**: 리스트의 모든 요소를 제거합니다.
9. **contains(Object o)**: 리스트가 지정된 요소를 포함하고 있는지 여부를 반환합니다.
10. **isEmpty()**: 리스트가 비어 있는지 여부를 반환합니다.
11. **iterator()**: 리스트의 요소에 대한 순차적인 접근을 위한 Iterator를 반환합니다.

### Deque 인터페이스 메소드들

1. **addFirst(E e)**: 리스트의 시작 부분에 요소를 추가합니다.
2. **addLast(E e)**: 리스트의 끝 부분에 요소를 추가합니다.
3. **offerFirst(E e)**: 리스트의 시작 부분에 요소를 추가하고 성공하면 true를 반환합니다.
4. **offerLast(E e)**: 리스트의 끝 부분에 요소를 추가하고 성공하면 true를 반환합니다.
5. **removeFirst()**: 리스트의 첫 번째 요소를 제거하고 반환합니다.
6. **removeLast()**: 리스트의 마지막 요소를 제거하고 반환합니다.
7. **pollFirst()**: 리스트의 첫 번째 요소를 제거하고 반환하거나, 리스트가 비어있으면 null을 반환합니다.
8. **pollLast()**: 리스트의 마지막 요소를 제거하고 반환하거나, 리스트가 비어있으면 null을 반환합니다.
9. **getFirst()**: 리스트의 첫 번째 요소를 반환합니다.
10. **getLast()**: 리스트의 마지막 요소를 반환합니다.
11. **peekFirst()**: 리스트의 첫 번째 요소를 반환하거나, 리스트가 비어있으면 null을 반환합니다.
12. **peekLast()**: 리스트의 마지막 요소를 반환하거나, 리스트가 비어있으면 null을 반환합니다.

### 예시
```java
LinkedList<String> linkedList = new LinkedList<>();
linkedList.add("Apple");
linkedList.addFirst("Orange");
linkedList.addLast("Banana");
String first = linkedList.getFirst();
String last = linkedList.getLast();
```

`LinkedList`는 이중 연결 리스트로 구현되어 있어, 양쪽 끝에 대한 삽입 및 삭제 작업이 효율적입니다. 하지만 중간 요소에 대한 접근은 순차적으로 이루어지므로 O(n)의 시간 복잡도를 가집니다.
