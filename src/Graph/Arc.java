package Graph;

public class Arc extends Edge{

	boolean reversed;
	
	public Arc(Edge edge,boolean reversed) {
		super(edge.getSource(),edge.getDest(),edge.weight);
		this.reversed = reversed;
	}
	
	public int getSource() {
		return (reversed ? this.getDest() : this.getSource());
	}
	
	public int getDest() {
		return (reversed ? this.getSource() : this.getDest());
	}
	
}
