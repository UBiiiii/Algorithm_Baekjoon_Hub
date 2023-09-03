import java.util.Scanner;

public class Main {
	
	public static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = Integer.parseInt(sc.nextLine());
		for(int i=0;i<c;i++) {
			int answer = 0;
			String str = sc.nextLine();
			String[] mapData = str.split(" ");
			int bx = Integer.parseInt(mapData[0]);
			int by = Integer.parseInt(mapData[1]);
			int b = Integer.parseInt(mapData[2]);
			map = new int[bx][by];
			for(int j=0;j<b;j++) {
				String[] bData = sc.nextLine().split(" ");
				int nx = Integer.parseInt(bData[0]);
				int ny = Integer.parseInt(bData[1]);
				map[nx][ny] = 1;
			}
			
			boolean flag=false;
			
			do {
				flag = false;
				for(int x=0;x<bx;x++) {
					for(int y=0;y<by;y++) {
						int block = map[x][y];
						if(block == 1)	{
							check(x,y,bx,by);
							flag = true;
							answer++;
							break;
						}
					}
					if(flag) break;
				}
				
			} while(flag);
			
			System.out.println(answer);
		}
		
		sc.close();
	}
	
	public static boolean check(int x, int y, int bx, int by) {
		int[] dx = new int[] {0,0,1,-1};
		int[] dy = new int[] {1,-1,0,0};
		boolean result = true;
		map[x][y] = 0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || ny==by || nx==bx)	continue;
			if(map[nx][ny]==1) {
				result = check(nx, ny, bx, by);
			}
		}
		return result;
	}

}
