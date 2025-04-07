package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * Request for cancellation an existing Service order
 * <br/>Skipped properties:
 * id,href,state,effectiveCancellationDate,completionMessage,errorMessage.
 *
 * <p><br/>
 * <strong>Required:</strong> serviceOrder<br/>
 * </p>
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
    defaultImpl = CancelServiceOrderCreate.class
)
@Required(fields = {"serviceOrder"})
public class CancelServiceOrderCreate extends Extensible {

  /**
   * Reason why the order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Date when the submitter wants the order to be cancelled.
   */
  private OffsetDateTime requestedCancellationDate;

  private @Valid ServiceOrderRef serviceOrder;
}