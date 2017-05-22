package tiffanys;
import java.util.*;;
public class StackFrontier implements Frontier{

	private Stack<Location> frontier;
	private int size;

	public StackFrontier(){
		frontier = new Stack<Location>();
	}

	public void add(Location l){
		frontier.push(l);
		size ++;
	}

	public Location next(){
		size --;
		return frontier.pop();
	}

	public Location peek(){
		return frontier.peek();
	}

	public int size(){
		return size;
	}

	public boolean hasNext(){
		return !(frontier.peek() == null);
	}

}