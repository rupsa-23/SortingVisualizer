import javax.swing.JPanel;

public class SortAlgorithm {
    public static void bubbleSort(int[] arr, JPanel panel)
    {
        try {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        panel.repaint();
                        Thread.sleep(10);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectionSort(int[] arr, JPanel panel)
    {
        try {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
                panel.repaint();
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void insertionSort(int[] arr,JPanel panel)
    {
        try {
            for(int i=0;i< arr.length;i++)
            {
                int key=arr[i];
                int j=i-1;
                while (j>=0 && arr[j]>key)
                {
                    arr[j+1]=arr[j];
                    j=j-1;
                }
                arr[j+1]=key;
                panel.repaint();
                Thread.sleep(20);
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
