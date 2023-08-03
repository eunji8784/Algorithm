# 💡 Comparable, Comparator
`Comparable`과 `Comparator` 모두 자바에서 객체를 정렬하는 데 사용되는 인터페이스입니다. 그러나 그 사용법과 적용 방식에는 몇 가지 중요한 차이점이 있습니다.

▶️ `Comparable`은 __클래스의 기본 정렬 방식을 정의__ 하는 반면, `Comparator`는 __원하는 정렬 방식을 별도로 정의__ 하게 해줍니다.
### 📌 Comparable
`Comparable` 인터페이스는 정렬의 '자연스러운' 순서를 정의하는 데 사용됩니다. `Comparable` 인터페이스를 구현하는 클래스는 `compareTo` 메소드를 오버라이드해야하며, 이 메소드는 객체 자신과 다른 객체를 비교하는 데 사용됩니다.

예를 들어, 다음과 같은 `Person` 클래스가 있다고 가정해봅시다:

```java
public class Person implements Comparable<Person> {
    private String name;

    // constructor, getters and setters

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.getName());
    }
}
```

여기서 `compareTo` 메소드는 두 사람의 이름을 비교하여 정렬 순서를 정의합니다. 이제 `Person` 객체들의 리스트를 다음과 같이 정렬할 수 있습니다:

```java
List<Person> people = new ArrayList<>();
// add people
Collections.sort(people);
```

### 📌 Comparator
`Comparator` 인터페이스는 `Comparable`이 아닌 객체를 정렬하거나, `Comparable` 객체를 다른 방식으로 정렬하는 데 사용됩니다. `Comparator` 인터페이스를 구현하는 클래스는 `compare` 메소드를 오버라이드해야하며, 이 메소드는 두 객체를 비교하는 데 사용됩니다.

`Person` 클래스를 다시 사용하여, 이번에는 나이(`age`)로 사람들을 정렬해보겠습니다:

```java
public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}
```

이제 `AgeComparator`를 사용하여 사람들의 리스트를 다음과 같이 정렬할 수 있습니다:

```java
List<Person> people = new ArrayList<>();
// add people
Collections.sort(people, new AgeComparator());
```

이 예제에서는 `Person` 클래스가 `Comparable` 인터페이스를 이미 구현하고 있지만, 이름 대신 나이로 사람들을 정렬하기를 원했기 때문에 `Comparator`를 사용했습니다.

따라서 `Comparable`은 객체의 '자연스러운' 정렬 방식을 정의하며, `Comparator`는 그 외의 다양한 정렬 방식을 정의하는 데 사용됩니다.

## 📍 Comparator를 사용하여 객체를 비교하는 여러 가지 방법
Java의 Arrays 클래스를 이용하여 숫자 배열을 정렬하는 예제를 들어 보겠습니다. 여기서는 [3, 1, 4, 1, 5, 9]라는 배열을 정렬해보겠습니다.

1. 익명 클래스를 이용한 방법:

   - 오름차순 정렬:

     ```java
     Integer[] arr = {3, 1, 4, 1, 5, 9};
     Arrays.sort(arr, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
             return o1.compareTo(o2);
         }
     });
     ```

   - 내림차순 정렬:

     ```java
     Integer[] arr = {3, 1, 4, 1, 5, 9};
     Arrays.sort(arr, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
             return o2.compareTo(o1);
         }
     });
     ```

2. 람다 표현식을 이용한 방법:

   - 오름차순 정렬:

     ```java
     Integer[] arr = {3, 1, 4, 1, 5, 9};
     Arrays.sort(arr, (o1, o2) -> o1.compareTo(o2));
     ```

   - 내림차순 정렬:

     ```java
     Integer[] arr = {3, 1, 4, 1, 5, 9};
     Arrays.sort(arr, (o1, o2) -> o2.compareTo(o1));
     ```

3. 메소드 참조를 이용한 방법:

   - 오름차순 정렬:

     ```java
     Integer[] arr = {3, 1, 4, 1, 5, 9};
     Arrays.sort(arr, Integer::compareTo);
     ```

   - 내림차순 정렬:

     ```java
     Integer[] arr = {3, 1, 4, 1, 5, 9};
     Arrays.sort(arr, Comparator.reverseOrder());
     ```

   이 경우, 이미 Comparator 클래스에서 제공하는 reverseOrder 메소드를 사용하여 내림차순 정렬을 수행했습니다.

각 방법마다 코드의 길이와 복잡성이 다르므로, 상황에 따라 적합한 방법을 선택하면 됩니다.
