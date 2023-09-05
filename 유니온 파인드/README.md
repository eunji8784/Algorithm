# 💡 유니온 파인드(Union-Find)
- 집합들의 합치기 연산(Union)과 특정 원소가 어느 집합에 포함되어 있는지를 찾는 연산(Find)을 지원하는 자료구조
- 주로 두 노드가 같은 그래프에 속하는지 판별할 때나, 그래프의 연결 요소를 확인할 때 사용

## 📌 기본 아이디어
1. **초기화**: 처음에 각 원소는 자기 자신만을 원소로 갖는 집합으로 초기화합니다. 이때, 각 원소는 자기 자신을 대표자로 합니다.
2. **Union**: 두 원소 a, b가 주어질 때, a가 속한 집합과 b가 속한 집합을 합칩니다.
3. **Find**: 특정 원소 x가 주어질 때, x가 속한 집합의 대표자를 반환합니다.

## 📌 구현 방법

1. **부모 배열**: 각 원소의 부모 또는 대표자를 저장할 배열 `parent[]`를 사용합니다.
   - 초기화: `parent[i] = i` (모든 원소는 자기 자신을 대표자로 갖습니다.)
   - Find 연산: 원소의 부모를 재귀적으로 탐색하며 최종 대표자를 찾습니다.
   - Union 연산: 두 원소의 대표자를 찾아, 하나를 다른 하나의 자식으로 만듭니다. (즉, 대표자를 바꿔줍니다.)

2. **경로 압축(Path Compression)**: Find 연산을 실행할 때, 부모를 찾아가는 경로에 포함된 모든 원소들이 직접 대표자를 가리키도록 부모를 갱신합니다. 이를 통해 후속 연산의 시간을 단축시킬 수 있습니다.

### 📚 예시

**Union-Find를 사용하는 경우**:
- 네트워크 연결 상태 확인
- 여러 개의 그래프가 주어졌을 때, 두 노드가 같은 그래프에 속하는지 확인
- 최소 신장 트리 생성 (Kruskal 알고리즘)

### ✏️ 코드 예제

```java
public class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            // 경로 압축
            return parent[x] = find(parent[x]);
        }
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
```

이런 방식으로 유니온 파인드는 효과적으로 여러 집합을 관리하며, 두 원소가 같은 집합에 속하는지 빠르게 판별할 수 있게 해줍니다.
