package com.org.ms.registerService.service;

import java.util.LinkedHashMap;

public class NonDuplicateChar {
	public static char nondupicate(String str){
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		char nonrepeat = 0;
		if(str.length()==1){
			return str.charAt(0);
		}else{
			for(int i=0;i<str.length();i++){
				char c = str.charAt(i);
				if(map.containsKey(c)){
					int count = map.get(c);
					map.put(c, (count+1));
				}else{
					map.put(c, 1);
				}
			}
			
		}
		for(int i=0;i<str.length();i++){
			nonrepeat = str.charAt(0);
			char c =str.charAt(i);
			if(map.get(c)==1){
				nonrepeat=c;
				break;
			}
		}
		return nonrepeat;
	}
	public static void main(String[] args) {
		char nrp =nondupicate("yellow");
		char nrp1 =nondupicate("tooth");
		System.out.println(""+nrp);
		System.out.println(""+nrp1);
	}

}
