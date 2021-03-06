package net.routee.messaging;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import net.routee.contacts.Contact;


/**
 * The Class Campaign.
 */
public class Campaign {

  /**
   * Defines the notification callback information for an individual message progress of the SMS
   * campaign.
   */
  private Callback callback;

  /** A list of contact ids that the message will be sent. */
  private ArrayList<Contact> contacts;

  /**
   * A list that defines the default values when the SMS has labels, in case a contact does not
   * contain any of these labels.
   */
  private ArrayList<Fallback> fallbackValues;

  /**
   * Indicates if the SMS is a flash SMS. A flash SMS is a type of SMS that appears directly on the
   * main screen without user interaction and is not automatically stored in the inbox. It can be
   * useful in emergencies, such as a fire alarm or cases of confidentiality, as in delivering
   * one-time passwords.
   */
  private boolean flash;

  /** A list of groups of contacts in the account selected as recipients. */
  private ArrayList<String> groups;

  /** The message you want to send. */
  private String body;

  /**
   * The name of the campaign. If you want to be able to track the whole campaign from Routee
   * console use a name, if no name is provided you won’t be able to see the campaign from the
   * console but you can track all the individual messages.
   */
  private String campaignName;

  /**
   * A list of phone numbers the message is about to be sent to. Format with a '+' and country code
   * e.g., +306948530920 (E.164 format).
   */
  private ArrayList<String> to;

  /**
   * Indicates if the SMS should respect the quiet hours. Quiet Hours are set by default to 23.00 -
   * 08.00 and 14.00-17.00 destination local time. Please note that not all countries are supported
   * with this feature due to multiple time zones within the country.
   */
  private boolean respectQuietHours;

  /** The datetime the campaign will run. */
  private String scheduledDate;

  /**
   * The sender of the message. This can be a telephone number or an alphanumeric string. In case of
   * an alphanumeric string, the maximum length is 11 characters. In case of a numeric only string
   * the length is 16 characters
   */
  private String from;

  /**
   * Defines the notification callback information for the progress of the SMS campaign.
   */
  private Callback campaignCallback;

  /**
   * Defines the recipients that will receive a test SMS before and/or after the actual SMS is sent.
   */
  private Reminder reminder;

  /**
   * Instantiates a new this.
   */
  public Campaign() {
    this.contacts = new ArrayList<Contact>();
    this.fallbackValues = new ArrayList<Fallback>();
    this.groups = new ArrayList<String>();
    this.to = new ArrayList<String>();
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
   * Gets the contacts.
   *
   * @return the contacts
   */
  public ArrayList<Contact> getContacts() {
    return contacts;
  }

  /**
   * Sets the contacts.
   *
   * @param contacts the new contacts
   */
  public void setContacts(ArrayList<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Gets the fallback values.
   *
   * @return the fallback values
   */
  public ArrayList<Fallback> getFallbackValues() {
    return fallbackValues;
  }

  /**
   * Sets the fallback values.
   *
   * @param fallbackValues the new fallback values
   */
  public void setFallbackValues(ArrayList<Fallback> fallbackValues) {
    this.fallbackValues = fallbackValues;
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
   * Gets the groups.
   *
   * @return the groups
   */
  public ArrayList<String> getGroups() {
    return groups;
  }

  /**
   * Sets the groups.
   *
   * @param groups the new groups
   */
  public void setGroups(ArrayList<String> groups) {
    this.groups = groups;
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
   * Gets the campaign name.
   *
   * @return the campaign name
   */
  public String getCampaignName() {
    return campaignName;
  }

  /**
   * Sets the campaign name.
   *
   * @param campaignName the new campaign name
   */
  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }

  /**
   * Gets the to.
   *
   * @return the to
   */
  public ArrayList<String> getTo() {
    return to;
  }

  /**
   * Sets the to.
   *
   * @param to the new to
   */
  public void setTo(ArrayList<String> to) {
    this.to = to;
  }

  /**
   * Checks if is respect quiet hours.
   *
   * @return true, if is respect quiet hours
   */
  public boolean isRespectQuietHours() {
    return respectQuietHours;
  }

  /**
   * Sets the respect quiet hours.
   *
   * @param respectQuietHours the new respect quiet hours
   */
  public void setRespectQuietHours(boolean respectQuietHours) {
    this.respectQuietHours = respectQuietHours;
  }

  /**
   * Gets the scheduled date.
   *
   * @return the scheduled date
   */
  public String getScheduledDate() {
    return scheduledDate;
  }

  /**
   * Sets the scheduled date.
   *
   * @param scheduledDate the new scheduled date
   */
  public void setScheduledDate(String scheduledDate) {
    this.scheduledDate = scheduledDate;
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
   * Gets the campaign callback.
   *
   * @return the campaign callback
   */
  public Callback getCampaignCallback() {
    return campaignCallback;
  }

  /**
   * Sets the campaign callback.
   *
   * @param campaignCallback the new campaign callback
   */
  public void setCampaignCallback(Callback campaignCallback) {
    this.campaignCallback = campaignCallback;
  }

  /**
   * Gets the reminder.
   *
   * @return the reminder
   */
  public Reminder getReminder() {
    return reminder;
  }

  /**
   * Sets the reminder.
   *
   * @param reminder the new reminder
   */
  public void setReminder(Reminder reminder) {
    this.reminder = reminder;
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
    if (this.getCallback() != null) {
      JSONObject callbackJson = new JSONObject();
      Callback callback = this.getCallback();
      callbackJson.put("url", callback.getCallbackUrl());
      callbackJson.put("strategy", callback.getCallbackStrategy());
      jsonBody.put("callback", callbackJson);
    }
    if (this.getContacts() != null) {
      if (this.getContacts().size() > 0) {
        ArrayList<Contact> contacts = this.getContacts();
        JSONArray jsonContactsArray = new JSONArray();
        for (int i = 0; i < contacts.size(); i++) {
          jsonContactsArray.put(contacts.get(i).getContactId());
        }
        jsonBody.put("contacts", jsonContactsArray);
      }
    }

    if (this.getFallbackValues() != null) {
      if (this.getFallbackValues().size() > 0) {
        ArrayList<Fallback> fallbackValues = this.getFallbackValues();
        JSONObject fallbackValuesJson = new JSONObject();
        for (int i = 0; i < fallbackValues.size(); i++) {
          fallbackValuesJson.put(fallbackValues.get(i).getName(), fallbackValues.get(i).getValue());
        }
        jsonBody.put("fallbackValues", fallbackValues);
      }
    }
    if (this.isFlash()) {
      jsonBody.put("flash", true);
    }
    if (this.getGroups() != null) {
      if (this.getGroups().size() > 0) {
        JSONArray jsonGroupsArray = new JSONArray();
        for (int i = 0; i < this.getGroups().size(); i++) {
          jsonGroupsArray.put(this.getGroups().get(i));
        }
        jsonBody.put("groups", jsonGroupsArray);
      }
    }
    if (this.getTo() != null) {
      if (this.getTo().size() > 0) {
        JSONArray jsonToArray = new JSONArray();
        for (int i = 0; i < this.getTo().size(); i++) {
          jsonToArray.put(this.getTo().get(i));
        }
        jsonBody.put("to", jsonToArray);
      }
    }
    if (this.getCampaignName() != null) {
      jsonBody.put("campaignName", this.getCampaignName());
    }
    if (this.isRespectQuietHours()) {
      jsonBody.put("respectQuietHours", true);
    }
    if (this.getScheduledDate() != null) {
      jsonBody.put("scheduledDate", this.getScheduledDate());
    }
    if (this.getCampaignCallback() != null) {
      JSONObject callbackJson = new JSONObject();
      Callback callback = this.getCampaignCallback();
      callbackJson.put("url", callback.getCallbackUrl());
      callbackJson.put("strategy", callback.getCallbackStrategy());
      jsonBody.put("campaignCallback", callbackJson);
    }
    if (this.getReminder() != null) {
      Reminder reminder = this.getReminder();
      JSONObject jsonReminder = new JSONObject();
      if (reminder.getMinutesAfter() != 0) {
        jsonReminder.put("minutesAfter", reminder.getMinutesAfter());
      }
      if (reminder.getMinutesBefore() != 0) {
        jsonReminder.put("minutesBefore", reminder.getMinutesBefore());
      }
      ArrayList<String> contactsArray = reminder.getTo();
      JSONArray contactArrayJson = new JSONArray();
      for (int i = 0; i < contactsArray.size(); i++) {
        contactArrayJson.put(contactsArray.get(i));
      }
      jsonReminder.put("to", contactArrayJson);
      jsonBody.put("reminder", jsonReminder);
    }
    return jsonBody.toString();
  }

  /**
   * Adds the contact.
   *
   * @param contact the contact
   */
  public void addContact(Contact contact) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contact);
  }

}
