import java.io.*;
import java.util.*;

public class Main {
   private static final int[] DX = { 0, -1, -1, -1, 0, 1, 1, 1 };
   private static final int[] DY = { -1, -1, 0, 1, 1, 1, 0, -1 };
   private static final int[] DIR = {1, 3, 5, 7};
   
   private static int n, m;
   private static int[][] map;
   private static boolean[][] vst;
   private static Queue<Location> cloudLocs;
   
   private static class Location {
      int x, y;
      
      public Location(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      map = new int[n][n];
      vst = new boolean[n][n];
      cloudLocs = new LinkedList<>();
      
      cloudLocs.add(new Location(n - 1,  1));
      cloudLocs.add(new Location(n - 1,  2));
      cloudLocs.add(new Location(n - 2,  1));
      cloudLocs.add(new Location(n - 2,  2));
      
      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < n; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      
      while (m-- > 0) {
         st = new StringTokenizer(br.readLine());
         int d = Integer.parseInt(st.nextToken()) - 1;
         int s = Integer.parseInt(st.nextToken());
         moveCloud(d, s);
         copyMagic();
         createCloud();
         for (int i = 0; i < n; i++) {
            Arrays.fill(vst[i], false);            
         }
      }
      
      int remainWater = 0;
      
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            remainWater += map[i][j];
         }
      }
      
      bw.write(String.valueOf(remainWater));
      bw.close();
      br.close();
   }
   

   private static void moveCloud(int direction, int distance) {
      int length = cloudLocs.size();
      
      while (length-- > 0) {
         Location cloudLoc = cloudLocs.poll();
         int nx = (cloudLoc.x + (DX[direction] * distance)) % n;
         int ny = (cloudLoc.y + (DY[direction] * distance)) % n;
         if (nx < 0) {
            nx += n;
         }
         if (ny < 0) {
            ny += n;
         }
         map[nx][ny]++;
         cloudLocs.offer(new Location(nx, ny));
         vst[nx][ny] = true;
      }
   }
   
   private static void copyMagic() {
      List<int[]> waters = new ArrayList<>();
      while (!cloudLocs.isEmpty()) {
         Location cloudLoc = cloudLocs.poll();
         int count = 0;
         for (int i = 0; i < 4; i++) {
            int nx = cloudLoc.x + DIR[i];
            int ny = cloudLoc.y + DIR[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] > 0) {
               count++;
            }
         }
         waters.add(new int[] {cloudLoc.x, cloudLoc.y, count});
      }
      
      for (int[] water : waters) {
         map[water[0]][water[1]] += water[2];
      }
   }

   private static void createCloud() {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (!vst[i][j] && map[i][j] >= 2) {
               map[i][j] -= 2;
               cloudLocs.add(new Location(i, j));
            }
         }
      }
   }
}
