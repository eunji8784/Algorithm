import java.util.*;

class Solution {
    private static Map<String, List<City>> graph;
    
    private static class City implements Comparable<City> {
        String name;
        boolean vst;
        
        public City(String name, boolean vst) {
            this.name = name;
            this.vst = vst;
        }
        
        @Override
        public int compareTo(City o) {
            return this.name.compareTo(o.name);
        }
    }
    
    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        
        for (String[] ticket : tickets) {
            List<City> lst = graph.computeIfAbsent(ticket[0], value -> new ArrayList<>());
            lst.add(new City(ticket[1], false));
        }
        
        for (String name : graph.keySet()) {
            Collections.sort(graph.get(name));
        }
        
        List<String> answerList = new ArrayList<>();
        dfs("ICN", answerList, tickets.length + 1);
        
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private static boolean dfs(String now, List<String> answerList, int length) {
        answerList.add(now);
        if (answerList.size() == length) return true;

        if (graph.get(now) != null) {
            for (City city : graph.get(now)) {
                if (!city.vst) {
                    city.vst = true;
                    if (dfs(city.name, answerList, length)) return true; 
                    city.vst = false; 
                    answerList.remove(answerList.size() - 1);
                }
            }
        }
        
        return false;
    }
}

// 테스트 1 〉	통과 (0.93ms, 80.4MB)
// 테스트 2 〉	통과 (1.01ms, 80MB)
// 테스트 3 〉	통과 (0.63ms, 73.8MB)
// 테스트 4 〉	통과 (0.81ms, 73.8MB)
