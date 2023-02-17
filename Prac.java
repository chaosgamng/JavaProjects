/*
 	THE POINT WAS TO ROTATE THE OUTSIDE OF AN ARRAY AND KEEP THE INSIDE THE SAME
 	THE ARRAY CAN BE ANY SIZE FEEL FREE TO OPTOMIZE THE CODE AND MAKE IT BETTER
 */
import java.util.Scanner;

public class Prac {

	public static int[][] nTimes(int[][] ar, int shift) {
		int[][] x = new int[ar.length][ar[0].length];
		for (int i = 0; i < ar.length; i++) {
			for (int xx = 0; xx < ar[0].length; xx++) {
				x[i][xx] = ar[i][xx];
			}
		}
		int n = 1;
		int s = shift;
		while (s >= ar.length) {
			n++;
			s -= ar.length;
		}
		for (int i = 0; i < n - 1; i++) {
			x = shift(x, ar.length);
		}
		x = shift(x, s);
		return x;
	}

	public static int[][] shift(int[][] ar, int shift) {
		int[][] retur = new int[ar.length][ar[0].length];
		int[] que = new int[ar.length * ar[0].length];
		int count = 0;
		int inser = 0;

		// need to automate to make it go more than one row only on skipping
		// main mover shifts everything adds unused numbers to a queue then sets the in
		// the next row
		// top row
		for (int i = 0; i < ar[0].length; i++) {
			if (i + shift >= ar[0].length) {
				que[count] = ar[0][i];
				count++;
			} else {
				retur[0][i + shift] = ar[0][i];
			}
		}
		// last coll
		for (int i = 1; i < ar.length; i++) {
			if (retur[i][ar[0].length - 1] == 0) {
				retur[i][ar[0].length - 1] = que[inser];
				inser++;
			}
			if (i + shift >= ar.length) {
				que[count] = ar[i][ar[0].length - 1];
				count++;
			} else {

				retur[i + shift][ar[0].length - 1] = ar[i][ar[0].length - 1];
			}
		}

		// last row
		for (int i = ar[0].length - 2; i > 0; i--) {
			if (retur[ar.length - 1][i] == 0) {
				retur[ar.length - 1][i] = que[inser];
				inser++;

			}
			if (i - shift <= 1) {
				que[count] = ar[ar.length - 1][i];
				count++;
			} else {

				retur[ar.length - 1][i - shift] = ar[ar.length - 1][i];
			}

		}

		// first coll
		for (int i = ar.length - 1; i > 0; i--) {
			if (retur[i][0] == 0) {
				retur[i][0] = que[inser];
				inser++;
			}
			if (i - shift <= 0) {
				que[count] = ar[i][0];
				count++;
			} else {

				retur[i - shift][0] = ar[i][0];
			}
		}

		// checker fixes and zeros or null areas on the outside left behind
		// from the main mover
		// top row
		for (int i = 0; i < ar[0].length; i++) {
			if (retur[0][i] == 0) {
				retur[0][i] = que[inser];
				inser++;
			}
		}
		// last coll
		for (int i = 1; i < ar.length; i++) {
			if (retur[i][ar[0].length - 1] == 0) {
				retur[i][ar.length - 1] = que[inser];
				inser++;
			}

		}

		// last row
		for (int i = ar[0].length - 2; i > 0; i--) {
			if (retur[ar.length - 1][i] == 0) {
				retur[ar.length - 1][i] = que[inser];
				inser++;

			}

		}

		// first coll
		for (int i = ar.length - 1; i > 0; i--) {
			if (retur[i][0] == 0) {
				retur[i][0] = que[inser];
				inser++;
			}
		}

		// fix middle squares at end
		for (int i = 0; i < retur.length; i++) {
			for (int z = 0; z < retur[0].length; z++) {
				if (retur[i][z] == 0) {
					retur[i][z] = ar[i][z];
				}
			}
		}
		return retur;
	}

	// main method

	public static void main(String[] args) {

		// all variables
//		int[][] pass = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 },
//				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 },
//				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 },
//				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 } };
//		int[][] pass = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
//				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9},
//				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
//				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
		int[][] pass = { { 1, 2, 3, 4, 5, 6, 7, 8}, { 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8},
				{ 1, 2, 3, 4, 5, 6, 7, 8}, { 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8 },
				{ 1, 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 5, 6, 7, 8} };
		// int[][] pass = {{1,2,3,4},{5,6,7,8},{9,1,2,3},{4,5,6,7}};
		// int[][] pass = {{1,2,3},{4,5,6},{7,8,9}};

		// int[][] pass = { { 1, 2 }, { 3, 4 } };
		int num;

		// asking user for input on shift
		System.out.println("Enter how many places you would like to shift the numbers: ");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();

		// making sure shift is credible
		// num > pass.length ||
		while (num < 0) {
			if (num < 0) {
				System.out.println("Number too small go higher cannot be less than 0");
			}
			num = input.nextInt();
		}

		// printing array befor shift
		for (int i = 0; i < pass.length; i++) {
			for (int ii = 0; ii < pass[0].length; ii++) {
				System.out.print(pass[i][ii]);
			}
			System.out.println();
		}
		System.out.println();

		// passing array into shift method
		pass = nTimes(pass, num);

		// printing array after being shifted
		for (int i = 0; i < pass.length; i++) {
			for (int ii = 0; ii < pass[0].length; ii++) {
				System.out.print(pass[i][ii]);
			}
			System.out.println();
		}
		input.close();
	}
}
