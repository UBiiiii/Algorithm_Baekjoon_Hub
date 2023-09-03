import java.io.*;

public class Main {
	
	public static int r = 0;
	public static int c = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int bound = (int)Math.pow(2, n);
		r = Integer.parseInt(input[1]);
		c = Integer.parseInt(input[2]);
		int answer = fillNum(0,bound,0,bound, 0, (int)Math.pow(bound, 2));
		System.out.println(answer);
	}
	
	public static int fillNum(int sx, int ex, int sy, int ey, int sn, int en) {
		int blockX = (ex+sx)/2;
		int blockY = (ey+sy)/2;
		int gap = (en - sn)/4;
		if(gap>1) {
			if(r < blockY && c < blockX) return fillNum(sx,blockX,sy,blockY, sn, sn+gap);
			else if(r < blockY && c >= blockX) return fillNum(blockX,ex,sy,blockY, sn+gap, sn+2*gap);
			else if(r >= blockY && c < blockX) return fillNum(sx,blockX,blockY,ey, sn+2*gap, sn+3*gap);
			else return fillNum(blockX,ex,blockY,ey, sn+3*gap, sn+4*gap);
		} else {
			return sn + (r-sy)*2 + (c-sx);
		}
	}
}
