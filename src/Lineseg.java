class Lineseg {

  public Point startpoint;
  public Point endpoint;

  final double cutoff = .0001;

  public Lineseg(Point startpoint, Point endpoint) {

    if (startpoint == null
        || endpoint == null) { // ensure null safety by preventing Linesegs with null points

      throw new IllegalArgumentException("Null Point in Lineseg");

    } else {

      this.startpoint = startpoint;

      this.endpoint = endpoint;
    }
  }

  public double slope() {

    return (this.endpoint.getY() - this.startpoint.getY())
        / (this.endpoint.getX() - this.startpoint.getX());
  }

  public boolean inxRange(double xcoor) {

    if (startpoint.getX() <= endpoint.getX()) {

      if (startpoint.getX() <= xcoor && endpoint.getX() >= xcoor) return true;
      return false;
    } else {
      if (endpoint.getX() <= xcoor && startpoint.getX() >= xcoor) return true;
      return false;
    }
  }

  public boolean inyRange(double ycoor) {

    if (startpoint.getY() <= endpoint.getY()) {

      if (startpoint.getY() <= ycoor && endpoint.getY() >= ycoor) return true;
      return false;
    } else {
      if (endpoint.getY() <= ycoor && startpoint.getY() >= ycoor) return true;
      return false;
    }
  }

  public boolean contains(Point point) {

    if (point == null) return false;

    if (this.inyRange(point.getX()) && this.inxRange(point.getY())) return true;
    return false;
  }

  public boolean doesIntercept(Lineseg other) {

    if (other == null) return false;

    // First check that linesegs aren't parralel

    double thisslope = this.slope();

    double otherslope = other.slope();

    if (Math.abs(thisslope - otherslope) < cutoff) return false;

    // Next check for intercept of full lines

    double thisx = this.startpoint.getX();
    double otherx = other.startpoint.getX();
    double thisy = this.startpoint.getY();
    double othery = other.startpoint.getY();

    double xintercept =
        ((othery - thisy) + (thisslope * thisx) - (otherslope * otherx)) / (thisslope - otherslope);

    // make sure xintercept is on both of the lines

    if (this.inxRange(xintercept) && other.inxRange(xintercept)) return true;
    return false;
  }
}
