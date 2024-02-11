package com.example.demo;

import java.util.Scanner;

import com.example.demo.common.CommonLibrary;

public class Demo {

	public static void main(String[] args) {
		// Reverse String
		CommonLibrary common = new CommonLibrary();
		
		common.reverseString("Great");
		
		System.out.println("\n");
		
		// Prime Number
		System.out.print("Masukkan bilangan 1 s/d 100 : ");
		
		Scanner sc = new Scanner(System.in);

		System.out.println();

		int n = sc.nextInt();

		if (n > 100) {
			System.out.println("Maaf bilangan yang anda masukkan lebih besar dari 100");
		} else {			
			common.primeNumber(n);
		}
	}
}
