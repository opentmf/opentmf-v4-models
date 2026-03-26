package org.opentmf.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CancelOrder;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Request for cancellation an existing Service order.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = CancelServiceOrder.class
)
public class CancelServiceOrder extends CancelOrder implements ICancelServiceOrder {

  /**
   * an optional message describing the completion of the task if it is done as
   * expected or it is denied for a reason (like order in an state of PoNR).
   */
  private @SafeText String completionMessage;

  /**
   * represents an Error.
   */
  private @Valid ErrorMessage errorMessage;

  /**
   * Service Order reference. Useful to understand the which was the Service order
   * through which the service was instantiated in the service inventory.
   */
  private @Valid ServiceOrderRef serviceOrder;
}