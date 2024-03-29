# 💡 다이나믹 프로그래밍(Dynamic Programming, DP)
- ```복잡한 문제```를 ```더 작은 하위 문제로 나누어 해결```한 뒤, ```그 결과를 저장```하고 이를 ```활용```해 ```더 큰 문제를 효과적으로 해결```하는 알고리즘 설계 기법.
- 다이나믹 프로그래밍은 특히 ```최적화 문제```에서 효율적인 해결 방법을 제공함.
- 계산 시간을 크게 단축시키기 위해 ```메모리를 더 사용```하는 ```트레이드오프(trade-off)``` 방식을 취하고 있어 ```공간 복잡도가 증가하는 경우```가 존재함.
- 하지만 많은 문제들에서 이 기법을 통해 ```기하급수적으로 시간 복잡도를 줄일 수 있기 때문```에 매우 중요한 알고리즘 설계 기법 중 하나.

## 📌 다이나믹 프로그래밍의 주요 특징

1. __중복된 계산:__ 문제를 해결하는 과정에서 동일한 계산이나 연산이 반복적으로 필요한 경우.
2. __최적 부분 구조:__ 큰 문제를 작은 문제로 나누어 해결할 수 있으며, 작은 문제의 해답을 조합하여 원래의 문제를 해결할 수 있는 구조.
3. __메모이제이션:__ 작은 문제들의 결과를 저장하고 이를 활용하여 큰 문제를 해결하는 것이 가능한 구조.

## 📌 다이나믹 프로그래밍을 적용하기 위한 일반적인 절차

1. **문제 정의**: 주어진 문제를 재귀적으로 정의.

2. **하위 문제의 해결**: 작은 하위 문제부터 시작하여 결과를 저장하고 이를 활용하여 더 큰 하위 문제를 해결.

3. **저장(Memoization)**: 하위 문제의 결과를 저장하고, 필요할 때 이를 다시 사용하여 중복 계산을 방지.

4. **점화식 구성**: 주어진 문제에 대한 재귀적인 해결 방법을 나타내는 수학적 표현인 점화식을 구성.

5. **최종 해결**: 작은 하위 문제들의 해를 조합하여 주어진 문제의 해를 구함.

### 📚 문제 유형
### [0-1 배낭 문제(Knapsack Problem)](0-1%20Knapsack%20Problem.md)
---
# 💡 비트마스킹
- ```이진수(비트) 연산```을 활용하여 정수를 이용해 여러 개의 다른 값을 표현하거나 조작하는 기술.
- 이를 통해 배열이나 리스트를 사용하지 않고도 정보를 저장, 조회, 수정할 수 있다.

### 📌 비트 연산
- **AND 연산 `&`**: 두 비트가 모두 1이면 1, 아니면 0
- **OR 연산 `|`**: 두 비트 중 하나라도 1이면 1, 아니면 0
- **XOR 연산 `^`**: 두 비트가 서로 다르면 1, 같으면 0
- **NOT 연산 `~`**: 비트를 반전시킴 (1을 0으로, 0을 1로)
- **Shift 연산 `<<`, `>>`**: 비트를 왼쪽 또는 오른쪽으로 이동시킴

### 📚 예제: 비트마스킹 사용
- **세트 표현**
  - 예를 들어, 세트 {1, 3, 4}를 `00011010`로 표현할 수 있다.
  
- **세트에 원소 추가**
  - ```OR 연산```과 ```Shift 연산```을 이용하여 세트에 ```원소를 추가```할 수 있다.
  ```java
  int set = 0; // 00000000
  set |= (1 << 1); // 1을 세트에 추가: 00000010
  set |= (1 << 3); // 3을 세트에 추가: 00001010
  set |= (1 << 4); // 4를 세트에 추가: 00011010
  ```

- **세트에서 원소 제거**
  - ```AND 연산과 NOT 연산```을 이용하여 세트에서 ```원소를 제거```할 수 있다.
  ```java
  set &= ~(1 << 3); // 3을 세트에서 제거: 00010010
  ```

- **세트의 원소 확인**
  - ```AND 연산```을 이용하여 세트에 특정 원소가 있는지 확인할 수 있다.
  ```java
  if ((set & (1 << 1)) != 0) {
      // 세트에 1이 존재함
  }
  ```

- **세트 순회**
  - 세트의 모든 원소에 대해 반복할 수 있다.
  ```java
  for (int i = 0; i < 32; i++) {
      if ((set & (1 << i)) != 0) {
          // i는 현재 세트의 원소
      }
  }
  ```

### 📚 비트마스킹 활용
- 비트마스킹을 사용하는 주된 이유는 **효율성**.
- 비트마스킹을 사용하면 여러 가지 이점이 있다:
### 1. **공간 효율성:**
비트마스킹을 사용하면, 배열이나 세트 등을 사용하지 않고도, 하나의 정수 변수만을 사용하여 여러 개의 정보를 저장할 수 있다. 각 비트는 0 또는 1의 값만을 가질 수 있기 때문에, 별도의 자료구조 없이도 32개나 64개의 불리언 값(Boolean)을 표현할 수 있다.

### 2. **시간 효율성:**
비트 연산은 CPU 레벨에서 지원되므로 매우 빠르다. 따라서, 비트마스킹을 사용하면 배열이나 리스트 등의 자료구조를 사용하는 것에 비해 훨씬 빠르게 데이터를 처리할 수 있다.

### 3. **코드의 간결성:**
비트 연산을 통해 다양한 집합 연산을 간결하게 표현할 수 있다. 이는 코드의 길이를 줄이고 가독성을 향상시킬 수 있다.

### 주로 사용하는 경우:
1. **부분집합 표현:**
어떤 집합의 모든 부분집합을 나타내고 싶을 때 주로 사용된다. 예를 들어, {1, 2, 3}의 모든 부분집합을 비트마스킹으로 나타낼 수 있다.

2. **동적 계획법의 상태 표현:**
동적 계획법에서 문제의 상태를 표현할 때 매우 유용하다. 예를 들어, 외판원 순회 문제에서 어떤 도시들을 방문했는지를 비트마스킹으로 표현할 수 있어, 상태 전이를 간단하게 할 수 있다.

3. **빠른 집합 연산:**
교집합, 합집합, 차집합 등의 집합 연산을 빠르게 수행해야 할 때 사용된다. 비트 연산자를 이용하면 이러한 집합 연산을 빠르고 간단하게 수행할 수 있다.

### 예시
10개의 원소 중에서 몇 개의 원소를 선택했는지를 표현하고자 할 때, 각 원소를 선택했는지 안 했는지를 표현하는 불리언 배열을 사용하면 10개의 공간이 필요하다. 하지만 비트마스킹을 사용하면, 하나의 정수로 10개의 원소의 선택 여부를 모두 표현할 수 있어 공간을 효율적으로 사용할 수 있다.
