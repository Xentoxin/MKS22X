package tiffanys;
import java.util.*;

public class MyHeap{
    
    private int size;
    private boolean type;
    private ArrayList<Location> heap;

    public MyHeap(){
        this(true);
    }

    public MyHeap(boolean mode){
        type = mode;
        size = 0;
        heap = new ArrayList<Location>();
        heap.add(new Location());
    }

    public void add(Location s){
        heap.add(s);
        size ++;
        moveUp();
    }

    public Location remove(){
        Location s;
        if (size == 1) s = heap.remove(size);
        else s = heap.set(1, heap.remove(size));
        size --;
        moveDown();
        return s;
    }

    public Location peek(){
        return heap.get(1);
    }

    public int size(){
        return size;
    }

    private void moveUp(){
        int index = size;
        if (type){
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) > 0){
                Location temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
        else {
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) < 0){
                Location temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
    }

    private void moveDown(){
        int index = 1;
        boolean welp = true;
        if (type){
            while (index * 2 < size && welp){
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left > 0 && right > 0) welp = false;
                else if (left > right){
                    Location temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    Location temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }
            }
        }
        else {
            while (index * 2 < size && welp){
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left < 0 && right < 0) welp = false;
                else if (left < right){
                    Location temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    Location temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }

            }
        }
    }

    public String toString(){
        return heap.toString();
    }

}