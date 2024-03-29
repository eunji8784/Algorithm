# 💡 다익스트라 알고리즘
- 그래프에서 ```한 시작점에서 다른 모든 정점들까지의 최단 경로```를 찾는 알고리즘.
- 가중치가 있는 그래프에서 사용되며, 가중치가 없는 그래프에서는 BFS (너비 우선 탐색)를 사용하는 것이 더 효율적일 수 있다.
- 양의 가중치를 가진 그래프에서만 잘 작동.
  -> 음의 가중치를 가진 간선이 있는 경우 벨만-포드 알고리즘과 같은 다른 방법을 사용.

## 📌 다익스트라 알고리즘의 기본적인 동작 원리

1. 시작 정점을 설정한다.
2. 모든 정점들의 최단 거리 값을 무한대로 초기화하고, 시작 정점의 최단 거리 값을 0으로 초기화한다.
3. 현재 정점에서 아직 방문하지 않은 인접한 정점들의 거리 값을 업데이트한다. 즉, 현재 정점을 거쳐 인접한 정점에 도달하는 거리가 기존에 알고 있던 거리보다 더 짧을 경우 값을 업데이트한다.
4. 아직 방문하지 않은 정점 중에서 최단 거리가 가장 짧은 정점을 선택한다.
5. 해당 정점을 방문하고 3번으로 돌아가 반복한다.
6. 그래프의 모든 정점을 방문할 때까지 위의 과정을 반복한다.

▶️ ```우선순위 큐```를 사용하면 알고리즘의 효율성을 크게 높일 수 있다. 우선순위 큐가 항상 최단 거리가 가장 짧은 정점을 먼저 처리하기 때문.

### ex)

    A - 4 - B
    |       |
    2       3
    |       |
    C - 1 - D

▶️ 위 그래프에서 각 간선의 숫자는 해당 간선을 통과하는 데 필요한 비용(가중치)를 나타낸다. 시작점을 A로 하여 다른 노드들까지의 최단 경로를 구한다.

1. **초기화**:
    - A: 0 (시작점이기 때문에 비용은 0)
    - B: 무한대
    - C: 무한대
    - D: 무한대

2. **A에서 인접한 노드들의 거리 업데이트**:
    - A → B: 4 (기존 B까지의 거리 무한대보다 4가 작으므로 업데이트)
    - A → C: 2 (기존 C까지의 거리 무한대보다 2가 작으므로 업데이트)
    - 상태: A(0), B(4), C(2), D(무한대)

3. **방문하지 않은 정점 중에서 최단 거리가 가장 짧은 정점을 선택**:
    - C (2로 최단 거리)

4. **C에서 인접한 노드들의 거리 업데이트**:
    - C → A: 이미 방문한 노드이므로 패스
    - C → D: C에서 D까지의 거리는 1. A를 통해 C로 온 비용은 2이므로 총 3. 기존의 D까지의 거리는 무한대였으므로 3으로 업데이트.
    - 상태: A(0), B(4), C(2), D(3)

5. **다시 방문하지 않은 정점 중에서 최단 거리가 가장 짧은 정점을 선택**:
    - D (3으로 최단 거리)

6. **D에서 인접한 노드들의 거리 업데이트**:
    - D → C: 이미 방문한 노드이므로 패스
    - D → B: D에서 B까지의 거리는 3. C를 통해 D로 온 비용은 3이므로 총 6. 기존의 B까지의 거리는 4였으므로 업데이트하지 않음.
    - 상태: A(0), B(4), C(2), D(3)

7. **모든 노드를 방문했으므로 알고리즘이 종료**.

결과적으로 A에서 각 노드까지의 최단 거리는:
- A: 0
- B: 4
- C: 2
- D: 3

## 📌 다익스트라 알고리즘을 사용하기 위한 주요 조건과 제약 사항

1. **가중치가 있는 그래프**: 다익스트라 알고리즘은 가중치가 있는 그래프에서 사용된다. 간선마다 특정한 가중치(비용)가 있어야 한다.

2. **출발 노드 지정**: 다익스트라 알고리즘은 특정 시작 노드에서 다른 모든 노드로의 최단 경로를 찾는다.

3. **양의 가중치**: 다익스트라 알고리즘은 모든 가중치가 양수일 때만 제대로 작동한다. 음의 가중치가 있는 경우, 벨만-포드 알고리즘과 같은 다른 알고리즘을 사용해야 한다.

4. **단일 출발점**: 다익스트라는 단일 시작점에서 그래프의 모든 다른 정점으로의 최단 경로를 찾는다. 모든 노드 쌍 사이의 최단 경로를 찾고자 한다면, 플로이드-워셜 알고리즘을 사용해야 한다.

5. **방향성**: 다익스트라 알고리즘은 방향성이 있는 그래프(유향 그래프)와 방향성이 없는 그래프(무향 그래프) 모두에 적용될 수 있디.

6. **순환이 없어야 하며, 존재하는 경우 무시**: 다익스트라는 순환이 존재하는 그래프에서는 제대로 동작하지 않을 수 있다. 그러나 실제 구현 시, 순환이 존재하더라도 그것을 무시하고 경로를 찾는 것이 가능하다.

▶️ 이러한 제약사항들을 고려하면서 문제의 상황과 그래프의 특성을 잘 이해해야 다익스트라 알고리즘을 효과적으로 사용할 수 있다.
