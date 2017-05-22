package tiffanys;

public interface Frontier {
	public void add(Location l);
	public Location next();
	public Location peek();
	public int size();
	public boolean hasNext();

}
