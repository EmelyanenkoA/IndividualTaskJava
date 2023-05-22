public class WorkedThread extends Thread
{
    int max = Integer.MIN_VALUE;
    int[] arr;

    public WorkedThread (int [] arr){
        this.arr = arr;
    }
    public void run (){
        for (int j : arr) {
            max = Math.max(max, j);
        }
    }
    public int getMax(){
        return max;
    }
}
