package me.efraimgentil.sampleejbconsumer;

import java.util.ArrayList;
import java.util.Optional;

class B extends Des{  }

public class Des {

	public Des() {
		// TODO Auto-generated constructor stub
		String a = "test";
		System.out.println( a == new String(a) );
		Integer b = Teste.B;
	}

	public static void main(String[] args) {
		String a = "test";
		System.out.println( a == new String(a) );
	}
	
}
