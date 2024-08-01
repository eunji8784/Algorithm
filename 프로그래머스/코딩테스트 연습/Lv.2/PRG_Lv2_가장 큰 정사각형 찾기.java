import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;   
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                if (i >= 1 && j >= 1 && board[i - 1][j] != 0 && board[i][j - 1] != 0 && board[i - 1][j - 1] != 0) {
                    board[i][j] += Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1]));
                }

                answer = Math.max(answer, board[i][j]);
            }
        }    

        return answer * answer;
    }
}

// 테스트 1 〉	통과 (0.03ms, 74.2MB)
// 테스트 2 〉	통과 (0.04ms, 76.4MB)
// 테스트 3 〉	통과 (0.09ms, 76.2MB)
// 테스트 4 〉	통과 (0.06ms, 85.8MB)
// 테스트 5 〉	통과 (0.04ms, 75.4MB)
// 테스트 6 〉	통과 (0.03ms, 77.6MB)
// 테스트 7 〉	통과 (0.03ms, 76.6MB)
// 테스트 8 〉	통과 (0.02ms, 77.5MB)
// 테스트 9 〉	통과 (0.03ms, 79.4MB)
// 테스트 10 〉	통과 (0.04ms, 70.4MB)
// 테스트 11 〉	통과 (0.03ms, 79.1MB)
// 테스트 12 〉	통과 (0.04ms, 72.8MB)
// 테스트 13 〉	통과 (0.04ms, 78.8MB)
// 테스트 14 〉	통과 (0.04ms, 87.8MB)
// 테스트 15 〉	통과 (0.04ms, 73.8MB)
// 테스트 16 〉	통과 (0.04ms, 72.5MB)
// 테스트 17 〉	통과 (0.04ms, 71MB)
// 테스트 18 〉	통과 (0.35ms, 77.7MB)
// 테스트 19 〉	통과 (0.47ms, 79.2MB)
// 효율성  테스트
// 테스트 1 〉	통과 (28.89ms, 89.4MB)
// 테스트 2 〉	통과 (24.01ms, 89.3MB)
// 테스트 3 〉	통과 (23.61ms, 88.8MB)
