import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
        int[][] vis = new int[m][n];
        for(int[] v : vis) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        if(grid[0][0] > 0 || (( m > 1 && grid[1][0] > 1) && (( n > 1 && grid[0][1] > 1)))) {
            return -1;
        }

        pq.offer(new int[]{0, 0, 0});
        
        int[][] dest = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curTime = cur[0];
            int i = cur[1];
            int j = cur[2];
            if(i == m - 1 && j == n - 1) {
                return curTime;
            }
            if(vis[i][j] < curTime) {
                continue;
            }
            vis[i][j] = curTime;
            for(int[] d : dest) {
                int nextI = i + d[0];
                int nextJ = j + d[1];
                
                if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                    if(grid[nextI][nextJ] - 1 <= curTime) {
                        int nextTime = curTime + 1;
                        if(vis[nextI][nextJ] <= nextTime) {
                            continue;
                        }
                        vis[nextI][nextJ] = nextTime;
                        pq.offer(new int[]{nextTime, nextI, nextJ });
                    }else {
                        int nextTime = (grid[nextI][nextJ] - curTime) % 2 == 0 ? grid[nextI][nextJ] + 1 : grid[nextI][nextJ];
                        if(vis[nextI][nextJ] <= nextTime) {
                            continue;
                        }
                        vis[nextI][nextJ] = nextTime;
                        pq.offer(new int[]{nextTime, nextI, nextJ });
                    }
                }
            }


        } 

        return -1;
    }
}