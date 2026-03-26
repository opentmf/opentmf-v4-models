package org.opentmf.tmf680.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AddressableEventBase;

/**
 * The notification data structure.
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
public class QueryProductRecommendationStateChangeEvent extends AddressableEventBase implements IQueryProductRecommendationStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid QueryProductRecommendationStateChangeEventPayload event;
}