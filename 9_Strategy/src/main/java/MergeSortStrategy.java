public class MergeSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] array) {
        mergeSort(array ,0, array.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2){
            if (leftArray[i] <= rightArray[j]){
                arr[k++] = leftArray[j++];
            }else {
                arr[k++] = rightArray[j++];
            }
        }
        while(i < n1){
            arr[k++] = leftArray[i++];
        }
        while(j < n2){
            arr[k++] = rightArray[j++];
        }
    }

    @Override
    public String getName(){
        return "Merge sort";
    }
}
