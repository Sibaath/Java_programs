import java.util.Scanner;

public class merge
{
    static int count  = 0;
public static void merge_sort(int a[],int leftpos, int rightpos, int rightend){
    int[] tempArray = new int[100];
    int i;
	int leftend=rightpos-1;
	int temppos=leftpos; 
	int numelements=rightend-leftpos+1;
	while(leftpos<=leftend && rightpos<=rightend)
	{
		if(a[leftpos]<=a[rightpos]) tempArray[temppos++]=a[leftpos++];
		else 
        {
            tempArray[temppos++]=a[rightpos++];
            count++;
        }
	}
	while(leftpos<=leftend)
		 tempArray[temppos++]=a[leftpos++];
	while(rightpos<=rightend) 
		tempArray[temppos++]=a[rightpos++];
	for(i=0;i<numelements;++i,--rightend) 
		a[rightend]=tempArray[rightend];
}
public static void mergesort(int arr[],int left,int right){
	int mid;
	if(left<right){
		mid=(left+right)/2;
		mergesort(arr,left,mid);
		mergesort(arr,mid+1,right);
		merge_sort(arr, left, mid+1, right);
	}
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr1 = {58,
        3,
        2,
        30,
        71,
        80,
        57,
        68,
        98,
        55,
        81,
        52,
        69,
        41,
        67,
        61,
        47,
        75,
        5,
        10,
        26,
        85,
        29,
        28,
        90,
        37,
        91,
        49,
        50,
        13,
        93,
        8,
        97,
        36,
        82,
        7,
        17,
        78,
        99,
        96,
        39,
        44,
        70,
        74,
        35,
        46,
        73,
        15,
        63,
        77,
        51,
        60,
        45,
        79,
        18,
        62,
        14,
        31,
        84,
        56,
        92,
        88,
        11,
        34,
        21,
        23,
        66,
        12,
        4,
        48,
        64,
        40,
        42,
        72,
        1,
        59,
        65,
        76,
        20,
        6,
        94,
        43,
        19,
        27,
        25,
        83,
        24,
        86,
        33,
        9,
        87,
        38,
        22,
        54,
        53,
        16,
        32,
        89,
        0,
        95};
mergesort(arr1,0,arr1.length-1);
for(int i=0;i<arr1.length;i++){
    System.out.println(arr1[i]);
}
System.out.println(count);

}
}


