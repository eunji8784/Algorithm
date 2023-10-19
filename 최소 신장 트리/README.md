# 💡 최소 신장 트리(Minimum Spanning Tree, MST)
- ```가중치```를 가진 ```무방향 그래프```에서 ```모든 노드를 연결```하면서 ```최소의 비용(가중치 합)```으로 그래프의 트리 구조를 만들고자 할 때 사용하는 알고리즘
<img width="762" alt="스크린샷 2023-10-19 오후 6 27 18" src="https://github.com/eunji8784/Algorithm/assets/70746467/34269fa1-5c83-4f86-b578-ce5d64c2b43d">

### 📌 최소 신장 트리의 특징
1. **모든 노드를 포함**: 최소 신장 트리는 원래 그래프의 모든 노드를 포함해야 합니다.
2. **최소 비용**: 모든 노드를 연결하는 간선들의 가중치 합이 최소여야 합니다.
3. **사이클이 없음**: 트리는 순환이 존재하지 않는 구조이기 때문에, 최소 신장 트리에도 사이클이 존재하지 않습니다.

### 📌 사용 예
- **통신 네트워크 설계**: 여러 도시를 연결하는 전화 또는 데이터 네트워크를 최소 비용으로 구축하려면 최소 신장 트리를 사용해야 합니다.
- **도로 네트워크 설계**: 여러 도시 또는 장소를 연결하는 도로 네트워크의 최소 비용 설계에 사용될 수 있습니다.
- **회로 설계**: 전자 회로에서 최소 연결 비용으로 요소들을 연결하기 위해 사용될 수 있습니다.

  크루스칼 알고리즘과 프림 알고리즘은 모두 최소 신장 트리를 찾는 알고리즘입니다. 그러나 그들의 작동 방식은 다르며, 특정 상황에서 한 알고리즘이 다른 것보다 유리할 수 있습니다. 각 알고리즘이 어떤 상황에서 더 유리한지 살펴보겠습니다.

## 1. 크루스칼 알고리즘

- **작동 원리**: 간선을 가중치 순으로 정렬한 후, 가장 작은 가중치부터 차례로 트리에 추가합니다. 이때, 사이클을 형성하는 간선은 추가하지 않습니다.
- **장점**: 
  - 간선의 수가 적은 경우 더 효율적입니다.
  - 유니온 파인드를 사용하여 사이클을 검사하므로, 이 알고리즘의 구현이 비교적 단순합니다.
- **단점**: 
  - 간선의 수가 많은 경우 간선을 정렬하는데 많은 시간이 소요될 수 있습니다.
- **적합한 상황**:
  - 간선의 수가 적거나, 간선의 가중치가 이미 정렬된 상태인 경우.
  - 그래프의 노드 수보다 간선의 수가 비교적 적은 경우.

## 2. 프림 알고리즘

- **작동 원리**: 시작 노드부터 최소 가중치 간선을 선택하여 트리를 확장해나갑니다. 이때 선택된 노드들을 우선순위 큐나 이진 힙에 저장하여, 다음에 연결될 노드를 효율적으로 찾습니다.
- **장점**:
  - 간선의 수가 많고 노드의 수가 적은 그래프에서 더 효율적입니다.
  - 노드 기반으로 작동하므로 노드의 수가 적을 때 더 빠릅니다.
- **단점**:
  - 우선순위 큐나 이진 힙을 사용해야 하므로, 구현이 크루스칼 알고리즘보다 조금 더 복잡할 수 있습니다.
- **적합한 상황**:
  - 그래프의 노드 수보다 간선의 수가 비교적 많은 경우.
  - 특정 시작점에서 MST를 구하는 경우.

## 📚 예시
```
주어진 그래프
노드: A, B, C, D, E
간선 및 가중치:
A-B: 1
A-C: 3
B-C: 4
B-D: 2
D-E: 5
```
__Kruskal's Algorithm 적용__
```
모든 간선을 가중치 순으로 정렬합니다: (A-B, B-D, A-C, B-C, D-E)
(A-B) 선택.
(B-D) 선택.
(A-C) 선택. 지금까지 트리에는 (A-B), (B-D), (A-C) 간선이 포함되어 있습니다.
(B-C)는 선택하지 않습니다. 왜냐하면 A-C-B 경로로 이미 연결되어 있기 때문에 이 간선을 추가하면 사이클이 형성됩니다.
(D-E) 선택.
최종 최소 신장 트리: 간선 (A-B), (B-D), (A-C), (D-E)와 노드 A, B, C, D, E로 구성됩니다.
```

## 📝 코드
```java
import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalMST {
    int[] parent;
    
    int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return false; 
        parent[y] = x;
        return true;
    }

    void kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges); 
        parent = new int[V];
        for (int i = 0; i < V; ++i)
            parent[i] = i;

        int mstWeight = 0;  
        for (Edge edge : edges) {
            if (union(edge.src, edge.dest)) { 
                System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
                mstWeight += edge.weight;
            }
        }

        System.out.println("Total MST weight: " + mstWeight);
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        KruskalMST kruskalMST = new KruskalMST();
        kruskalMST.kruskalMST(edges, 4); 
    }
}
```
