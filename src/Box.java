class Box {

	private Point center;

	private double width;

	private double height;

	private Point[] verts; 


	public Box(Point center, double width , double height) {

		this.center = center;

		this.width = width;

		this.height = height;

		Point[] verts = {new Point(this.center.getX() - (width/2), this.center.getY() - (height/2)),
						 new Point(this.center.getX() + (width/2), this.center.getY() - (height/2)),
						 new Point(this.center.getX() - (width/2), this.center.getY() + (height/2)),
						 new Point(this.center.getX() + (width/2), this.center.getY() + (height/2))};
				   
	}


	public Point getCenter() {

		return center;
	
	}

	public double getWidth() {

		return width;
	}

	public double getHeight() {

		return height;
	}

	public Point[] getVerts() {

		return verts;
	}


	public void translate(double x, double y) {

		for (Point point: verts) {

			point.translate(x,y);
		}

	}

	public void rotate(double theta, Point center) {

		for (Point point: verts) {

			point.rotate(theta, center);
		}

	}

	public boolean contains(Point point) {

		if (Math.abs(center.getX() - point.getX()) <= (width / 2) && (Math.abs(center.getY() - point.getY()) <= height /2)) {

			return true;
		
		} else {

			return false;
		}
	}

	public boolean doesIntersect(Box box) {

		for (Point point:box.getVerts()) {

			if (this.contains(point)) return true;
		}

		return false;
	}
}




	

						   
