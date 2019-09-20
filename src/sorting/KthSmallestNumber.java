public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 5, 3, 8, 10, 9};
        int k = 7;
        quickSort(arr, 0, arr.length - 1, k);
        System.out.println(k + " th smallest number in array is " + arr[k-1]);
    }

    public static void quickSort(int[] arr, int beg, int end, int k) {
        if (beg <= end) {
            int ind = partitionArray(arr, beg, end);
            if (ind == k - 1) {
                return;
            }
            if (ind > k - 1) {
                quickSort(arr, beg, ind - 1, k);
            } else if (ind < k - 1) {
                quickSort(arr, ind + 1, end, k);
            }
        }
    }

    public static int partitionArray(int[] arr, int beg, int end) {
        int mid = ((beg + end) / 2);
        int pivotInd = getMedian(beg, mid, end, arr);
        int pivot = arr[pivotInd];

        swap(arr, pivotInd, end); // place pivot at the end

        int leftPointer = beg;
        int rightPointer = end - 1;

        while (leftPointer <= rightPointer) {
            while (leftPointer <= end && arr[leftPointer] < pivot) {
                leftPointer++;
            }
            while (rightPointer >= beg && arr[rightPointer] > pivot) {
                rightPointer--;
            }
            if (leftPointer < rightPointer) {
                swap(arr, leftPointer, rightPointer);
            }
        }
        swap(arr, leftPointer, end); // place pivot at it's correct position
        return leftPointer;
    }

    public static int getMedian(int a, int b, int c, int[] arr) {
        int x = arr[a] - arr[b];
        int y = arr[b] - arr[c];
        int z = arr[a] - arr[c];
        int mid;
        if (x * y > 0) {
            mid = b;
        } else if (x * z > 0) {
            mid = c;
        } else {
            mid = a;
        }
        return mid;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
