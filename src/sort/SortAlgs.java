package sort;

import java.util.Random;

public class SortAlgs {

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public static int partition(int[] list, int first, int last) {
        if (last < first) {
            return -1;
        }
        if (last == first) {
            return first;
        }

        Random random = new Random();
        int pivot = first + random.nextInt(last - first + 1);
        //int pivot = 2;
        System.out.println("pivot" + pivot);
        swap(list, first, pivot);

        int low = first + 1;
        int high = last;

        while (high > low) {
            while (high > low && list[low] < list[first]) {
                ++low;
            }
            while (high > low && list[high] >= list[first]) {
                --high;
            }
            if (high > low) {
                swap(list, high, low);
                ++low;
                --high;
            }
        }
        /*
         * The first case is that:
		 * high and low missed each other by swap and ++low, --high.
		 * then , we could be sure that the position of high is the right position for pivot.
		 */
        if (list[high] < list[first] && low > high) {
            swap(list, high, first);
            return high;
        }
        /*
         *  low and high went together in some cases
		 */
        else {
            //check from right to left to find the proper position for pivot.
            while (high > first && list[high] >= list[first]) {
                --high;
            }
            if (high == first) {
                return first;
            }
            //if first is reached that means list[first] is the lowest one in the current
            //ranges and thus does not need to be swapped
            else {
                swap(list, first, high);
                return high;
            }
        }
    }

    public static int partition2(int[] list, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return start;
        }

        Random random = new Random();
        int pivot = start + random.nextInt(end - start + 1);
        swap(list, start, pivot);

        int left = start + 1;
        int right = end;
        while (right > left) {
            while (right > left && list[left] < list[start]) {
                ++left;
            }
            while (right > left && list[right] >= list[start]) {
                --right;
            }
            if (right > left) {
                swap(list, left, right);
                ++left;
                --right;
            }
        }

        if (left > right && list[right] < list[start]) {
            swap(list, start, right);
            return right;
        } else {
            if (right > start) {
                while (right > start && list[right] >= list[start]) {
                    --right;
                }
                swap(list, right, start);
                return right;
            } else {
                return start;
            }
        }

    }


    private static int partition3(int[] num, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return right;
        }

        Random random = new Random();
        int pivot = left + random.nextInt(right - left + 1);
        swap(num, left, pivot);

        int low = left + 1;
        int high = right;
        while (high > low) {
            while (high > low && num[high] >= num[left]) {
                --high;
            }
            while (high > low && num[low] < num[left]) {
                ++low;
            }
            if (low < high) {
                swap(num, low, high);
                ++low;
                --high;
            }
        }

        if (low > high && num[high] < num[left]) {
            swap(num, high, left);
            return high;
        } else {
            while (high > left && num[high] >= num[left]) {
                --high;
            }
            swap(num, left, high);
            return high;
        }
    }

//    private static int partitionX(int[] num, int left, int right) {
//        if (left > right) {
//            return left;
//        }
//        if (left == right) {
//            return right;
//        }
//        Random random = new Random();
//        int pivot = left + random.nextInt(right - left + 1);
//        swap(num, left, pivot);
//
//        int low = left + 1;
//        int high = right;
//
//        while (high > low) {
//            //find the left most number that is larger than pivot
//            while (low < high && num[low] <= num[left]) {
//                ++low;
//            }
//            //find the right most number that is smaller than or equal to pivot
//            while (low < high && num[high] > num[left]) {
//                --high;
//            }
//            if (low < high) {
//                swap(num, low, high);
//                ++low;
//                --high;
//            }
//
//        }
//
//    }


    private static void mergeSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(a, low, mid);

        mergeSort(a, mid + 1, high);

        merge(a, low, mid, high);
    }


    public static void merge(int[] a, int low, int mid, int high) {
        int[] auk = new int[a.length];

        int i = low;
        int j = mid + 1;

        for (int n = low; n <= high; n++) {
            auk[n] = a[n];
        }

        for (int n = low; n <= high; n++) {
            if (i > mid) {
                a[n] = auk[j++];
            } else if (j > high) {
                a[n] = auk[i++];
            } else if (auk[i] < auk[j]) {
                a[n] = auk[i++];
            } else {
                a[n] = auk[j++];
            }
        }
    }

    private static void swap(int[] a, int x, int y) {
        //System.out.println("swap : " + x + ", " + y);
        if (x == y) {
            return;
        }
        a[x] = a[x] ^ a[y];
        a[y] = a[x] ^ a[y];
        ;
        a[x] = a[x] ^ a[y];
    }


    public static void quicksort(int[] a, int left, int right) {
        //System.out.println("left " + left + "\t right "+ right);
        //show(a);

        if (left >= right) {
            return;
        }
        int p = partition5(a, left, right);
        quicksort(a, left, p - 1);
        quicksort(a, p + 1, right);
    }

    public static void show(int[] a) {
        for (int n = 0; n < a.length; n++) {
            System.out.print("a[" + n + "] = " + a[n] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 3, 6, 9, 1};
        //quicksort(a,0,a.length-1);
        //System.out.println(partition(a, 0, 2));
        quicksort(a, 0, a.length - 1);
        show(a);

    }

    public static int partition5(int[] a, int left, int right) {
        // Get the pivot element
        int pivot = a[left];

        // Break when left is > right
        while (left <= right) {
            //increment the lower bound till you find the element more than the pivot
            while (a[left] < pivot) {
                left++;
            }
            //decrement the upper bound till you find the element less than the pivot
            while (a[right] > pivot) {
                right--;
            }

            // swap the values which are left by lower and upper bounds
            if (left <= right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }

}
