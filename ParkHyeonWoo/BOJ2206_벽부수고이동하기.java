package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_벽부수고이동하기 {
	static int n, m;
	static int[][] board;
	static int[][] visited;
	static Queue<Node> q = new LinkedList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}

		q.offer(new Node(0, 0, 2));
		visited[0][0] = 2;
		int move = 1;
		// 아직 방문하지 않은 곳 = 0, 벽 뚫고 방문 = 1, 벽 안뚫고 방문 = 2
		label: while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = node.x + dx[j];
					int ny = node.y + dy[j];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] >= node.breaked) {
						continue;
					}
					// 목적지 도달
					if (nx == n - 1 && ny == m - 1) {
						answer = move + 1;
						break label;
					}
					// 벽을 이미 깬 상태에서 벽 조우
					if (node.breaked == 1 && board[nx][ny] == 1) {
						continue;
					}
					// 안깬상태에서 벽 조우. 일단 깨봄
					if (node.breaked == 2 && board[nx][ny] == 1) {
						visited[nx][ny] = 1;
						q.offer(new Node(nx, ny, 1));
						continue;
					}
					// 일반 경로
					visited[nx][ny] = node.breaked;
					q.offer(new Node(nx, ny, node.breaked));
				}
			}
			move++;
		}
		System.out.println((n == 1 && m == 1) ? 1 : answer);

	}

	static class Node {
		int x, y, breaked;

		Node(int x, int y, int breaked) {
			this.x = x;
			this.y = y;
			this.breaked = breaked;
		}
	}

}
