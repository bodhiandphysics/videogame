class Point {

	private double x;

	private double y;

	public Point(double x, double y) {

		this.x = x;
		this.y = y;
	}

	public double getX() {

		return x;
	}

	public double getY() {

		return y;
	}

	public void translate(double x, double y) {

		this.x += x;
		this.y += y;
	}

	public void rotate(double theta, Point center) {

		//First translate origin to Point

		double origin_x = this.x - center.x;
		double origin_y = this.y - center.y;

		//then rotate

		double origin_xr = (origin_x * Math.cos(theta)) - (origin_y * Math.sin(theta));
		double origin_yr = (origin_x * Math.sin(theta)) + (origin_y * Math.cos(theta));

		//then translate back

		this.x = origin_xr + center.x;
		this.y = origin_xr + center.y;
	}

}