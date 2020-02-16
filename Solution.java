class Solution {
    private int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    public int closedIsland(int[][] grid) {
        int ans = 0;
        for(int j = 0; j < grid[0].length; j++) {
            if(grid[0][j] == 0) {
                bfs(grid, 0, j);
            }
            if(grid[grid.length - 1][j] == 0) {
                bfs(grid, grid.length - 1, j);
            }
        }
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 0) {
                bfs(grid, i, 0);
            }
            if(grid[i][grid[0].length - 1] == 0) {
                bfs(grid, i, grid[0].length - 1);
            }            
        }
        for(int i = 1; i < grid.length - 1; i++) {
            for(int j = 1; j < grid[0].length - 1; j++) {
                if(grid[i][j] == 0) {
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void bfs(int[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        grid[x][y] = 2;
        
        while(q.size() > 0) {
            int[] curr = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int x1 = curr[0] + dx[dir];
                int y1 = curr[1] + dy[dir];
                if(x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == 0) {
                    q.add(new int[]{x1, y1});
                    grid[x1][y1] = 2;
                }
            }
        }
    }
}