package mx.com.geekflu.algo.prep.binary.search;

public class PeakIndexInAMountain {

  public static int peakIndexInMountainArray(int[] arr) {

    if (arr.length < 3) {
      return -1;
    }

    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
      int mid = start + (end - start) / 2;
      int midValue = arr[mid];

      if (mid > 0 && midValue > arr[mid - 1] && midValue > arr[mid + 1]) {
        return mid;
      }

      if (descending(arr, mid)) {
        end = mid - 1;
      }else if(ascending(arr, mid)) {
        start = mid + 1;
      }
    }

    return -1;
  }

  public static boolean descending(int[] arr, int mid) {
    return mid > 0 && arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1];
  }

  public static boolean ascending(int[] arr, int mid) {
    return ((mid <= 0) || (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]));
  }


}
