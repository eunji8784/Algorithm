# 💡 Stack
- `Stack` 클래스는 `Vector` 클래스를 상속받는 클래스로, 다양한 메소드를 제공합니다.
```
Stack<Integer> stack = new Stack<>();
```

## 📌 Stack 메소드
1. **push(E item)**
   - item을 스택의 맨 위에 추가합니다.
   - 매개변수: item - 스택에 추가할 항목
   - 반환값: item 파라미터로 전달된 객체입니다.

2. **pop()**
   - 스택의 맨 위에 있는 항목을 제거하고 그 항목을 반환합니다.
   - 반환값: 스택의 맨 위 항목

3. **peek()**
   - 스택의 맨 위에 있는 항목을 제거하지 않고 반환합니다.
   - 반환값: 스택의 맨 위 항목

4. **empty()**
   - 스택이 비어 있는지 확인합니다.
   - 반환값: 스택이 비어 있으면 true, 그렇지 않으면 false

5. **search(Object o)**
   - 스택에서 객체의 __1-based__ 위치를 반환합니다. 여기서 1-based 위치란, 스택의 맨 위 항목의 위치가 1이 되는 것입니다.
   - 매개변수: o - 스택에서 찾을 객체
   - 반환값: 객체가 있는 1-based 위치. 객체가 없다면 __-1.__
   ```java
    Stack<String> stack = new Stack<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");
    
    int position = stack.search("B");
    System.out.println(position); // 이 코드는 '2'를 출력합니다.
    ```

6. **contains(Object o)**
    - 해당 컬렉션에 특정 객체가 포함되어 있는지 확인합니다.
    - 객체가 컬렉션에 포함되어 있으면 `true`를 반환하고, 그렇지 않으면 `false`를 반환합니다.
    - `Stack` 클래스가 `Vector` 클래스를 상속받기 때문에 사용할 수 있는 메소드 입니다.
  
    ```java
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    
    boolean containsTwo = stack.contains(2);  // true
    boolean containsFour = stack.contains(4); // false
    ```

7. **set(int index, E element)**
   - 지정된 인덱스에 있는 원소를 지정된 요소로 교체합니다.
   - 교체되는 원래의 원소는 메소드의 반환값으로 반환됩니다.
   - `Stack` 클래스가 `Vector` 클래스를 상속받기 때문에 사용할 수 있는 메소드 입니다.
   - `index`: 교체하려는 원소의 인덱스.
   - `element`: 지정된 위치에 설정하려는 요소.

    ```java
    Stack<String> stack = new Stack<>();
    stack.push("apple");
    stack.push("banana");
    stack.push("cherry");
    
    // 인덱스 1의 원소 (banana)를 grape로 교체
    String replaced = stack.set(1, "grape");
    
    System.out.println(replaced);   // 출력: banana
    System.out.println(stack);      // 출력: [apple, grape, cherry]
    ```

8. **get(int index)**:
    - 주어진 인덱스에 있는 요소를 반환합니다.
    - 인덱스는 0-based입니다. 즉, 첫 번째 요소의 인덱스는 0, 두 번째 요소의 인덱스는 1이 됩니다.
    - 주어진 인덱스가 범위 밖이면 `ArrayIndexOutOfBoundsException`이 발생합니다.

    ```java
    Stack<String> stack = new Stack<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    String element = stack.get(1);
    System.out.println(element);  // B
    ```

9. **remove(int index)**:
    - 주어진 인덱스에 있는 요소를 스택에서 제거하고, 제거된 요소를 반환합니다.
    - 이 연산은 스택의 다른 요소의 위치를 변경할 수 있습니다. 따라서 스택의 특성(마지막에 들어온 요소가 먼저 나가는 LIFO)을 고려하지 않고 임의의 위치에서 요소를 제거하고자 할 때 사용됩니다.
    - 인덱스는 0-based입니다.
    - 주어진 인덱스가 범위 밖이면 `ArrayIndexOutOfBoundsException`이 발생합니다.

    ```java
    Stack<String> stack = new Stack<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    String removedElement = stack.remove(1);
    System.out.println(removedElement);  // B
    System.out.println(stack);  // [A, C]
    ```

### ▶️ 'Stack'은 `Vector` 클래스의 메소드도 사용할 수 있기 때문에, 스택이 제공하는 메소드 외에도 `Vector` 클래스의 메소드도 사용할 수 있습니다. 여기에는 `size()`, `isEmpty()`, `get(int index)`, `set(int index, E element)`, `remove(Object o)` 등 다양한 메소드가 포함됩니다.

참고로 `Stack` 클래스는 상당히 오래된 클래스로, 자바의 Collections Framework가 도입된 이후로는 `Deque` 인터페이스와 이를 구현한 `ArrayDeque` 클래스를 사용하는 것이 권장됩니다. `Deque` 인터페이스는 스택 뿐만 아니라 큐의 연산도 지원하며, 메소드 이름이 더 직관적이고 사용하기 편리합니다.
