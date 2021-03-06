package net.routee.messaging;



/**
 * Defines the default values when the SMS has labels, in case a contact does not contain any of
 * these labels.
 */
public class Fallback {

  /** The name. */
  private String name;

  /** The value. */
  private String value;

  /**
   * Instantiates a new fallback.
   *
   * @param name the name
   * @param value the value
   */
  public Fallback(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Instantiates a new fallback.
   */
  public Fallback() {

  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  public void setValue(String value) {
    this.value = value;
  }

}
