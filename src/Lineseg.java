class Lineseg {

	public Point startpoint;
	public Point endpoint;

	final double cutoff = .0001;

	public Lineseg(Point startpoint, Point endpoint) {

		this.startpoint = startpoint;
		this.endpoint = endpoint;
	}

	public double slope() {

		return (this.endpoint.y - this.startpoint.y) / (this.endpoint.x - this.startpoint.x);
	}

	public boolean inxRange (double xcoor) {

		if (startpoint.x <= endpoint.x) {

			if (startpoint.x <= xcoor && endpoint.x >= xcoor) return true;
			return false;
		} else {
			if (endpoint.x <= xcoor && startpoint.x >= xcoor) return true;
			return false;
		}
	}

	public boolean inyRange (double ycoor) {

		if (startpoint.y <= endpoint.y) {

			if (startpoint.y <= ycoor && endpoint.y >= ycoor) return true;
			return false;
		} else {
			if (endpoint.y <= ycoor && startpoint.y >= ycoor) return true;
			return false;
		}
	}


	public boolean contains(Point point) {

		if (this.inyRange(point.x) && this.inxRange(point.y)) return true;
		return false;
	}


	public boolean doesIntercept(Lineseg other) {

		//First check that linesegs aren't parralel

		double thisslope = this.slope();

		double otherslope = other.slope();

		if (Math.abs(thisslope - otherslope) < cutoff) return false;

		// Next check for intercept of full lines

		double thisx = this.startpoint.x;
		double otherx = other.startpoint.x;
		double thisy = this.startpoint.y;
		double othery = other.startpoint.y;

		double xintercept = ((othery - thisy) + (thisslope * thisx) - (otherslope * otherx)) / (thisslope - otherslope);

		// make sure xintercept is on both of the lines

		if (this.inxRange(xintercept) && other.inxRange(xintercept)) return true;
		return false;


	}
}