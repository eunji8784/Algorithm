import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // friend들의 index 저장
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String friend : friends) {
            map.put(friend, index++);
        }
        
        int n = friends.length;
        int[][] giveAndTake = new int[n][n]; // 주고받은 선물 개수 배열
        int[] degree = new int[n]; // 선물 지수 배열
        
        // 주고 받은 선물 count
        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            giveAndTake[map.get(arr[0])][map.get(arr[1])]++;
        }
        
        // 선물 지수 계산
        for (int i = 0; i < n; i++) {
            int giveCount = 0, takeCount = 0;
            for (int j = 0; j < n; j++) {
                giveCount += giveAndTake[i][j];
                takeCount += giveAndTake[j][i];
            }
            degree[i] = giveCount - takeCount;
        }
        
        // 결과 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && (giveAndTake[i][j] > giveAndTake[j][i]) || (giveAndTake[i][j] == giveAndTake[j][i] && degree[i] > degree[j]))  { 
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}
