package pack;
public class sort{
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
	