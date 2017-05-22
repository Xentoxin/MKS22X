package tiffanys;
import java.util.*;

public class QueueFrontier implements Frontier{

	private LinkedList<Location> frontier;

	public QueueFrontier(){
		frontier = new LinkedList<Location>();
	}

	public void add(Location l){
		frontier.add(l);
	}

	public Location next(){
		return frontier.remove();
	}

	public Location peek(){
		return frontier.peek();
	}

	public int size(){
		return frontier.size();
	}

	public boolean hasNext(){
		return !(frontier.peek() == null);
	}

}