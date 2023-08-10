import java.util.*;
import java.io.*;

public class Main
{
    private static int N, M, minLevel = Integer.MAX_VALUE;
    private static ArrayList<Integer>[] adjLst;
    private static int[][] levelWeight;

    public static void main(String args[]) throws IOException
    {
        getInput();
        getMinLevel();
        getAnswer();
        System.out.println(minLevel);
    }

    private static void getMinLevel() {
        Set<Integer> set = new HashSet<>();
        boolean[] vst = new boolean[N + 1];
        dfs(1, set, 0, vst);
    }

    private static void dfs(int v, Set<Integer> set, int level, boolean[] vst) {
        if (level >= minLevel) {
            return;
        }

        if (v == N) {
            minLevel = Math.min(minLevel, level);
            return;
        }

        vst[v] = true;
        set.add(v);

        for (int next : adjLst[v]) {
            if (!vst[next]) {
                dfs(next, set, Math.max(level, levelWeight[v][next]), vst);
            }
        }

        vst[v] = false;
        set.remove(v);
    }

    private static void getAnswer() {
        minLevel++; // 'X레벨 이하 지원자는 오지 마시오'
        if (!isPrime()) {
            while (!isPrime()) {
                minLevel++;
            }
        }
        return;
    }

    private static boolean isPrime() {
        if (minLevel <= 1) {
            return false;
        }
        for (int i = 2; i * i <= minLevel; i++) {
            if (minLevel % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        levelWeight = new int[N + 1][N + 1];
        adjLst = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjLst[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            
            if (levelWeight[from][to] != 0) {
                level = Math.min(levelWeight[from][to], level);
            } else {
                adjLst[from].add(to);
                adjLst[to].add(from);
            }
            levelWeight[from][to] = level;
            levelWeight[to][from] = level;
        }

        br.close();
    }
}
