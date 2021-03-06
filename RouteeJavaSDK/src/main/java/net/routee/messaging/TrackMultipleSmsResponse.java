package net.routee.messaging;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * The Class TrackMultipleSmsResponse.
 */
public class TrackMultipleSmsResponse {

  /**
   * The number of total pages.
   */
  private int totalPages;

  /**
   * Whether the current page is the last one.
   */
  private boolean last;

  /**
   * The total amount of elements for the current search.
   */
  private int totalElements;

  /**
   * Whether the current page is the first one. .
   */
  private boolean first;

  /**
   * The number of elements currently on this page.
   */
  private int numberOfElements;

  /**
   * The requested page size.
   */
  private int size;

  /**
   * The requested page number.
   */
  private int number;

  /** The sms information. */
  private ArrayList<SmsData> smsInformation;


  /**
   * Instantiates a new track multiple sms response.
   *
   * @param totalPages the total pages
   * @param last the last
   * @param totalElements the total elements
   * @param first the first
   * @param numberOfElements the number of elements
   * @param size the size
   * @param number the number
   * @param smsInformation the sms information
   */
  public TrackMultipleSmsResponse(int totalPages, boolean last, int totalElements, boolean first,
      int numberOfElements, int size, int number, ArrayList<SmsData> smsInformation) {
    this.totalPages = totalPages;
    this.last = last;
    this.totalElements = totalElements;
    this.first = first;
    this.numberOfElements = numberOfElements;
    this.size = size;
    this.number = number;
    this.smsInformation = smsInformation;
  }

  /**
   * Instantiates a new track multiple sms response.
   */
  public TrackMultipleSmsResponse() {
    this.smsInformation = new ArrayList<SmsData>();
  }

  /**
   * Adds the sms information.
   *
   * @param data the data
   */
  public void addSmsInformation(SmsData data) {
    if (this.smsInformation == null) {
      this.smsInformation = new ArrayList<SmsData>();
    }
    this.smsInformation.add(data);
  }


  /**
   * Gets the total pages.
   *
   * @return the total pages
   */
  public int getTotalPages() {
    return totalPages;
  }

  /**
   * Sets the total pages.
   *
   * @param totalPages the new total pages
   */
  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  /**
   * Checks if is last.
   *
   * @return true, if is last
   */
  public boolean isLast() {
    return last;
  }

  /**
   * Sets the last.
   *
   * @param last the new last
   */
  public void setLast(boolean last) {
    this.last = last;
  }

  /**
   * Gets the total elements.
   *
   * @return the total elements
   */
  public int getTotalElements() {
    return totalElements;
  }

  /**
   * Sets the total elements.
   *
   * @param totalElements the new total elements
   */
  public void setTotalElements(int totalElements) {
    this.totalElements = totalElements;
  }

  /**
   * Checks if is first.
   *
   * @return true, if is first
   */
  public boolean isFirst() {
    return first;
  }

  /**
   * Sets the first.
   *
   * @param first the new first
   */
  public void setFirst(boolean first) {
    this.first = first;
  }

  /**
   * Gets the number of elements.
   *
   * @return the number of elements
   */
  public int getNumberOfElements() {
    return numberOfElements;
  }

  /**
   * Sets the number of elements.
   *
   * @param numberOfElements the new number of elements
   */
  public void setNumberOfElements(int numberOfElements) {
    this.numberOfElements = numberOfElements;
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public int getSize() {
    return size;
  }

  /**
   * Sets the size.
   *
   * @param size the new size
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Gets the number.
   *
   * @return the number
   */
  public int getNumber() {
    return number;
  }

  /**
   * Sets the number.
   *
   * @param number the new number
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Gets the sms information.
   *
   * @return the sms information
   */
  public ArrayList<SmsData> getSmsInformation() {
    return smsInformation;
  }

  /**
   * Sets the sms information.
   *
   * @param smsInformation the new sms information
   */
  public void setSmsInformation(ArrayList<SmsData> smsInformation) {
    this.smsInformation = smsInformation;
  }

  /**
   * From json.
   *
   * @param jsonResponse the json response
   * @return the track multiple sms response
   */
  public static TrackMultipleSmsResponse fromJson(JSONObject jsonResponse) {
    TrackMultipleSmsResponse responseObject = new TrackMultipleSmsResponse();
    responseObject.setFirst(jsonResponse.getBoolean("first"));
    responseObject.setLast(jsonResponse.getBoolean("last"));
    responseObject.setNumber(jsonResponse.getInt("number"));
    responseObject.setNumberOfElements(jsonResponse.getInt("numberOfElements"));
    responseObject.setSize(jsonResponse.getInt("size"));
    responseObject.setTotalElements(jsonResponse.getInt("totalElements"));
    responseObject.setTotalPages(jsonResponse.getInt("totalPages"));
    JSONArray smsDetailsArray = jsonResponse.getJSONArray("content");
    for (int i = 0; i < smsDetailsArray.length(); i++) {
      JSONObject smsInfoJson = smsDetailsArray.getJSONObject(i);
      responseObject.addSmsInformation(SmsData.fromJson(smsInfoJson));
    }
    return responseObject;
  }


}
