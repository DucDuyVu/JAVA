package Shape;

public class Shape {
	private String color ="red";
	private boolean filled = true;
	public Shape() {
		super();
	}
	public Shape(String color, boolean fill) {
		super();
		this.color = color;
		this.filled = filled;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean fill) {
		this.filled = filled;
	}
	public String toString() {
		return "Shape[color="+color+",filled="+filled+"]";
	}
}
