// Class Box implements a bounding box for an object.  Instance params are the center of the box
// the height and width, and an length 4 array of verteces. 


class Box {

	private Point center;

	private double width;

	private double height;

	private Point[] verts; 

	private Lineseg[] linesegs; 


/*  The Constructor of Box.
	Parameters: center, the center of the bounding box; height, width: the height and width of the box
	Note boxes always start parralel to axis... but can be rotated */
	
	public Box(Point center, double width , double height) {

		this.center = center;

		this.width = width;

		this.height = height;

		this.verts = new Point[] {new Point(this.center.getX() - (width/2), this.center.getY() - (height/2)),
						 new Point(this.center.getX() + (width/2), this.center.getY() - (height/2)),
						 new Point(this.center.getX() - (width/2), this.center.getY() + (height/2)),
						 new Point(this.center.getX() + (width/2), this.center.getY() + (height/2))};

		this.linesegs = new Lineseg[] {new Lineseg(this.verts[0], this.verts[1]),
						 new Lineseg(this.verts[0], this.verts[2]),
						 new Lineseg(this.verts[1], this.verts[3]),
						 new Lineseg(this.verts[2], this.verts[3])};
				   
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

		//first pivot around one point till that lineseg is level.

		Lineseg aseg = this.linesegs[0];
		double deltay = aseg.endpoint.getY() - aseg.startpoint.getY();
		double deltax = aseg.endpoint.getX() - aseg.startpoint.getX();
		double theta = Math.atan2(deltay, deltax);

		Box levelbox = new Box(this.center, this.width, this.height);

		Point rotatedpoint = new Point(point.getX(),point.getY());

		rotatedpoint.rotate(-theta, aseg.startpoint);

		if (Math.abs(levelbox.center.getX() - rotatedpoint.getX()) <= (levelbox.width / 2) && (Math.abs(levelbox.center.getY() - rotatedpoint.getY()) <= (levelbox.height/ 2))) {

			return true;
		
		} else {

			return false;
		}
	}


// Checks if another box intersects the box. 
	public boolean doesIntersect(Box box) {


// Check if any linesegs in the boxes intercept

		for (Lineseg lineseg: this.linesegs) {
			for (Lineseg otherseg: box.linesegs) {
				if (lineseg.doesIntercept(otherseg)) return true;
			}
		}

		return false;
	}
}




	

						   
