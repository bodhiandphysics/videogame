// This class implements a point, expressed as a vector, on the plain. Instance variables are x and y 
// coordinates.

class Point {

	private double x;

	private double y;


// Constructor of the point


	public Point(double x, double y) {

		this.x = x;
		this.y = y;
	}


// Getters and Setters

	public double getX() {

		return x;
	}

	public double getY() {

		return y;
	}

// Translate the Point by the vector x y

	public void translate(double x, double y) {

		this.x += x;
		this.y += y;
	}


// Rotate the point, by angle theta, treating Point center as origin of the plane


	public void rotate(double theta, Point center) {

		//First translate origin to Point

		double origin_x = this.x - center.getX();
		double origin_y = this.y - center.getY();

		//then rotate

		double origin_xr = (origin_x * Math.cos(theta)) - (origin_y * Math.sin(theta));
		double origin_yr = (origin_x * Math.sin(theta)) + (origin_y * Math.cos(theta));

		//then translate back

		this.x = origin_xr + center.getX();
		this.y = origin_xr + center.getY();
	}

}