package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.CancelOrder;

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
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = CancelServiceOrder.class
)
public class CancelServiceOrder extends CancelOrder {

  /**
   * an optional message describing the completion of the task if it is done as
   * expected or it is denied for a reason (like order in an state of PoNR).
   */
  private @SafeText String completionMessage;

  /**
   * the error(s) cause the termination of cancelServiceOrder (in
   * TerminatedWithError state).
   */
  private @Valid ErrorMessage errorMessage;

  private @Valid ServiceOrderRef serviceOrder;
}