import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> map = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            List<Integer> lst = map.computeIfAbsent(genres[i], value -> new ArrayList<>());
            lst.add(i);
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key), (o1, o2) -> {
                if (plays[o1] == plays[o2]) return o1 - o2;
                return plays[o2] - plays[o1];
            });
        }
        
        List<String> keyList = new ArrayList<>(sum.keySet());
        Collections.sort(keyList, (o1, o2) -> sum.get(o2) - sum.get(o1));
        
        List<Integer> answerList = new ArrayList<>();
        
        for (String key : keyList) {
            List<Integer> lst = map.get(key);
            answerList.add(lst.get(0));
            if (lst.size() > 1) {
                answerList.add(lst.get(1));
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (1.13ms, 74.1MB)
// 테스트 2 〉	통과 (1.14ms, 82.4MB)
// 테스트 3 〉	통과 (1.76ms, 76.4MB)
// 테스트 4 〉	통과 (1.33ms, 76.7MB)
// 테스트 5 〉	통과 (2.95ms, 76MB)
// 테스트 6 〉	통과 (1.43ms, 73MB)
// 테스트 7 〉	통과 (2.01ms, 83.6MB)
// 테스트 8 〉	통과 (1.32ms, 77.1MB)
// 테스트 9 〉	통과 (1.39ms, 75.5MB)
// 테스트 10 〉	통과 (2.06ms, 77.6MB)
// 테스트 11 〉	통과 (1.23ms, 88.8MB)
// 테스트 12 〉	통과 (2.08ms, 71.7MB)
// 테스트 13 〉	통과 (1.85ms, 75.5MB)
// 테스트 14 〉	통과 (1.47ms, 76.8MB)
// 테스트 15 〉	통과 (1.90ms, 77.8MB)
