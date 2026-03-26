package org.opentmf.tmf696.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-696: Risk Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ShoppingCartRiskAssessmentStatusChangeEvent extends EventBase implements IShoppingCartRiskAssessmentStatusChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid ShoppingCartRiskAssessmentStatusChangeEventPayload event;
}