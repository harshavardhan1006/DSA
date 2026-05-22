class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int min = -1;
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(mid-1 >= 0 && mid+1 < arr.length && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            if(arr[mid] < arr[mid+1]) low = mid + 1;
            else if(arr[mid] < arr[mid-1]) high = mid - 1;
        }
        return low+1;
    }
}