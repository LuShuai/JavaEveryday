package someTest;

public class GoolgeTest{

	public static int[] getMaxSub(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		int[] res = new int[2];
		res[0] = 0;
		res[1] = 1;
		int cStart = -1;
		int cEnd = 0;
		int cVal = 0;
		int mStart = 0;
		int mEnd = 0;
		int max = Integer.MIN_VALUE;
		
		int runner = 0;
		while (runner < a.length) {
			cVal = cVal + a[runner];
			if (cStart < 0) {
				cStart = runner;
				cEnd = runner - 1;
			}
			++cEnd;
			if (cVal > max) {
				max = cVal;
				mStart = cStart;
				mEnd = cEnd;
			}
			if (cVal < 0) {
				cVal = 0;
				cStart = -1;
			}
			++runner;
		}
		res[0] = mStart;
		res[1] = mEnd;
		return res;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,-100,10,-1,2};
		System.out.println("start: "+ getMaxSub(a)[0]);
		System.out.println("length: "+ getMaxSub(a)[1]);
	}

}
