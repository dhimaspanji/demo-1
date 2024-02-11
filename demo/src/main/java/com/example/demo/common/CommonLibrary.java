package com.example.demo.common;

public class CommonLibrary {

	public void reverseString(String str) {
		String nstr = "";
		char ch;

		System.out.println("Input : " + str);

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			nstr = ch + nstr;
		}

		System.out.println("Output : " + nstr);
	}
	
	public void primeNumber(int n) {
		int i, count;
		
		for (int j = 1; j <= n; j++) {
			count = 0;
		
			for(i = 1; i <= j; i++) {
				if (j % i == 0) {
					count++;
				}
			}
			
			if(count == 2) {
				System.out.println("Bilangan Prima " + j + "  ");     
			} else {
				System.out.println(j + "  ");
			}
		}
	}
}
