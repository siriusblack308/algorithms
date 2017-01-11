package interviews;

public class MakingSquare {
	public static void main(String[] arg) {
		int N = 8;
		int[][] square = new int[N][N];
		int step = 0;
		int count = 1;
		while(step < N/2) {
		for(int i=step;i< N-step;i++) {
				square[i][step] = count;
				count++;
			} 
			for(int i =step+1;i<N-step;i++) {
				square[N-step-1][i] = count;
				count++;
			}
			for(int i = N-step-2;i>=step;i--) {
				square[i][N-step-1] = count;
				count++;
			}
			for(int i = N-step-2;i>step;i--) {
				square[step][i] = count;
				count++;
			}
			step++;
		}
			
			

			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					System.out.print(square[x][y] + ",");
				}
				System.out.println("");
			}
		}
}


////while(step < 2) {
//for(int i=step;i< N-step;i++) {
//		square[step][i] = count;
//		count++;
//	} 
//	for(int i =step+1;i<N-step;i++) {
//		square[i][N-step-1] = count;
//		count++;
//	}
//	for(int i = N-step-1;i>step;i--) {
//		square[N-step-1][i] = count;
//		count++;
//	}
//	for(int i = N-step-1;i>step;i--) {
//		square[i][step] = count;
//		count++;
//	}
////	step++;
////}
