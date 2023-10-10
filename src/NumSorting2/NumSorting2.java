package NumSorting2;
import java.util.*;
import java.io.*;


/* N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오. */

public class NumSorting2 {
	
	/* mergeSort함수는 배열을 2개로 나누어 정렬합니다. */
	
	public static void mergeSort(int[] arr, int left, int right) {	
		
		if(left < right) {
			int middle = (left + right) / 2;
			
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			
			merge(arr, left, middle, right);
		}
		
		
	}
	/* merge는 정렬된 2개의 배열을 하나의 배열로 합치는 역할을 합니다. */
	public static void merge(int[] arr, int left, int middle, int right) {
		
		
		int n1 = middle+1-left;
		int n2 = right - middle;
		
		int[] arrleft = new int[n1];
		int[] arrright = new int[n2];
		
		for(int i = 0; i < n1; i++) {
			arrleft[i] = arr[i + left];
		}
		
		for(int i = 0; i < n2; i++) {
			arrright[i] = arr[i + middle+1];
		}
		
		int i = 0; int j = 0; int k = left;
		while(i < n1 && j < n2) {
			if(arrleft[i] <= arrright[j]) {
				arr[k] = arrleft[i];
				i++;
			} else {
				arr[k] = arrright[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = arrleft[i];
			i++;
			k++;
		}
		
		while(j <n2) {
			arr[k] = arrright[j];
			j++;
			k++;
		}
		
	}
	/* bufferedReader을 통해 숫자를 입력받아 배열을 초기화하고 mergeSort 함수에 인수를 넘겨준다. */
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Num = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[Num];
		
		for(int i = 0; i < Num; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		mergeSort(arr, 0, Num-1);
		
		for(int i = 0; i < Num; i++) {
			bw.write(String.valueOf(arr[i] + "\n"));
		}
		bw.flush();
		bw.close();
	}
}