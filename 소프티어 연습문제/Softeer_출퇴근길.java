import java.io.*;
import java.util.*;

// HSAT 6회 정기 코딩 인증평가 기출 
public class Main {
    private static ArrayList<Integer>[] forwardGraph, reverseGraph;
    private static int n, m, s, t;

    public static void main(String[] args) throws IOException {

        getInput();

        Set<Integer> pathToWork = getIntersection(s, t);
        Set<Integer> pathToHome = getIntersection(t, s);

        pathToWork.retainAll(pathToHome);

        int answer = pathToWork.size();
        if (pathToWork.contains(s)) answer--;
        if (pathToWork.contains(t)) answer--;

        System.out.println(pathToWork.size());
    }

    private static Set<Integer> getIntersection(int start, int target) {
        Set<Integer> forward = new HashSet<>();
        Set<Integer> reverse = new HashSet<>();
        dfs(start, target, forwardGraph, forward, new boolean[n + 1]);
        dfs(target, 0, reverseGraph, reverse, new boolean[n + 1]);
        forward.retainAll(reverse);
        return forward;
    }

    private static void dfs(int node, int target, ArrayList<Integer>[] graph, Set<Integer> set, boolean[] visited) {
        if (target != 0 && node == target) return;
        visited[node] = true;
        set.add(node);
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, target, graph, set, visited);
            }
        }
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        initializeGraphs();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            forwardGraph[from].add(to);
            reverseGraph[to].add(from);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
    }

    private static void initializeGraphs() {
        forwardGraph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            forwardGraph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
    }
}
