/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

/**
 *
 * @author Dave
 */
public class Location {
  private double longitude;
  private double latitude;
  private double course;
  private double pointId;
  private double speed;

  /**
   * @return the longitude
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * @param longitude the longitude to set
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * @return the latitude
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * @param latitude the latitude to set
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * @return the course
   */
  public double getCourse() {
    return course;
  }

  /**
   * @param course the course to set
   */
  public void setCourse(double course) {
    this.course = course;
  }

  /**
   * @return the pointId
   */
  public double getPointId() {
    return pointId;
  }

  /**
   * @param pointId the pointId to set
   */
  public void setPointId(double pointId) {
    this.pointId = pointId;
  }

  /**
   * @return the speed
   */
  public double getSpeed() {
    return speed;
  }

  /**
   * @param speed the speed to set
   */
  public void setSpeed(double speed) {
    this.speed = speed;
  }
  
  
}
