## 💡 투 포인터(Two Pointer) vs 슬라이딩 윈도우(Sliding Window)
#### 1. 목적
- __투 포인터:__ 주로 합이나 차 등의 조건을 만족하는 ```원소 쌍```을 찾는 데 사용

- __슬라이딩 윈도우:__ ```연속적인 부분 집합```에 대한 정보 (예: 최대 합)를 찾는 데 사용

#### 2. 배열의 정렬
- __투 포인터:__ 주로 ```정렬된 배열```에서 사용

- __슬라이딩 윈도우:__ 정렬되지 않은 배열에서도 사용

#### 3.윈도우 크기
- __투 포인터:__ 두 포인터 사이의 거리는 ```가변적```

- __슬라이딩 윈도우:__ 윈도우 크기가 ```고정```될 수도, ```가변적```일 수도 있음
---
# :bulb: 투 포인터(Two Pointers)
- 배열 또는 리스트와 같은 ```연속적인 데이터 구조```에서 사용되는 알고리즘 기법.
- 주로 정렬된 데이터에 대해 ```두 원소의 합```이나 ```두 원소의 차``` 등을 대상으로 연산을 수행할 때 사용한다.

## 📌 투 포인터의 핵심 아이디어
- 배열의 ```시작점```과 ```끝점```에 포인터 두 개를 배치하고, 조건에 따라 포인터를 이동시키며 연산을 수행한다.
- 두 포인터는 조건에 따라 서로를 향해 움직이거나, 한 포인터만 움직이며 다양한 연산을 수행한다.

## 📌 투 포인터의 장점
- 전체 데이터를 탐색하는 것보다 연산을 최소화하여, 시간 효율성을 향상시킬 수 있다.
- 주로 ```O(N)```의 시간 복잡도로 문제를 해결할 수 있다.

## 📌 투 포인터 기법의 사용 예시
**문제**: 정렬된 배열에서 두 수의 합이 특정 값 X가 되는 모든 쌍을 찾아라.

**배열**: [1, 2, 3, 4, 5, 6, 7, 8, 9]  
**타겟 값 X**: 10

1. 시작 포인터(`start`)와 끝 포인터(`end`)를 설정한다.
   
```
start →
[1, 2, 3, 4, 5, 6, 7, 8, 9]
                         ← end
```

2. 현재 포인터들이 가리키는 원소의 합을 확인: 1 + 9 = 10, 합이 `X`와 동일하므로 `(1,9)` 쌍을 결과에 추가한다.

```
start →
[1, 2, 3, 4, 5, 6, 7, 8, 9]
                     ← end
```

3. `start` 포인터를 오른쪽으로 한 칸 이동한다. 다시 합을 계산: 2 + 9 = 11, 합이 `X`보다 크므로 `end` 포인터를 왼쪽으로 한 칸 이동한다.

```
     start →
[1, 2, 3, 4, 5, 6, 7, 8, 9]
                 ← end
```

4. 합을 다시 계산: 2 + 8 = 10, 합이 `X`와 동일하므로 `(2,8)` 쌍을 결과에 추가한다. 그 후 `start` 포인터를 오른쪽으로 한 칸 이동한다.

```
         start →
[1, 2, 3, 4, 5, 6, 7, 8, 9]
             ← end
```

5. 합을 계산: 3 + 8 = 11, 합이 `X`보다 크므로 `end` 포인터를 왼쪽으로 한 칸 이동한다.

```
         start →
[1, 2, 3, 4, 5, 6, 7, 8, 9]
         ← end
```

6. 합을 계산: 3 + 7 = 10, 합이 `X`와 동일하므로 `(3,7)` 쌍을 결과에 추가한다.

▶️ 이렇게 계속해서 start 포인터와 end 포인터의 위치를 조절하면서 타겟 값 X에 해당하는 쌍을 찾아가면 타겟 값 X=10에 대해 배열 내에서 가능한 모든 쌍은 (1,9), (2,8), (3,7), (4,6)이다. 

---
# :bulb: 슬라이딩 윈도우(Sliding Window)
- 배열 또는 리스트와 같은 ```연속적인 데이터 구조```에서 사용되는 알고리즘 기법.
- 이 기법은 주어진 데이터에서 ```일정한 크기의 구간```을 이동시키면서 (즉, "슬라이드"하면서) 연산을 수행하는 방법을 의미함.

## 📌 슬라이딩 윈도우의 핵심 아이디어
- ```연속적인 데이터```에서 최대, 최소, 합계 등을 빠르게 계산하기 위해 사용한다.
- ```연속적인 데이터```의 ```특정 크기의 구간```을 '윈도우'라고 보며, 이 윈도우를 데이터의 시작부터 끝까지 슬라이드하면서 필요한 연산을 수행한다.

## 📌 슬라이딩 윈도우의 장점
- 모든 구간을 처음부터 끝까지 다시 계산하지 않기 때문에 시간 효율성이 좋다.
- 주로 ```O(N)```의 시간 복잡도로 문제를 해결할 수 있다.

## 📌 슬라이딩 윈도우 기법의 사용 예시
- **고정 크기의 윈도우**: 윈도우 크기가 K인 경우, 배열의 연속된 K개의 요소의 합을 구할 때 사용한다. 윈도우를 오른쪽으로 한 칸씩 이동시키면서 합을 업데이트한다.

**예제**:
예를 들어, 다음과 같은 배열이 있다고 하자:
```
1 3 5 7 9 2 6 8 
```

고정된 윈도우 크기가 3이라고 가정하면, 슬라이딩 윈도우는 다음과 같이 동작한다.

```
[1 3 5] 7 9 2 6 8    -> 윈도우 내의 합: 9

1 [3 5 7] 9 2 6 8    -> 윈도우 내의 합: 15

1 3 [5 7 9] 2 6 8    -> 윈도우 내의 합: 21

1 3 5 [7 9 2] 6 8    -> 윈도우 내의 합: 18

1 3 5 7 [9 2 6] 8    -> 윈도우 내의 합: 17

1 3 5 7 9 [2 6 8]    -> 윈도우 내의 합: 16
```

위의 시퀀스는 윈도우가 배열을 "슬라이드"하면서 각 위치에서의 합을 보여준다. 이런 식으로, 슬라이딩 윈도우는 연속적인 부분 집합 또는 구간에 대한 정보를 효과적으로 얻을 수 있게 해준다.

## 📌 결론
슬라이딩 윈도우 기법은 연속된 데이터에 대한 연산을 효율적으로 수행하기 위한 알고리즘 기법이다. 이 기법을 이해하고 활용하면 많은 문제들을 효율적으로 해결할 수 있다.
