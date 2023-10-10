package NumSorting2;
import java.util.*;
import java.io.*;


/* N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�. */

public class NumSorting2 {
	
	/* mergeSort�Լ��� �迭�� 2���� ������ �����մϴ�. */
	
	public static void mergeSort(int[] arr, int left, int right) {	
		
		if(left < right) {
			int middle = (left + right) / 2;
			
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			
			merge(arr, left, middle, right);
		}
		
		
	}
	/* merge�� ���ĵ� 2���� �迭�� �ϳ��� �迭�� ��ġ�� ������ �մϴ�. */
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
	/* bufferedReader�� ���� ���ڸ� �Է¹޾� �迭�� �ʱ�ȭ�ϰ� mergeSort �Լ��� �μ��� �Ѱ��ش�. */
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