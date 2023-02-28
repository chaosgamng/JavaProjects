
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static char[][] counter(char[][] board, char u) {
		// getting and setting the board
		char[][] b = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int x = 0; x < board[0].length; x++) {
				b[i][x] = board[i][x];
			}
		}
		// if user 2
		if (u == 'O') {
			for (int i = 0; i < b.length; i++) {
				for (int x = 0; x < b[0].length; x++) {
					// first move pick a corner if they pick middle
					if (b[i][x] == 'O') {
						// trying to win
						// in row
						if (i + 2 < b.length) {
							if (b[i + 2][x] != 'X' && b[i + 1][x] == u && b[i + 2][x] != 'O') { // down
								b[i + 2][x] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0) {
							if (b[i - 2][x] != 'X' && b[i - 1][x] == u && b[i - 2][x] != 'O') { // up
								b[i - 2][x] = 'O';
								return b;
							}
						}
						if (x + 2 < b[0].length) {
							if (b[i][x + 2] != 'X' && b[i][x + 1] == u && b[i][x + 2] != 'O') { // right
								b[i][x + 2] = 'O';
								return b;
							}
						}
						if (x - 2 >= 0) {
							if (b[i][x - 2] != 'X' && b[i][x - 1] == u && b[i][x - 2] != 'O') { // left
								b[i][x - 2] = 'O';
								return b;
							}
						}
						if (i + 2 < b.length && x + 2 < b[0].length) {
							if (b[i + 2][x + 2] != 'X' && b[i + 1][x + 1] == u && b[i + 2][x + 2] != 'O') { // down right
								b[i + 2][x + 2] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0 && x + 2 < b[0].length) {
							if (b[i - 2][x + 2] != 'X' && b[i - 1][x + 1] == u && b[i - 2][x + 2] != 'O') { // up right
								b[i - 2][x + 2] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0 && x - 2 >= 0) {
							if (b[i - 2][x - 2] != 'X' && b[i - 1][x - 1] == u && b[i - 2][x - 2] != 'O') { // up left
								b[i - 2][x - 2] = 'O';
								return b;
							}
						}
						if (i + 2 < b.length && x - 2 >= 0) {
							if (b[i + 2][x - 2] != 'X' && b[i + 1][x - 1] == u && b[i + 2][x - 2] != 'O') { // down left
								b[i + 2][x - 2] = 'O';
								return b;
							}
						}

						// gap between them
						if (i + 2 < b.length) {
							if (b[i + 1][x] != 'X' && b[i + 2][x] == u && b[i + 1][x] != u) { // down
								b[i + 1][x] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0) {

							if (b[i - 1][x] != 'X' && b[i - 2][x] == u && b[i - 1][x] != u) { // up

								b[i - 1][x] = 'O';
								return b;
							}
						}
						if (x + 2 < b.length) {
							if (b[i][x + 1] != 'X' && b[i][x + 2] == u && b[i][x + 1] != u) { // right

								b[i][x + 1] = 'O';
								return b;
							}
						}
						if (x - 2 >= 0) {
							if (b[i][x - 1] != 'X' && b[i][x - 2] == u && b[i - 1][x] != u) { // left

								b[i][x - 1] = 'O';
								return b;
							}
						}
						if (i + 2 < b.length && x + 2 < b[0].length) {
							if (b[i + 1][x + 1] != 'X' && b[i + 2][x + 2] == u && b[i + 1][x + 1] != u) { // down right
								b[i + 1][x + 1] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0 && x + 2 < b[0].length) {
							if (b[i - 1][x + 1] != 'X' && b[i - 2][x + 2] == u && b[i - 1][x + 1] != u) { // up right
								b[i - 1][x + 1] = 'O';
								return b;
							}
						}
						if (i + 2 < b.length && x - 2 >= 0) {
							if (b[i + 1][x - 1] != 'X' && b[i + 2][x - 2] == u && b[i + 1][x - 1] != u) { // down left
								b[i + 1][x - 1] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0 && x - 2 >= 0) {
							if (b[i - 1][x - 1] != 'X' && b[i - 2][x - 2] == u && b[i - 1][x - 1] != u) { // up right
								b[i - 1][x - 1] = 'O';
								return b;
							}
						}
					}
					if (i == 1 && x == 1 && b[0][0] != 'O' && b[0][0] != 'X') {
						b[0][0] = 'O';
						return b;
					}
				}
			}
			for (int i = 0; i < b.length; i++) {
				for (int x = 0; x < b[0].length; x++) {
					// checking for counters
					if (b[i][x] == 'X') {
						if (i - 2 >= 0) {
							if (b[i - 1][x] == 'X' && b[i - 2][x] != u) { // up
								b[i - 2][x] = 'O';
								return b;
							}
						}
						if (i + 2 < b.length) {

							if (b[i + 1][x] == 'X' && b[i + 2][x] != u) { // down
								b[i + 2][x] = 'O';
								return b;
							}
						}
						if (x + 2 < b[0].length) {
							if (b[i][x + 1] == 'X' && b[i][x + 2] != u) { // right
								b[i][x + 2] = 'O';
								return b;
							}
						}
						if (x - 2 >= 0) {
							if (b[i][x - 1] == 'X' && b[i][x - 2] != u) { // left
								b[i][x - 2] = 'O';
								return b;
							}
						}
						if (i + 2 < b.length && x + 2 < b[0].length) {
							if (b[i + 1][x + 1] == 'X' && b[i + 2][x + 2] != u) { // down right
								b[i + 2][x + 2] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0 && x + 2 < b[0].length) {
							if (b[i - 1][x + 1] == 'X' && b[i - 2][x + 2] != u) { // up right
								b[i - 2][x + 2] = 'O';
								return b;
							}
						}
						if (i - 2 >= 0 && x - 2 >= 0) {
							if (b[i - 1][x - 1] == 'X' && b[i - 2][x - 2] != u) { // up left
								b[i - 2][x - 2] = 'O';
								return b;
							}
						}
						if (i + 2 < b.length - 1 && x - 2 >= 0) {
							if (b[i + 1][x - 1] == 'X' && b[i + 2][x - 2] != u) { // down left
								b[i + 2][x - 2] = 'O';
								return b;
							}
						}

						// checking corners counters
						if (b[0][0] == 'X' && b[0][2] == 'X' && b[0][1] != 'O') {
							b[0][1] = 'O';
							return b;
						}
						if (b[2][0] == 'X' && b[0][0] == 'X' && b[1][0] != 'O') {
							b[1][0] = 'O';
							return b;
						}
						if (b[2][0] == 'X' && b[2][2] == 'X' && b[2][1] != 'O') {
							b[2][1] = 'O';
							return b;
						}
						if (b[0][2] == 'X' && b[2][2] == 'X' && b[1][2] != 'O') {
							b[1][2] = 'O';
							return b;
						}
					}

					// if no middle go middle
					if (b[1][1] != 'X' && b[1][1] != 'O') {
						b[1][1] = 'O';
						return b;
					}

				}
			}
			int xx = 0;
			int yy = 0;
			Random xxx = new Random();
			xx = xxx.nextInt(board.length);
			yy = xxx.nextInt(board[0].length);
			while (b[xx][yy] == 'O' || b[xx][yy] == 'X') {
				xx = xxx.nextInt(3);
				yy = xxx.nextInt(3);
			}
			b[xx][yy] = 'O';
			// for (int ii = 0; ii < board.length; ii++) {
			// for (int z = 0; z < board[0].length; z++) {
			// System.out.print(b[ii][z]);
			// }
			// System.out.println();
			// }
			return b;

		}
		if (u == 'X')

		{
			for (int i = 0; i < b.length; i++) {
				for (int x = 0; x < b[0].length; x++) {

					if (b[i][x] == 'X') {
						if (i + 2 < b.length) {
							if (b[i + 2][x] != 'O' && b[i + 1][x] == u && b[i + 2][x] != 'X') { // up
								b[i + 2][x] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0) {

							if (b[i - 2][x] != 'O' && b[i - 1][x] == u && b[i - 2][x] != 'X') { // down
								b[i - 2][x] = 'X';
								return b;
							}
						}
						if (x + 2 < b[0].length) {
							if (b[i][x + 2] != 'O' && b[i][x + 1] == u && b[i][x + 2] != 'X') { // right
								b[i][x + 2] = 'X';
								return b;
							}
						}
						if (x - 2 >= 0) {
							if (b[i][x - 2] != 'O' && b[i][x - 1] == u && b[i][x - 2] != 'X') { // left
								b[i][x - 2] = 'X';
								return b;
							}
						}
						if (i + 2 < b.length && x + 2 < b[0].length) {
							if (b[i + 2][x + 2] != 'O' && b[i + 1][x + 1] == u && b[i + 2][x + 2] != 'X') { // down
								// right
								b[i + 2][x + 2] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0 && x + 2 < b[0].length) {
							if (b[i - 2][x + 2] != 'O' && b[i - 1][x + 1] == u && b[i - 2][x + 2] != 'X') { // down left
								b[i - 2][x + 2] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0 && x - 2 >= 0) {
							if (b[i - 2][x - 2] != 'O' && b[i - 1][x - 1] == u && b[i - 2][x - 2] != 'X') { // up left
								b[i - 2][x - 2] = 'X';
								return b;
							}
						}
						if (i + 2 < b.length - 1 && x - 2 >= 0) {
							if (b[i + 2][x - 2] != 'O' && b[i + 1][x - 1] == u && b[i + 2][x - 2] != 'X') { // up right
								b[i + 2][x - 2] = 'X';
								return b;
							}
						}

						// gap between them
						if (i + 2 < b.length) {
							if (b[i + 1][x] != 'O' && b[i + 2][x] == u && b[i + 1][x] != u) { // up
								b[i + 1][x] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0) {

							if (b[i - 1][x] != 'O' && b[i - 2][x] == u && b[i - 1][x] != u) { // down
								b[i - 1][x] = 'X';
								return b;
							}
						}
						if (x + 2 < b[0].length) {

							if (b[i][x + 1] != 'O' && b[i][x + 2] == u && b[i + 1][x] != u) { // right
								b[i][x + 1] = 'X';
								return b;
							}
						}
						if (x - 2 >= 0) {
							if (b[i][x - 1] != 'O' && b[i][x - 2] == u && b[i - 1][x] != u) { // left
								b[i][x - 1] = 'X';
								return b;
							}
						}
						if (i + 2 < b.length && x + 2 < b[0].length) {
							if (b[i + 1][x + 1] != 'O' && b[i + 2][x + 2] == u && b[i + 1][x + 1] != u) { // down right
								b[i + 1][x + 1] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0 && x + 2 < b[0].length) {
							if (b[i - 1][x + 1] != 'O' && b[i - 2][x + 2] == u && b[i - 1][x + 1] != u) { // down left
								b[i - 1][x + 1] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0 && x - 2 >= 0) {
							if (b[i - 1][x - 1] != 'O' && b[i - 2][x - 2] == u && b[i - 1][x - 1] != u) { // up left
								b[i - 1][x - 1] = 'X';
								return b;
							}
						}
						if (i + 2 < b.length - 1 && x - 2 >= 0) {
							if (b[i + 1][x - 1] != 'O' && b[i + 2][x - 2] == u && b[i + 1][x - 1] != u) { // up right
								b[i + 1][x - 1] = 'X';
								return b;
							}
						}
					}
				}
			}
			for (int i = 0; i < b.length; i++) {
				for (int x = 0; x < b[0].length; x++) {

					// first move pick a corner if they pick middle
					if (b[i][x] == 'O') {
						if (i == 1 && x == 1 && b[0][0] != 'O' && b[0][0] != 'X') {
							b[0][0] = 'X';
							return b;
						}

						if (i + 2 < b.length) {
							if (b[i + 1][x] == 'O' && b[i + 2][x] != u) { // up
								b[i + 2][x] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0) {

							if (b[i - 1][x] == 'O' && b[i - 2][x] != u) { // down
								b[i - 2][x] = 'X';
								return b;
							}
						}
						if (x + 2 < b[0].length) {
							if (b[i][x + 1] == 'O' && b[i][x + 2] != u) { // right
								b[i][x + 2] = 'X';
								return b;
							}
						}
						if (x - 2 >= 0) {
							if (b[i][x - 1] == 'O' && b[i][x - 2] != u) { // left
								b[i][x - 2] = 'X';
								return b;
							}
						}
						if (i + 2 < b.length && x + 2 < b[0].length) {
							if (b[i + 1][x + 1] == 'O' && b[i + 2][x + 2] != u) { // down right
								b[i + 2][x + 2] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0 && x + 2 < b[0].length) {
							if (b[i - 1][x + 1] == 'O' && b[i - 2][x + 2] != u) { // down left
								b[i - 2][x + 2] = 'X';
								return b;
							}
						}
						if (i - 2 >= 0 && x - 2 >= 0) {
							if (b[i - 1][x - 1] == 'O' && b[i - 2][x - 2] != u) { // up left
								b[i - 2][x - 2] = 'X';
								return b;
							}
						}
						if (i + 1 < b.length - 1 && x - 1 > 0) {
							if (b[i + 1][x - 1] == 'O' && b[i + 2][x - 2] != u) { // up right
								b[i + 2][x - 2] = 'X';
								return b;
							}
						}

						// checking corners
						if (b[0][0] == 'O' && b[0][2] == 'O' && b[0][1] != 'X') {
							b[0][1] = 'X';
							return b;
						}
						if (b[2][0] == 'O' && b[0][0] == 'O' && b[1][1] != 'X') {
							b[1][1] = 'X';
							return b;
						}
						if (b[2][0] == 'O' && b[2][2] == 'O' && b[2][1] != 'X') {
							b[2][1] = 'X';
							return b;
						}
						if (b[0][2] == 'O' && b[2][2] == 'O' && b[1][2] != 'X') {
							b[1][2] = 'X';
							return b;
						}
						if (b[1][1] != 'X' && b[1][1] != 'O') {
							b[1][1] = 'X';
							return b;
						}

						// trying to win
						// in row
					}

				}
			}
			int xx = 0;
			int yy = 0;
			Random xxx = new Random();
			xx = xxx.nextInt(3);
			yy = xxx.nextInt(3);
			while (b[xx][yy] == 'O' || b[xx][yy] == 'X') {
				xx = xxx.nextInt(3);
				yy = xxx.nextInt(3);
			}
			b[xx][yy] = 'X';
			// for (int ii = 0; ii < board.length; ii++) {
			// for (int z = 0; z < board[0].length; z++) {
			// System.out.print(b[ii][z]);
			// }
			// System.out.println();
			// }
			return b;
		}
		return b;

	}

	public static int findxy(int num, int x) {
		if (num == 1) {
			if ((x == 0) || (x == 1)) {
				return 0;
			}
		}
		if (num == 1) {
			if ((x == 0) || (x == 1)) {
				return 0;
			}
		}
		if (num == 2) {
			if (x == 0) {
				return 0;
			}
			if (x == 1) {
				return 1;
			}
		}
		if (num == 3) {
			if (x == 0) {
				return 0;
			}
			if (x == 1) {
				return 2;
			}
		}
		if (num == 4) {
			if (x == 0) {
				return 1;
			}
			if (x == 1) {
				return 0;
			}
		}
		if (num == 5) {
			if ((x == 0) || (x == 1)) {
				return 1;
			}
		}
		if (num == 6) {
			if (x == 0) {
				return 1;
			}
			if (x == 1) {
				return 2;
			}
		}
		if (num == 7) {
			if (x == 0) {
				return 2;
			}
			if (x == 1) {
				return 0;
			}
		}
		if (num == 8) {
			if (x == 0) {
				return 2;
			}
			if (x == 1) {
				return 1;
			}
		}
		if (num == 9) {
			if ((x == 0) || (x == 1)) {
				return 2;
			}
		}

		return 0;
	}

	public static Boolean checkWin(char[][] b, char u) {
		// this will go through the board and check every x or o
		// and see if there is 3 in a row
		for (int i = 0; i < b.length; i++) {
			for (int x = 0; x < b[0].length; x++) {
				if (b[i][x] == u) {
					if (i + 2 < b.length) {
						if (b[i + 1][x] == u && b[i + 2][x] == u) { // up
							return true;
						}
					}
					if (i - 2 >= 0) {
						if (b[i - 1][x] == u && b[i - 2][x] == u) { // down
							return true;
						}
					}
					if (x + 2 < b[0].length) {
						if (b[i][x + 1] == u && b[i][x + 2] == u) { // right
							return true;
						}
					}
					if (i - 2 >= 0) {
						if (b[i - 1][x] == u && b[i - 2][x] == u) { // left
							return true;
						}
					}
					if (i + 2 < b.length && x + 2 < b[0].length) {
						if (b[i + 1][x + 1] == u && b[i + 2][x + 2] == u) { // up right
							return true;
						}
					}
					if (i - 2 >= 0 && x + 2 < b[0].length) {
						if (b[i - 1][x + 1] == u && b[i - 2][x + 2] == u) { // down right
							return true;
						}
					}
					if (i - 2 >= 0 && x - 2 >= 0) {
						if (b[i - 1][x - 1] == u && b[i - 2][x - 2] == u) { // down left
							return true;
						}
					}
					if (i + 2 < b.length && x - 2 >= 0) {
						if (b[i + 1][x - 1] == u && b[i + 2][x - 2] == u) { // up left
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int x = 0; x < board[0].length; x++) {
				System.out.print(board[i][x]);
				if (x < board[0].length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (i < board.length - 1) {
				System.out.println("-----");
			}
		}
		System.out.println();

	}

	public static String gameLoop(int player1, int player2) {
		// all vars
		char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
		Boolean u1 = false;
		Boolean u2 = false;
		boolean check = false;
		boolean end = false;
		Scanner input = new Scanner(System.in);
		int spot = 0;
		int xx = 0;
		int yy = 0;

		// prints the beginning board
		printBoard(board);

		// main game loop
		while (!end) {
			int count = 0;

			// ask for input on user 1 turn
			System.out.println("User 1 turn");
			while (!check) {

				System.out.println("pick a spot");
				spot = input.nextInt();
				xx = findxy(spot, 0);
				yy = findxy(spot, 1);

				if (xx < board[0].length && yy < board.length && board[xx][yy] != 'O' && board[xx][yy] != 'X') {
					board[xx][yy] = 'X';
					check = true;
				}
			}

			// if check win returns true then user 1 wins
			// board = counter(board, 'X');
			printBoard(board);
			u1 = checkWin(board, 'X');
			if (u1) {
				return "user 1 won";
			}

			// checks to see if all spots are filled
			for (char[] element : board) {
				for (int x = 0; x < board[0].length; x++) {
					if (element[x] == 'X' || element[x] == 'O') {

						count++;
					}
					if (count == 9) {
						return "tie";
					}
				}

			}
			count = 0;

			// changes check to false so it will ask for input again
			check = false;
			// asks for input from user 2
			System.out.println("User 2 turn");
			while (!check) {
				System.out.println("pick a spot");
				spot = input.nextInt();
				xx = findxy(spot, 0);
				yy = findxy(spot, 1);

				if (xx < board[0].length && yy < board.length && board[xx][yy] != 'X' && board[xx][yy] != 'O') {
					board[xx][yy] = 'O';
					check = true;
				}
			}

			// // checks to see if user 2 won if true end game
			// board = counter(board, 'O');
			printBoard(board);
			u2 = checkWin(board, 'O');
			if (u2) {
				return "user 2 won";
			}

			for (char[] element : board) {
				for (int x = 0; x < board[0].length; x++) {
					if (element[x] == 'X' || element[x] == 'O') {
						count++;
					}
					if (count == 9) {
						return "tie";
					}
				}

			}
			check = false;

		}
		// this is not used
		input.close();
		return "";
	}

	public static String gameLoop(int players) {
		// all vars
		char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
		Boolean u1 = false;
		Boolean u2 = false;
		boolean check = false;
		boolean end = false;
		Scanner input = new Scanner(System.in);
		int xx = 0;
		int yy = 0;
		int spot = 0;

		// prints the beginning board
		printBoard(board);

		// main game loop
		while (!end) {
			int count = 0;

			// ask for input on user 1 turn

			// if check win returns true then user 1 wins
			if (players != 1) {
				board = counter(board, 'X');
			}
			if (players == 1) {
				System.out.println("User 1 turn");
				while (!check) {
					System.out.println("pick a spot");
					spot = input.nextInt();
					xx = findxy(spot, 0);
					yy = findxy(spot, 1);
					if (xx < board[0].length && yy < board.length && board[xx][yy] != 'X' && board[xx][yy] != 'O') {
						board[xx][yy] = 'X';
						check = true;
					}
				}
			}
			printBoard(board);
			u1 = checkWin(board, 'X');
			if (u1) {
				return "user 1 won";
			}

			// checks to see if all spots are filled
			for (char[] element : board) {
				for (int x = 0; x < board[0].length; x++) {
					if (element[x] == 'X' || element[x] == 'O') {

						count++;
					}
					if (count == 9) {
						return "tie";
					}
				}

			}
			count = 0;

			// changes check to false so it will ask for input again
			check = false;
			// asks for input from user 2

			// // checks to see if user 2 won if true end game
			if (players != 2) {
				board = counter(board, 'O');
			}
			if (players == 2) {
				System.out.println("User 2 turn");
				while (!check) {
					System.out.println("pick a spot");
					spot = input.nextInt();
					xx = findxy(spot, 0);
					yy = findxy(spot, 1);

					if (xx < board[0].length && yy < board.length && board[xx][yy] != 'X' && board[xx][yy] != 'O') {
						board[xx][yy] = 'O';
						check = true;
					}
				}
			}
			printBoard(board);
			u2 = checkWin(board, 'O');
			if (u2) {
				return "user 2 won";
			}

			for (char[] element : board) {
				for (int x = 0; x < board[0].length; x++) {
					if (element[x] == 'X' || element[x] == 'O') {
						count++;
					}
					if (count == 9) {
						return "tie";
					}
				}

			}
			check = false;

		}
		input.close();
		// this is not used
		return "";
	}

	public static String gameLoop() {
		// all vars
		char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
		Boolean u1 = false;
		Boolean u2 = false;
		boolean check = false;
		boolean end = false;
		Scanner input = new Scanner(System.in);
		int xx = 0;
		int yy = 0;
		// prints the beginning board
		printBoard(board);

		// main game loop
		while (!end) {
			int count = 0;
			//
			// // ask for input on user 1 turn
			// System.out.println("User 1 turn");
			// while (check == false) {
			// System.out.println("pick a x pos");
			// xx = input.nextInt();
			// System.out.println("pick a y spot");
			// yy = input.nextInt();
			//
			// if (xx < board[0].length && yy < board.length && board[xx][yy] != 'O' &&
			// board[xx][yy] != 'X') {
			// board[xx][yy] = 'X';
			// check = true;
			// }
			// }

			// if check win returns true then user 1 wins
			board = counter(board, 'X');
			printBoard(board);
			u1 = checkWin(board, 'X');
			if (u1) {
				return "user 1 won";
			}

			// checks to see if all spots are filled
			for (char[] element : board) {
				for (int x = 0; x < board[0].length; x++) {
					if (element[x] == 'X' || element[x] == 'O') {

						count++;
					}
					if (count == 9) {
						return "tie";
					}
				}

			}
			count = 0;

			// changes check to false so it will ask for input again
			// check = false;
			// // asks for input from user 2
			// System.out.println("User 2 turn");
			// while (check == false) {
			// System.out.println("pick a x pos");
			// xx = input.nextInt();
			// System.out.println("pick a y spot");
			// yy = input.nextInt();
			//
			// if (xx < board[0].length && yy < board.length && board[xx][yy] != 'X' &&
			// board[xx][yy] != 'O') {
			// board[xx][yy] = 'O';
			// check = true;
			// }
			// }
			//
			// // checks to see if user 2 won if true end game
			board = counter(board, 'O');
			printBoard(board);
			u2 = checkWin(board, 'O');
			if (u2) {
				return "user 2 won";
			}

			for (char[] element : board) {
				for (int x = 0; x < board[0].length; x++) {
					if (element[x] == 'X' || element[x] == 'O') {
						count++;
					}
					if (count == 9) {
						return "tie";
					}
				}

			}
			// check = false;

		}
		// this is not used
		input.close();
		return "";
	}

	public static void main(String[] args) {
		// runs the game stores the winner in string then prints
		int player = 0;
		int turn = 0;
		int end = 0;
		Scanner input = new Scanner(System.in);

		while (end == 0) {

			System.out.println("how many players do you have 0 - 2");
			player = input.nextInt();
			while (player > 2 || player < 0) {
				System.out.println("how many players do you have 0 - 2");
				player = input.nextInt();
			}

			if (player == 0) {
				String winner = gameLoop();
				System.out.println(winner);
			}
			if (player == 1) {
				System.out.println("would you like to be 1 or 2");
				turn = input.nextInt();
				String winner = gameLoop(turn);
				System.out.println(winner);
			}
			if (player == 2) {
				String winner = gameLoop(1, 2);
				System.out.println(winner);
			}
			
			System.out.println("would you like to play again 0 for yes 1 for no");
			end = input.nextInt();
			while(end > 1 || end < 0)
			{
				System.out.println("would you like to play again 0 for yes 1 for no");
				end = input.nextInt();
			}
		}

	}

}
