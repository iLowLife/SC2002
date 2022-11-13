package pack;

/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class sort{
    
	/** 
	 * @param arr
	 * @param arr1
	 */
	public static void insertionSort(double[] arr,String[] arr1) {
		for(int i=1;i<arr.length;i++) {
			double ratingScore=arr[i];
			String movieName=arr1[i];
			int j=i;
			while(j>0&& arr[j-1]<ratingScore) {
				arr[j]=arr[j-1];
				arr1[j]=arr1[j-1];
				j--;
			}
			arr[j]=ratingScore;
			arr1[j]=movieName;
		}
    } 
}
	