package arrays;

/**
 * Created by shuailu on 5/31/16.
 */
public class SearchInRotatedArray {

    public static int find(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    private static int find(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] >= nums[left]) {
            //pivot on right
            if (target < nums[mid] && target >= nums[left]) {
                //target falls in non-pivot range, search left
                return find(nums, left, mid - 1, target);
            } else {
                //search right
                return find(nums, mid + 1, right, target);
            }
        } else {
            //pivot on left
            if (target > nums[mid] && target <= nums[right]) {
                //search right
                return find(nums, mid + 1, right, target);
            } else {
                //search left
                return find(nums, left, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] {1, 3, 5}, 1));
    }
}
