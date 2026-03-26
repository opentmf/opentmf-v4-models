package org.opentmf.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Request for cancellation an existing resource order
 * <br/>Skipped properties: id,href,state,effectiveCancellationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> resourceOrder<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = CancelResourceOrderCreate.class
)
@Required(fields = {"resourceOrder"})
public class CancelResourceOrderCreate extends Extensible implements ICancelResourceOrderCreate {

  /**
   * Reason why the order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Date when the submitter wants the order to be cancelled.
   */
  private OffsetDateTime requestedCancellationDate;

  private @Valid ResourceOrderRef resourceOrder;
}