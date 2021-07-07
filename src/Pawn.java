import java.util.ArrayList;

class Pawn {

  private Point position;
  private ArrayList<Box> boundingBoxes;
  private double direction;
  private double velocityX;
  private double velocityY; // TODO Create a vector class?
  private double angularV;

  // private CollisionManager colmangr;  TODO once CollisionManager is implemented

  // No Constructor, because Pawn will never be instantiated directly

  // Getters and Setters

  public Point getPosition() {

    return position;
  }

  public ArrayList<Box> getBounds() {

    return boundingBoxes;
  }

  public double getDirection() {

    return direction;
  }

  public double getVelocityX() {

    return velocityX;
  }

  public double getVelocityY() {

    return velocityY;
  }

  public void translate(double x, double y) {

    position.translate(x, y);
  }

  public void rotate(double theta, Point center) {

    position.rotate(theta, center);

    for (Box box : boundingBoxes) {

      box.rotate(theta, center);
    }
  }

  public void update(double deltaT) {

    double newdirection = direction + (angularV * deltaT); // TODO do we mod by Math.PI?
    double deltaTheta = newdirection - direction;
    double deltaX = velocityX * deltaT;
    double deltaY = velocityY * deltaT;

    this.rotate(deltaTheta, position);

    this.translate(deltaX, deltaY);

    for (Box box : boundingBoxes) {

      box.rotate(deltaTheta, position);
      box.translate(deltaX, deltaY);
    }
  }
}
