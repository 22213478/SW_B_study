// [Pro] 빙하의 이동
// 노트: 03-빙하의이동.md
// Main은 수정하지 않음. 여기만 작성.
// 지금은 init + 융해만. 이동·병합은 나중에.

import java.util.ArrayDeque;

class UserSolution {
  private final static int MAX_N = 100;
  int n;
  int m;
  int block[][];
  int group[][];
  // int[] dx={0,0,-1,1};
  // int[] dy={-1,1,0,0};
  int[] dx = { 1, 0 };
  int[] dy = { 0, 1 };

  class RESULT {
    int[][] heights;

    RESULT() {
      heights = new int[MAX_N][MAX_N];
    }
  }

  void init(int N, int M, int mIceBlock[][], int mIceGroup[][]) {
    n = N;
    m = M;
    block = mIceBlock;
    group = mIceGroup;

  }

  void move() {

    for (int i = 0; i < m; i++) {
      int x = group[i][0];
      int y = group[i][1];
      int direction = group[i][3];
      int[][] selected = new int[n][n];

      selected = bfs(x, y);
      for (int ix = x; ix < n; ix++) {
        for (int iy = y; iy < n; iy++) {
          if (selected[ix][iy] != 0) {
            block[ix][iy] = 0;
            switch (direction) {
              case 0:
                if (iy - 1 < 0)
                  iy = n - 1 + 1;
                block[ix][iy - 1] = selected[ix][iy];
                break;
              case 1:
                if (ix + 1 == n)
                  ix = 0 - 1;
                block[ix + 1][iy] = selected[ix][iy];
                break;
              case 2:
                if (iy + 1 == n)
                  iy = 0 - 1;
                block[ix][iy + 1] = selected[ix][iy];
                break;
              case 3:
                if (ix - 1 < 0)
                  ix = n - 1 + 1;
                block[ix - 1][iy] = selected[ix][iy];
                break;

            }

          }

        }
      }

    }

  }

  void melt() {
    for (int i = 0; i < m; i++) {
      int x = group[i][0];
      int y = group[i][1];
      int direction = group[i][3];
      int[][] selected = new int[n][n];
      int[] dx_for = { 0, 0, -1, 1 };
      int[] dy_for = { -1, 1, 0, 0 };
      boolean[][] visited = new boolean[n][n];

      selected = bfs(x, y);
      for (int ix = x; ix < n; ix++) {
        for (int iy = y; iy < n; iy++) {
          if(!visited[ix][iy]){
            for(int j=0; j<4; j++){
              int nx=ix+dx_for[j];
              int ny=ix+dx_for[j];
              
  
            }

          }
          
        }
      }
    }

  }

  int[][] bfs(int x, int y) {
    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.offer(new int[] { x, y });
    int[][] selected = new int[n][n];
    boolean[][] visited = new boolean[n][n];
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      x = cur[0];
      y = cur[1];

      for (int i = 0; i < 2; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx == n)
          nx = 0;
        if (ny == n)
          ny = 0;
        if (block[nx][ny] != 0 && !visited[nx][ny]) {
          q.offer(new int[] { nx, ny });
          selected[nx][ny] = block[nx][ny];
          visited[nx][ny] = true;

        }
      }

    }
    return selected;

  }

  int near_one(int x, int y) {
    int num = -1;

    return num;
  }

  RESULT oneYearLater() {
    RESULT res = new RESULT();
    melt();
    move();

    return res;
  }
}
