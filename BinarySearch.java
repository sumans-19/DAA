public class BinarySearch {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9};
        int target = 7;
        int index= search(nums, target);
        System.out.println(index);

    }

        public static int search(int[] nums, int target) {
            int len = nums.length;
            int start = 0;
            int end = len-1;
    
            while(start<=end){
                 int mid = start + (end-start) /2;
                 if(target<nums[mid]){
                    end = mid-1;
                 } else if (target > nums[mid]){
                    start = mid+1;
                 }
                 else{
                    return mid;
                 }
    
            }
            return -1;
    
        }
    }

