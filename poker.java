package homework;

import java.util.Arrays;
import java.util.Scanner;

public class poker {
	
	public static class method{
		//将poker转换为数字
		public static int change(char Char) {
			if(Char == '2') {
				return 1;
			}
			else if(Char == '3') {
				return 2;
			}
			else if(Char == '4') {
				return 3;
			}
			else if(Char == '5') {
				return 4;
			}
			else if(Char == '6') {
				return 5;
			}
			else if(Char == '7') {
				return 6;
			}
			else if(Char == '8') {
				return 7;
			}
			else if(Char == '9') {
				return 8;
			}
			else if(Char == 'T') {
				return 9;
			}
			else if(Char == 'J') {
				return 10;
			}
			else if(Char == 'Q') {
				return 11;
			}
			else if(Char == 'K') {
				return 12;
			}
			else if(Char == 'A') {
				return 13;
			}
			return 0;
		}
		//判断是否为顺子
		public static boolean straight(int []arr) {
			int number = 1;
			for(int i = 0; i < 4; i++) {
				if(arr[i] + 1 == arr[i+1]) {
					number++;
				}
			}
			if(number == 5) {
				return true;
			}
			else {
				return false;
			}
		}
		//判断是否为同花
		public static boolean samefigure(String str) {
			int number = 1;
			for(int i = 0; i < 4; i++) {
				if(str.charAt(3*i+1) == str.charAt(3*i+4)) {
					number++;
				}
			}
			if(number == 5) {
				return true;
			}
			else {
				return false;
			}
		}
		//判断是否有三张相同
		public static boolean threesame(int []arr) {
			int number = 1;
			for(int i = 0; i < 3; i++) {
				if((arr[i] == arr[i+1])&&(arr[i] == arr[i+2])) {
					number++;
				}
			}
			if(number == 2) {
				return true;
			}
			else {
				return false;
			}
		}
		//判断是否有两对对子
		public static boolean twotwosame(int []arr) {
			int number = 0;
			for(int i = 0; i < 4; i++) {
				if(arr[i] == arr[i+1]) {
					number++;
				}
			}
			if((number == 2 || number == 3)&&(method.threesame(arr) == false)) {
				return true;
			}
			else {
				return false;
			}
		}
		//判断是否只有一对对子
		public static boolean onetwosame(int []arr) {
			int number = 1;
			for(int i = 0; i < 4; i++) {
				if(arr[i] == arr[i+1]) {
					number++;
				}
			}
			if(number == 2) {
				return true;
			}
			else {
				return false;
			}
		}
		//判断等级
		public static int grade(boolean Straight, boolean SameFigure, boolean ThreeSame, boolean TwoTwoSame, boolean OneTwoSame) {
			if(SameFigure == true) {
				if(Straight == true) {
					return 7;
				}
				else {
					return 6;
				}
			}
			else {
				if(Straight == true) {
					return 5;
				}
				else if(ThreeSame == true) {
					return 4;
				}
				else if(TwoTwoSame == true) {
					return 3;
				}
				else if(OneTwoSame == true) {
					return 2;
				}
				else {
					return 1;
				}
			}
		}
		//等级相同时进行判断
		public static void judgement(int grade1, int grade2, int []arr1, int []arr2) {
			if((grade1 == 1)&&(grade2 == 1)) {
				int number = 0;
				for(int i = 4; i >= 0; i--) {
					if(arr1[i] != arr2[i]) {
						if(arr1[i] > arr2[i]) {
							System.out.println("Black wins");
							break;
						}
						if(arr1[i] < arr2[i]) {
							System.out.println("White wins");
							break;
						}
					}
					else {
						number++;
					}
				}
				if(number == 5) {
					System.out.println("Tie");
				}
			}
			else if((grade1 == 2)&&(grade2 == 2)) {
				int number1 = 0, number2 = 0;
				for(int i = 0; i < 4; i++) {
					if(arr1[i] == arr1[i+1]) {
						number1 = arr1[i];
						arr1[i] = -1;
						arr1[i+1] = -1;
						break;
					}
				}
				for(int i = 0; i < 4; i++) {
					if(arr2[i] == arr2[i+1]) {
						number2 = arr2[i];
						arr2[i] = -1;
						arr2[i+1] = -1;
						break;
					}
				}
				if(number1 > number2) {
					System.out.println("Black wins");
				}
				else if(number1 < number2) {
					System.out.println("White wins");
				}
				else {
					int number = 0;
					Arrays.sort(arr1);
					Arrays.sort(arr2);
					for(int i = 4; i >= 2; i--) {
						if(arr1[i] != arr2[i]) {
							if(arr1[i] > arr2[i]) {
								System.out.println("Black wins");
							}
							if(arr1[i] < arr2[i]) {
								System.out.println("White wins");
							}
						}
						else {
							number++;
						}
					}
					if(number == 3) {
						System.out.println("Tie");
					}
				}
			}
			else if((grade1 == 3)&&(grade2 == 3)) {
				int number1 = 0, number2 = 0;
				for(int i = 3; i >= 0; i--) {
					if(arr1[i] == arr1[i+1]) {
						number1 = arr1[i];
						break;
					}
				}
				for(int i = 3; i >= 0; i--) {
					if(arr2[i] == arr2[i+1]) {
						number2 = arr2[i];
						break;
					}
				}
				if(number1 > number2) {
					System.out.println("Black wins");
				}
				else if(number1 < number2) {
					System.out.println("White wins");
				}
				else {
					number1 = 0;
					number2 = 0;
					for(int i = 2; i >= 0; i--) {
						if(arr1[i] == arr1[i+1]) {
							number1 = arr1[i];
							break;
						}
					}
					for(int i = 3; i >= 0; i--) {
						if(arr2[i] == arr2[i+1]) {
							number2 = arr2[i];
							break;
						}
					}
					if(number1 > number2) {
						System.out.println("Black wins");
					}
					else if(number1 < number2) {
						System.out.println("White wins");
					}
					else {
						if(arr1[0] > arr2[0]) {
							System.out.println("Black wins");
						}
						else if(arr1[0] < arr2[0]) {
							System.out.println("White wins");
						}
						else {
							System.out.println("Tie");
						}
					}
				}
			}
			else if((grade1 == 4)&&(grade2 == 4)) {
				int number1 = 0, number2 = 0;
				for(int i = 0; i < 3; i++) {
					if((arr1[i] == arr1[i+1])&&(arr1[i] == arr1[i+2])) {
						number1 = arr1[i];
						arr1[i] = -1;
						arr1[i+1] = -1;
						arr1[i+2] = -1;
						break;
					}
				}
				for(int i = 0; i < 3; i++) {
					if((arr2[i] == arr2[i+1])&&(arr2[i] == arr2[i+2])) {
						number2 = arr2[i];
						arr2[i] = -1;
						arr2[i+1] = -1;
						arr2[i+2] = -1;
						break;
					}
				}
				if(number1 > number2) {
					System.out.println("Black wins");
				}
				else if(number1 < number2) {
					System.out.println("White wins");
				}
				else {
					int number = 0;
					Arrays.sort(arr1);
					Arrays.sort(arr2);
					for(int i = 4; i >= 3; i--) {
						if(arr1[i] != arr2[i]) {
							if(arr1[i] > arr2[i]) {
								System.out.println("Black wins");
							}
							if(arr1[i] < arr2[i]) {
								System.out.println("White wins");
							}
						}
						else {
							number++;
						}
					}
					if(number == 2) {
						System.out.println("Tie");
					}					
				}
			}
			else if((grade1 == 5)&&(grade2 == 5)) {
				if(arr1[4] > arr2[4]) {
					System.out.println("Black wins");
				}
				else if(arr1[4] < arr2[4]) {
					System.out.println("White wins");
				}
				else {
					System.out.println("Tie");
				}
			}
			else if((grade1 == 6)&&(grade2 == 6)) {
				int number = 0;
				for(int i = 4; i >= 0; i--) {
					if(arr1[i] != arr2[i]) {
						if(arr1[i] > arr2[i]) {
							System.out.println("Black wins");
							break;
						}
						if(arr1[i] < arr2[i]) {
							System.out.println("White wins");
							break;
						}
					}
					else {
						number++;
					}
				}
				if(number == 5) {
					System.out.println("Tie");
				}
			}
			else if((grade1 == 7)&&(grade2 == 7)) {
				if(arr1[4] > arr2[4]) {
					System.out.println("Black wins");
				}
				else if(arr1[4] < arr2[4]) {
					System.out.println("White wins");
				}
				else {
					System.out.println("Tie");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1, str2;
		int arr1[] = new int[5];
		int arr2[] = new int[5];
		int grade1, grade2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Black:");
		str1 = sc.nextLine();
		System.out.print("White:");
		str2 = sc.nextLine();
		for(int i = 0; i < 5; i++) {
			arr1[i] = method.change(str1.charAt(3*i));
		}
		for(int i = 0; i < 5; i++) {
			arr2[i] = method.change(str2.charAt(3*i));
		}
		//数组arr进行由小到大排序
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		grade1 = method.grade(method.straight(arr1), method.samefigure(str1), method.threesame(arr1), method.twotwosame(arr1), method.onetwosame(arr1));
		grade2 = method.grade(method.straight(arr2), method.samefigure(str2), method.threesame(arr2), method.twotwosame(arr2), method.onetwosame(arr2));
		if(grade1 > grade2) {
			System.out.println("Black wins");
		}
		else if(grade1 < grade2) {
			System.out.println("White wins");
		}
		else if(grade1 == grade2) {
			method.judgement(grade1, grade2, arr1, arr2);
		}
		
		sc.close();

	}

}
