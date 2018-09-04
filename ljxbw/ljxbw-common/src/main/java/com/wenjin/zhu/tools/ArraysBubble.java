package com.wenjin.zhu.tools;


/**
 * 
 * 
 * @Title: ArraysBubble.java
 * @Package org.cybercafe.api.utils
 * @Description: TODO(冒泡算法，让数组从小到大排序)
 * @author: wenjin.zhu
 * @date: 2018年8月8日 上午11:30:43
 * @version V1.0
 */
public class ArraysBubble {
	public static void main(String args[]) {
		/*int[] arr = { 2, 1, 3, 4, 6, 5, 7, 8, 9, 0, 10 };
		// N是数组的元素个数，这样无论多少个数，直接修改arr中的元素就行了，
		// 不需要调整循环次数
		int N = arr.length;
		int temp = 0;
		// 冒泡排序：每次把最大的放到最后，N-i是因为第i次排序之后，
		// 数组arr的最后i个数已经是按照大小顺序的了，所以不需要再排序了
		// 比如第一次排序之后，最后一个数肯定是最大的，下一次只需要排前9个就行了。
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < N - i; ++j) {
				// 如果前面的数比后面的大，则不是按照顺序的，因此要交换
				if (arr[j] > arr[j + 1]) {
					temp = arr[j]; // 交换2个数
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < N; ++i) // 输出排序后的结果
		{
			System.out.print(arr[i] + "  ");
		}*/

		
		
		test();
	}
	
	
	
	public static void test() {
		int temp22 = 1,temp28 = 8,temp33 = 1,temp34 = 1;
		
		
		int[] arr = { temp22,temp28,temp33,temp34};
		int N = arr.length;
		int temp = 0;
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < N - i; ++j) {
				// 如果前面的数比后面的大，则不是按照顺序的，因此要交换
				if (arr[j] > arr[j + 1]) {
					temp = arr[j]; // 交换2个数
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < N; ++i) // 输出排序后的结果
		{
			System.out.print(arr[i] + "  ");
			if(arr[i]==temp22) {
				temp22=5-i;
			}
			if(arr[i]==temp28) {
				temp28=5-i;
			}
			if(arr[i]==temp33) {
				temp33=5-i;
			}
			if(arr[i]==temp34) {
				temp34=5-i;
			}
			
		}
		System.out.println( "");
		
		System.out.println("22:"+temp22+" 28:"+temp28+"   33:"+temp33+"   34:"+temp34);
		
	}
}