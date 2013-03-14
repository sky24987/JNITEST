package com.zhanghan.app;

import java.io.UnsupportedEncodingException;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.WString;

public class JNITest {

	public interface TestDll1 extends Library {
		TestDll1 INSTANCE = (TestDll1) Native.loadLibrary("TndGetComData",TestDll1.class);

		public boolean GetRzxComData(byte value[], int size);

	}

	
	public void getMessage(){
		byte bt[] = new byte[10];
		while(true){
			boolean b = TestDll1.INSTANCE.GetRzxComData(bt,12);
			if(b){
				System.out.println(b);
				try {
					
					
					System.out.println("ÄÚÈÝ:"+new String(bt,"gbk"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getMessage();
				break;
			}
			
		}
		
	}
	
	public static void main(String a[]) {
		JNITest jni = new JNITest();
		jni.getMessage();
		
	}

}
