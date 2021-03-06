package net.routee.messaging;

import org.json.JSONObject;



/**
 * The Class SingleMessageAnalysisResponse.
 */
public class SingleMessageAnalysisResponse {



  /**
   * Instantiates a new single message analysis response.
   *
   * @param analysis the analysis
   * @param cost the cost
   */
  public SingleMessageAnalysisResponse(BodyAnalysis analysis, double cost) {
    this.analysis = analysis;
    this.cost = cost;
  }

  /**
   * Instantiates a new single message analysis response.
   */
  public SingleMessageAnalysisResponse() {}

  /** The analysis for the body of the SMS. */
  BodyAnalysis analysis;

  /**
   * The cost of the SMS.
   */
  double cost;

  /**
   * Gets the analysis.
   *
   * @return the analysis
   */
  public BodyAnalysis getAnalysis() {
    return analysis;
  }

  /**
   * Sets the analysis.
   *
   * @param analysis the new analysis
   */
  public void setAnalysis(BodyAnalysis analysis) {
    this.analysis = analysis;
  }

  /**
   * Gets the cost.
   *
   * @return the cost
   */
  public double getCost() {
    return cost;
  }

  /**
   * Sets the cost.
   *
   * @param cost the new cost
   */
  public void setCost(double cost) {
    this.cost = cost;
  }

  /**
   * From json.
   *
   * @param result the result
   * @return the single message analysis response
   */
  public static SingleMessageAnalysisResponse fromJson(JSONObject result) {
    JSONObject bodyAnalysisJSON = result.getJSONObject("bodyAnalysis");
    SingleMessageAnalysisResponse singleMessageAnylaysis = new SingleMessageAnalysisResponse();
    singleMessageAnylaysis.setAnalysis(BodyAnalysis.fromJson(bodyAnalysisJSON));
    singleMessageAnylaysis.setCost(result.getDouble("cost"));
    return singleMessageAnylaysis;

  }

}
