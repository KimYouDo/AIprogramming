import java.util.ArrayList;
import java.util.Random;
import mineSweeper.*;

public class main {
	static int temp_map_array[][];
	static Oracle oracle;
	static ArrayList<Coordinate> am;
	static Random random = new Random();

	public static void main(String args[]) {
		int nums[] = new int[3];
		StringBuffer clear_list = new StringBuffer();
		int Map_Size = 0;
		int clear;
		int bomb = 0;
		for (int stage = 1; stage <= 1; stage++) {
			clear_list.append("-----------------------------------------\n");
			System.out.println("\n------------------------Board " + stage + ".txt---------------------");
			clear_list.append("        Board " + Integer.toString(stage) + ".txt\n");
			clear_list.append("-----------------------------------------\n");
			oracle = new Oracle();
			for (int restart = 0; restart < 3; restart++) {
				clear = 0;
				oracle.restart(); // 게임 재 시작
				oracle.setMap("data/Board " + stage + ".txt"); // 해당 filePath에
																// 있는 파일을 읽어 map
																// 초기화
				Map_Size = oracle.getBoardSize(); // 게임 보드 크기 반환 (8, 16, 32,
													// or// custom)
				temp_map_array = new int[Map_Size][Map_Size];

				random_check(Map_Size);

				do {
					while (true) {
						if (open_check(Map_Size) == 0)
							break;
					}
					nums = check_map(Map_Size);
					//System.out.printf("- %d - %d - %d\n", nums[0], nums[1], nums[2]);
					if (8 <= nums[2]) {
						am = oracle.actionPerform(nums[0], nums[1], 1);
						//oracle.currentStatus();
						if (oracle.isGameOver())
							break;
						if (am.toString() != "[]" && am.toString() != null)
							map_temp(am.toString());
					}

					else if (bomb_check(Map_Size)) {
						clear = 1;
						break;
					}

					else if (oracle.isGameOver()) {
						break;
					} else {
						random_check(Map_Size);
					}

				} while (true);
				if (clear == 1)
					System.out.println("-----------------------------성  공------------------------------------");
				else
					System.out.println("-----------------------------실  패-------------------------------------");
				oracle.currentStatus();
				System.out.println("---------점-----수-----------");
				bomb = bomb_count(Map_Size);
				clear_list.append(Score(Map_Size, bomb));
				if (bomb == 0)
					restart--;
				if (clear == 1)
					break;
			}
			oracle.printScore();
		}
		System.out.print("\n" + clear_list);
	}

	private static void map_temp(String str) {
		int intput = 0;
		int x = 0, y = 0, val = 0;
		int len = temp_map_array[0].length;
		//System.out.println(str);
		String clean3 = str.replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]", "");
		String[] str2 = clean3.split(" ");

		for (int i = 0; i < str2.length; i += 3) {

			y = Integer.parseInt(str2[i]);

			x = Integer.parseInt(str2[i + 1]);

			val = Integer.parseInt(str2[i + 2]);
			if (val == 0)
				val = -1;
			else if (val == 99)
				val = 9;

			temp_map_array[x][y] = val;
			intput = 0;
		}
/*
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++)
				System.out.printf("%3d", temp_map_array[i][j]);
			System.out.println();
		}
		System.out.println();
*/
	}

	private static int[] check_map(int Map_Size) {
		int close = 0;
		int max_count = 0;
		int pass_chack_count = 0;
		int chose = 0;
		int nums[] = new int[3];
		int[][] check_map_array = new int[Map_Size][Map_Size];
		for (int i = 0; i < Map_Size; i++) {
			for (int j = 0; j < Map_Size; j++) {
				if (0 < temp_map_array[i][j] && 9 > temp_map_array[i][j]) {
					close = 0;

					for (int a = -1; a < 2; a++)
						for (int b = -1; b < 2; b++) {
							if (0 > a + i || 0 > b + j || Map_Size - 1 < a + i || Map_Size - 1 < b + j)
								;
							else if (temp_map_array[a + i][b + j] == 0)
								close++;
						}

					for (int a = -1; a < 2; a++)
						for (int b = -1; b < 2; b++) {
							if (0 > a + i || 0 > b + j || Map_Size - 1 < a + i || Map_Size - 1 < b + j)
								;
							else if (temp_map_array[a + i][b + j] == 0) {
								check_map_array[a + i][b + j] += (8 / close);
								if (max_count <= check_map_array[a + i][b + j]) {
									if (max_count == check_map_array[a + i][b + j]) {
										chose = random.nextInt(2);
										if (chose == 1) {
											nums[0] = b + j;
											nums[1] = a + i;
											nums[2] = max_count;
										}
									} else {
										max_count = check_map_array[a + i][b + j];
										nums[0] = b + j;
										nums[1] = a + i;
										nums[2] = max_count;
									}
								}
							}
						}
				}
			}
		}

	/*	for (int i = 0; i < Map_Size; i++) {
			for (int j = 0; j < Map_Size; j++)
				System.out.printf("%3d", check_map_array[i][j]);
			System.out.println();
		}
		System.out.println();
*/
		return nums;
	}

	private static int open_check(int Map_Size) {
		int change = 0;
		for (int i = 0; i < Map_Size; i++)
			for (int j = 0; j < Map_Size; j++) {
				if (temp_map_array[i][j] > 0 && temp_map_array[i][j] < 9) {
					int bomb = 0;
					for (int a = -1; a < 2; a++)
						for (int b = -1; b < 2; b++) {
							if (0 > a + i || 0 > b + j || Map_Size - 1 < a + i || Map_Size - 1 < b + j)
								;
							else if (temp_map_array[a + i][b + j] == 9)
								bomb++;
						}
					if (bomb == temp_map_array[i][j] && temp_map_array[i][j] != 0) {
						change = 1;
						temp_map_array[i][j] = -1;
						for (int a = -1; a < 2; a++)
							for (int b = -1; b < 2; b++) {
								if (0 > a + i || 0 > b + j || Map_Size - 1 < a + i || Map_Size - 1 < b + j)
									;
								else if (temp_map_array[a + i][b + j] == 0) {
									am = oracle.actionPerform(b + j, a + i, 0);
									//oracle.currentStatus();
									map_temp(am.toString());
								}
							}
					}
				}
			}
		return change;
	}

	private static Boolean bomb_check(int Map_Size) {
		int bomb = 0;
		for (int i = 0; i < Map_Size; i++)
			for (int j = 0; j < Map_Size; j++) {
				if (temp_map_array[i][j] == 9)
					bomb++;
			}

		if (Map_Size == 8)
			if (bomb == 10)
				return true;

		if (Map_Size == 16)
			if (bomb == 40)
				return true;

		if (Map_Size == 32)
			if (bomb == 150)
				return true;

		return false;
	}

	private static int bomb_count(int Map_Size) {
		int bomb = 0;
		for (int i = 0; i < Map_Size; i++)
			for (int j = 0; j < Map_Size; j++) {
				if (temp_map_array[i][j] == 9)
					bomb++;
			}
		if (Map_Size == 8)
			System.out.println(bomb + "/10");

		else if (Map_Size == 16)
			System.out.println(bomb + "/40");

		else if (Map_Size == 32)
			System.out.println(bomb + "/150");

		return bomb;
	}

	private static void random_check(int Map_Size) {
		int x = 0;
		int y = 0;
		while (true) {
			x = random.nextInt(Map_Size);
			y = random.nextInt(Map_Size);
			if (temp_map_array[x][y] == 0)
				break;
		}
		am = oracle.actionPerform(x, y, 0);
		//oracle.currentStatus();
		if (am.toString() != "[]" && am.toString() != null)
			map_temp(am.toString());

	}

	private static String Score(int Map_Size, int bomb) {
		String text = "";
		if (Map_Size == 8)
			text = Integer.toString(bomb) + "/10 => " + (double) bomb / 10 + "\n";

		else if (Map_Size == 16)
			text = Integer.toString(bomb) + "/40 => " + (double) bomb / 40 + "\n";

		else if (Map_Size == 32)
			text = Integer.toString(bomb) + "/150 => " + (double) bomb / 150 + "\n";
		return text;
	}
}
