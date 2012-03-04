/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

/**
 *
 * @author Dave
 */
public class Route {
  String name;
  Integer id;
  
  public Route() {
    this.setName("");
    this.setId(new Integer(-1));
  }
  
  public Route(String name, Integer id) {
    this.setName(name);
    this.setId(id);
  }
    
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getId() {
    return this.id;
  }
}
