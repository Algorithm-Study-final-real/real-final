import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx = {1,-1, 0,0};
	static int[] dy = {0,0, 1, -1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[r][c];
		int[][] melt = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> land = new LinkedList<>();

		int time = 0;
		while(true) {
			
			boolean[][] visit = new boolean[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					melt[i][j] = board[i][j];
				}
			}
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(board[i][j] != 0) {
						int zero = 0;
						for(int d = 0; d < 4; d++) {
							int nx = i+dx[d];
							int ny = j+dy[d];
							
							if(nx >= 0 && nx < r && ny >= 0 && ny < c
									&& board[nx][ny] == 0) zero++;
						}
						if(melt[i][j] - zero < 0) {
							melt[i][j] = 0;
						}
						else melt[i][j] -= zero;
					}
				}
				
			}
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					board[i][j] = melt[i][j];
				}
			}
			
			int count = 0;
			int zcnt = 0;
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(board[i][j] != 0 && !visit[i][j]) {
						visit[i][j] = true;
						land.offer(new int[] {i,j});
						while(!land.isEmpty()) {
							int[] point = land.poll();
							int x = point[0];
							int y = point[1];
							for(int d = 0; d < 4; d++) {
								int nx = x+dx[d];
								int ny = y+dy[d];
								
								if(nx >= 0 && nx < r && ny >= 0 && ny < c
										&& board[nx][ny] != 0 && !visit[nx][ny]) {
									visit[nx][ny] = true;
									land.offer(new int[] {nx,ny});
								}
							}
						}
						count++;
					}
					if(board[i][j] == 0) zcnt++;
				}
			}
			
			time++;
			if(zcnt == r*c) {
				time = 0;
				break;
			}
			if(count > 1) break;
		}
		System.out.println(time);
		
	}

}
