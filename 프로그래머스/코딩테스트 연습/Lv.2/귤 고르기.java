import java.util.*;

// HashMap 사용 풀이
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int type : tangerine) {
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> map.get(o2) - map.get(o1));
        
        for (Integer key : keyList) {
            k -= map.get(key);
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (17.94ms, 94.4MB)
// 테스트 2 〉	통과 (38.60ms, 96.6MB)
// 테스트 3 〉	통과 (31.45ms, 96.4MB)
// 테스트 4 〉	통과 (35.91ms, 90.7MB)
// 테스트 5 〉	통과 (28.08ms, 86.6MB)
// 테스트 6 〉	통과 (24.66ms, 84.7MB)
// 테스트 7 〉	통과 (23.57ms, 91.3MB)
// 테스트 8 〉	통과 (28.93ms, 78.1MB)
// 테스트 9 〉	통과 (37.64ms, 80.2MB)
// 테스트 10 〉 통과 (40.76ms, 94.2MB)
// 테스트 11 〉 통과 (1.30ms, 69.8MB)
// 테스트 12 〉 통과 (0.91ms, 71.5MB)
// 테스트 13 〉 통과 (1.40ms, 77.7MB)
// 테스트 14 〉 통과 (0.81ms, 73.7MB)
// 테스트 15 〉 통과 (0.88ms, 71.5MB)
// 테스트 16 〉 통과 (6.48ms, 72.4MB)
// 테스트 17 〉 통과 (1.02ms, 77.9MB)
// 테스트 18 〉 통과 (0.86ms, 67.2MB)
// 테스트 19 〉 통과 (0.79ms, 87.4MB)
// 테스트 20 〉 통과 (0.75ms, 85.1MB)
// 테스트 21 〉 통과 (3.60ms, 72.2MB)
// 테스트 22 〉 통과 (17.03ms, 73.6MB)
// 테스트 23 〉 통과 (5.30ms, 80.7MB)
// 테스트 24 〉 통과 (2.93ms, 70.8MB)
// 테스트 25 〉 통과 (9.81ms, 76.6MB)
// 테스트 26 〉 통과 (13.32ms, 82.1MB)
// 테스트 27 〉 통과 (65.93ms, 88.6MB)
// 테스트 28 〉 통과 (44.07ms, 102MB)
// 테스트 29 〉 통과 (56.74ms, 106MB)
// 테스트 30 〉 통과 (66.42ms, 103MB)
// 테스트 31 〉 통과 (26.05ms, 85.3MB)
// 테스트 32 〉 통과 (30.18ms, 90.7MB)
// 테스트 33 〉 통과 (115.39ms, 111MB)
// 테스트 34 〉 통과 (79.56ms, 109MB)

// 배열 사용 풀이
// class Solution {
//     public int solution(int k, int[] tangerine) {
//         int answer = 0;
//         int max = -1;

//         for (int i = 0; i < tangerine.length; i++) {
//             max = Math.max(max, tangerine[i]);
//         }

//         int[] count = new int[max + 1];

//         for (int i = 0; i < tangerine.length; i++) {
//             count[tangerine[i]]++;
//         }

//         Arrays.sort(count);

//         int sum = 0;
//         for (int i = count.length - 1; i >= 0; i--) {
//             sum += count[i];
//             answer++;
//             if (sum >= k) break;
//         }

//         return answer;
//     }
// }

// 테스트 1 〉	통과 (4.17ms, 90.2MB)
// 테스트 2 〉	통과 (3.41ms, 79.8MB)
// 테스트 3 〉	통과 (5.82ms, 81.3MB)
// 테스트 4 〉	통과 (4.79ms, 92.9MB)
// 테스트 5 〉	통과 (2.84ms, 80.3MB)
// 테스트 6 〉	통과 (3.21ms, 81.7MB)
// 테스트 7 〉	통과 (3.28ms, 84.4MB)
// 테스트 8 〉	통과 (4.46ms, 93.4MB)
// 테스트 9 〉	통과 (4.93ms, 82.5MB)
// 테스트 10 〉 통과 (3.49ms, 95.4MB)
// 테스트 11 〉 통과 (189.83ms, 149MB)
// 테스트 12 〉 통과 (0.36ms, 72.9MB)
// 테스트 13 〉 통과 (0.33ms, 78.9MB)
// 테스트 14 〉 통과 (0.44ms, 73.7MB)
// 테스트 15 〉 통과 (0.37ms, 70.1MB)
// 테스트 16 〉 통과 (0.41ms, 74.8MB)
// 테스트 17 〉 통과 (0.37ms, 74.9MB)
// 테스트 18 〉 통과 (0.38ms, 76.5MB)
// 테스트 19 〉 통과 (0.48ms, 69MB)
// 테스트 20 〉 통과 (0.34ms, 76.3MB)
// 테스트 21 〉 통과 (0.48ms, 78.3MB)
// 테스트 22 〉 통과 (0.48ms, 81.2MB)
// 테스트 23 〉 통과 (0.53ms, 76.9MB)
// 테스트 24 〉 통과 (0.49ms, 77.4MB)
// 테스트 25 〉 통과 (1.60ms, 77.5MB)
// 테스트 26 〉 통과 (3.91ms, 81.4MB)
// 테스트 27 〉 통과 (55.86ms, 128MB)
// 테스트 28 〉 통과 (38.63ms, 131MB)
// 테스트 29 〉 통과 (55.69ms, 131MB)
// 테스트 30 〉 통과 (59.63ms, 123MB)
// 테스트 31 〉 통과 (46.26ms, 120MB)
// 테스트 32 〉 통과 (39.83ms, 132MB)
// 테스트 33 〉 통과 (35.85ms, 114MB)
// 테스트 34 〉 통과 (38.06ms, 120MB)
