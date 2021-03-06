package net.routee.twostep;

import java.io.IOException;

import org.json.JSONObject;

import net.routee.authentication.RouteeAuthentication;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.configuration.Configuration;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * The Class RouteeTwoStepClient.
 */
public class RouteeTwoStepClient {


  /** The Constant ENDPOINT_TWPSTEP. */
  public static final String ENDPOINT_TWPSTEP = "/2step";

  /** The Constant ENDPOINT_TWOSTEPREPORTS. */
  public static final String ENDPOINT_TWOSTEPREPORTS = "/2step/reports";



  /** The auth. */
  private RouteeAuthentication auth = null;

  /** The http client. */
  private OkHttpClient httpClient = null;


  /**
   * Instantiates a new routee two step client.
   *
   * @param applicationId the application id
   * @param applicationSecret the application secret
   */
  public RouteeTwoStepClient(final String applicationId, final String applicationSecret) {
    this.auth = new RouteeAuthentication(applicationId, applicationSecret);
  }

  /**
   * Instantiates a new routee two step client.
   *
   * @param auth the auth
   */
  public RouteeTwoStepClient(RouteeAuthentication auth) {
    this.auth = auth;
  }

  /**
   * You can send a 2Step verification very easily just by specifying the recipient, the type of the
   * message and the method that the verification will be sent. The message type that is currently
   * supported is "code" which generates a numeric only code with the specified number of digits.
   * The method that is currently supported is "sms", so the specified recipient must be a valid
   * mobile number. All optional parameters that are required by 2Step are taken from your
   * application settings which can be configured through the Routee web console.
   *
   * @param parameters the parameters
   * @return the two step verification response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeTwoStepException the routee two step exception
   */
  public TwoStepVerificationResponse sendTwoStepVerification(
      SendTwpStepVerificationParameters parameters)
      throws RouteeAuthenticationException, IOException, RouteeTwoStepException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, parameters.toJson());
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_TWPSTEP)
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeTwoStepException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return TwoStepVerificationResponse.fromJson(result);

  }

  /**
   * This method is used when you want to retrieve the status of a 2step verification by providing
   * its trackingId.
   *
   * @param trackingId the tracking id of the verification.
   * @return the two step verification status
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public TwoStepVerificationResponse getTwoStepVerificationStatus(String trackingId)
      throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_TWPSTEP + "/" + trackingId).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeTwoStepException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return TwoStepVerificationResponse.fromJson(result);
  }

  /**
   * This method can cancel a 2step verification by providing its trackingId. Note that the
   * verification must have a Pending status.
   *
   * @param trackingId the tracking id of the verification.
   * @return the two step verification response
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public TwoStepVerificationResponse cancelTwoStepVerificationStatus(String trackingId)
      throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_TWPSTEP + "/" + trackingId).delete()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeTwoStepException(response.body().string());
    }
    if (responseCode != 200) {
      throw new RouteeTwoStepException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return TwoStepVerificationResponse.fromJson(result);
  }

  /**
   * This method is used to confirm a 2step verification by providing the answer.
   *
   * @param trackingId the tracking id of the verification.
   * @param code the code
   * @return the two step verification response
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public TwoStepVerificationResponse confirmTwoStepVerificationStatus(String trackingId,
      String code) throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    RequestBody body = RequestBody.create(mediaType, "answer=" + code);
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_TWPSTEP + "/" + trackingId).post(body)
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeTwoStepException(response.body().string());
    }
    if (responseCode != 200) {
      throw new RouteeTwoStepException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return TwoStepVerificationResponse.fromJson(result);
  }


  /**
   * This method is used to retrieve 2step verification reports from all of your applications.
   *
   * @return the two step report
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public TwoStepReport retrieveTwpStepAccountReports()
      throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_TWOSTEPREPORTS).get()
            .addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeTwoStepException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return TwoStepReport.fromJson(jsonResponse);

  }

  /**
   * This method is used to retrieve 2step verification reports for any of your applications by
   * providing the application id.
   *
   * @param appId your application id
   * @return the two step report
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public TwoStepReport retrieveTwpSteApplicationReports(String appId)
      throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_TWOSTEPREPORTS + "/applications/" + appId)
        .get().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeTwoStepException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return TwoStepReport.fromJson(jsonResponse);
  }



}
