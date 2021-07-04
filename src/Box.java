// Class Box implements a bounding box for an object.  Instance params are the center of the box
// the height and width, and an length 4 array of verteces. 


class Box {

	private Point center;

	private double width;

	private double height;

	private Point[] verts; 


/*  The Constructor of Box.
	Parameters: center, the center of the bounding box; height, width: the height and width of the box */
	
	public Box(Point center, double width , double height) {

		this.center = center;

		this.width = width;

		this.height = height;

		Point[] verts = {new Point(this.center.getX() - (width/2), this.center.getY() - (height/2)),
						 new Point(this.center.getX() + (width/2), this.center.getY() - (height/2)),
						 new Point(this.center.getX() - (width/2), this.center.getY() + (height/2)),
						 new Point(this.center.getX() + (width/2), this.center.getY() + (height/2))};
				   
	}

// Getters and Setters

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

// Translate the Box by the vector x,y

	public void translate(double x, double y) {

		for (Point point: verts) {

			point.translate(x,y);
		}

	}

// Rotate the box around a point by angle theta in radians.  To rotate around the center, call box.rotate(Math.pi/2, box.getCenter())
	public void rotate(double theta, Point center) {

		for (Point point: verts) {

			point.rotate(theta, center);
		}

	}


// Checks if a point is in the box

	public boolean contains(Point point) {

		if (Math.abs(center.getX() - point.getX()) <= (width / 2) && (Math.abs(center.getY() - point.getY()) <= height /2)) {

			return true;
		
		} else {

			return false;
		}
	}


// Checks if another box intersects the box
	
	public boolean doesIntersect(Box box) {

		for (Point point:box.getVerts()) {

			if (this.contains(point)) return true;
		}

		return false;
	}
}




	

						   
