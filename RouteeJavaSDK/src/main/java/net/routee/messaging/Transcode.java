package net.routee.messaging;

import org.json.JSONObject;



/**
 * The number of actual SMS that will be sent.
 * 
 */
public class Transcode {

  /**
   * The transcoded message of the original unicode message.
   */
  private String message;

  /**
   * The number of actual SMS that will be sent.
   */
  private int parts;

  /**
   * Instantiates a new transcode.
   *
   * @param message the message
   * @param parts the parts
   */
  public Transcode(String message, int parts) {
    super();
    this.message = message;
    this.parts = parts;
  }

  /**
   * Instantiates a new transcode.
   */
  public Transcode() {}

  /**
   * Gets the message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message.
   *
   * @param message the new message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Gets the parts.
   *
   * @return the parts
   */
  public int getParts() {
    return parts;
  }

  /**
   * Sets the parts.
   *
   * @param parts the new parts
   */
  public void setParts(int parts) {
    this.parts = parts;
  }

  /**
   * From json.
   *
   * @param transcodeJson the transcode json
   * @return the transcode
   */
  public static Transcode fromJson(JSONObject transcodeJson) {
    Transcode transcode = new Transcode();
    transcode.setParts(transcodeJson.getInt("parts"));
    transcode.setMessage(transcodeJson.getString("message"));
    return transcode;
  }

}
