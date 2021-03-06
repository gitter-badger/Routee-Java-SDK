package net.routee.messaging;

import org.json.JSONObject;



/**
 * The Class Message.
 */
public class Message {

  /** The senderId of the SMS message. */
  private String from;

  /** The message you want to send. */
  private String body;

  /** The recipient of the SMS message (in E.164 format). */
  private String to;

  /**
   * Indicates if the SMS is a flash SMS. A flash SMS is a type of SMS that appears directly on the
   * main screen without user interaction and is not automatically stored in the inbox. It can be
   * useful in emergencies, such as a fire alarm or cases of confidentiality, as in delivering
   * one-time passwords.
   */
  private boolean flash;

  /** A generic label used for tagging the sms. */
  private String label;

  /** Defines the callback information for an individual message. */
  private Callback callback;


  /**
   * Instantiates a new message.
   *
   * @param from the from
   * @param body the body
   * @param to the to
   */
  public Message(String from, String body, String to) {
    this.setFrom(from);
    this.setBody(body);
    this.setTo(to);
  }

  /**
   * Instantiates a new message.
   *
   * @param from the from
   * @param body the body
   * @param to the to
   * @param flash the flash
   * @param label the label
   * @param callback the callback
   */
  public Message(String from, String body, String to, boolean flash, String label,
      Callback callback) {
    this.setFrom(from);
    this.setBody(body);
    this.setTo(to);
    this.setFlash(flash);
    this.setLabel(label);
    this.setCallback(callback);
  }

  /**
   * Instantiates a new message.
   */
  public Message() {

  }

  /**
   * Gets the from.
   *
   * @return the from
   */
  public String getFrom() {
    return from;
  }

  /**
   * Sets the from.
   *
   * @param from the new from
   */
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * Gets the body.
   *
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * Sets the body.
   *
   * @param body the new body
   */
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * Gets the to.
   *
   * @return the to
   */
  public String getTo() {
    return to;
  }

  /**
   * Sets the to.
   *
   * @param to the new to
   */
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * Checks if is flash.
   *
   * @return true, if is flash
   */
  public boolean isFlash() {
    return flash;
  }

  /**
   * Sets the flash.
   *
   * @param flash the new flash
   */
  public void setFlash(boolean flash) {
    this.flash = flash;
  }

  /**
   * Gets the label.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets the label.
   *
   * @param label the new label
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * Gets the callback.
   *
   * @return the callback
   */
  public Callback getCallback() {
    return callback;
  }

  /**
   * Sets the callback.
   *
   * @param callback the new callback
   */
  public void setCallback(Callback callback) {
    this.callback = callback;
  }

  /**
   * To json.
   *
   * @return the string
   */
  public String toJson() {

    JSONObject jsonBody = new JSONObject();
    jsonBody.put("from", this.getFrom());
    jsonBody.put("body", this.getBody());
    jsonBody.put("to", this.getTo());
    if (this.isFlash()) {
      jsonBody.put("flash", true);
    }
    if (this.getLabel() != null) {
      if (this.getLabel() != null) {
        jsonBody.put("label", this.getLabel());
      }
    }
    if (this.getCallback() != null) {
      JSONObject callbackJson = new JSONObject();
      Callback callback = this.getCallback();
      callbackJson.put("url", callback.getCallbackUrl());
      callbackJson.put("strategy", callback.getCallbackStrategy());
      jsonBody.put("callback", callbackJson);
    }
    return jsonBody.toString();
  }

}
