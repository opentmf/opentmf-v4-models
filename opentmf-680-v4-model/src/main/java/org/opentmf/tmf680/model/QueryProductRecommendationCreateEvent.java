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
public class QueryProductRecommendationCreateEvent extends AddressableEventBase implements IQueryProductRecommendationCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid QueryProductRecommendationCreateEventPayload event;
}