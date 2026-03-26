package org.opentmf.tmf680.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-680: Recommendation Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class QueryProductRecommendationStateChangeEventPayload implements IQueryProductRecommendationStateChangeEventPayload {

  /**
   * Recommendation API is used to recommend offering quickly based on the history
   * and real-time context of customer. It is a real-time and personalized
   * recommendation API. It is usually provided by e-commerce or BSS, CRM system
   * in omni-channel.
   */
  private @Valid QueryProductRecommendation queryProductRecommendation;
}