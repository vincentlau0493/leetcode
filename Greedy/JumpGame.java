public class JumpGame {

	public boolean canJump(int[] A) {

		if (A.length <= 1) return true;
		int farest = 0;
		for (int i=0; i<A.length; i++) {
			if (farest < i) return false;
			farest = Math.max(farest, i + A[i]);
		} 
		return true;

	}



}