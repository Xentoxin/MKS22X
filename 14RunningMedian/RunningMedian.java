public class RunningMedian{

    private MyHeap max, min;
    private int size1, size2, median1, median2;

    public RunningMedian(){
        max = new MyHeap(false); 
        min = new MyHeap();
    }

    public void add(int num){
        if (size1 - size2 > 1 || size2 - size1 > 1){
            System.out.println("Here! " + num);
            return;
        }
        if (size1 + size2 == 0){
            median1 = num;
            median2 = num;
            min.add(num);
            size1 ++;
        }
        else if (size1 + size2 == 1){
            if (min.peek() > num){
                switchToMax();
                min.add(num);
            }
            else max.add(num);
            median2 = num;
            size2 ++;
        }
        else if ((size1 + size2) % 2 == 0){
            if (min.peek() > num){
                min.add(num);
                size1 ++;
                median1 = min.peek();
                median2 = min.peek();
            }
            else {
                max.add(num);
                size2 ++;
                median1 = max.peek();
                median2 = max.peek();
            }
        } 
        else {
            if (size1 > size2){
                if (min.peek() > num){
                    switchToMax();
                    min.add(num);
                }
                else max.add(num);
                size2 ++;
            }
            else {
                if (max.peek() < num){
                    switchToMin();
                    max.add(num);
                }
                else min.add(num);
                size1 ++;
            }
            median1 = min.peek();
            median2 = max.peek();
        }
    }

    private void switchToMax(){
        max.add(min.remove());
    }

    private void switchToMin(){
        min.add(max.remove());
    }

    public double getMedian(){
        System.out.println(min + ", " + max);
        return (median1 + median2) / 2.0;
    }

}