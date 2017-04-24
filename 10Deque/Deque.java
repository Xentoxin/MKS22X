import java.util.*;
public class Deque {
private String[] queue;
private int start, end, size;
public Deque(){
	queue = new String[10];
}
private void resize(){
	String[] X  =new String[queue.length*2];
	int counter = start; 
	int index = 0;
	while (counter != end){
        X[index] =  queue[counter];
        counter ++;
        index ++;
        counter = counter % queue.length;
    } 
	X[index] = queue[end];
    start = 0;
    end = index;
    queue = X;
}
public void addFirst(String s){
	if((end +1) % queue.length == start) {
		resize();
}
	queue[(start - 1 + queue.length) % queue.length] = s;
    start --;
    size ++;
    start = (start + queue.length) % queue.length;
    if (size == 1){
        end --;
        end = end % queue.length;
    }
}
public void addLast(String s){
	 if ((end + 1) % queue.length == start) resize();
     queue[(end + 1) % queue.length] = s;
     end ++;
     size ++;
     end = end % queue.length;
     if (size == 1){
         start ++;
         start = (start + queue.length) % queue.length;
     }
}
public String removeFirst(){
    String s = queue[start];
    start ++;
    start = start % queue.length;
    size --;
    return s;
}

public String removeLast(){
    String s = queue[end];
    end --;
    end = end % queue.length;
    size --;
    return s;
}

public String getFirst(){
    return queue[start];
}

public String getLast(){
    return queue[end];
}

public String toString(){
    String s = "";
    for (int i = 0; i < queue.length; i ++){
        if (queue[i] == null) s += "null ";
        else s += queue[i].toString() + " ";
    }
    s += "\n" + "start: " + start + " end: " + end;
    return s;
}
}

