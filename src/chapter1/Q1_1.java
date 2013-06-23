package chapter1;

import junit.framework.Assert;

public class Q1_1 {
	public static void main(String[] args){
		String a="";
		Assert.assertTrue(isUniqueChar(a));
		
		String b="280sjre\t\n!$%&()";
		Assert.assertTrue(isUniqueChar(b));
		
		String c="280sjre\te\n!$%&()";
		Assert.assertFalse(isUniqueChar(c));

	}
	
	public static boolean isUniqueChar(String s){
		if(s==null){
			throw new IllegalArgumentException();
		}
		if(s.length()>256){
			return false;
		}
		int value=0;
		int offset=0;
		int mask=0;
		int[] bitmap=new int[8];
		for(int i=0;i<s.length();i++){
			value=s.charAt(i) & 0xFF;
			offset=value>>5;
			mask=1<<(value&0x1F);
			if((bitmap[offset] & mask)>0){
				return false;
			}else{
				bitmap[offset]|=mask;
			}
		}
		return true;
	}
}
