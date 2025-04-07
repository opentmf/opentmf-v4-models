package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties:
 * id,href,orderDate,completionDate,expectedCompletionDate,startDate,state,jeopardyAlert,errorMessage,milestone.
 *
 * <p><br/>
 * <strong>Required:</strong> serviceOrderItem<br/>
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
    defaultImpl = ServiceOrderCreate.class
)
@Required(fields = {"serviceOrderItem"})
public class ServiceOrderCreate extends ServiceOrderBase {

  /**
   * Date when the order is cancelled. This is used when order is cancelled.
   */
  private OffsetDateTime cancellationDate;

  /**
   * Reason why the order is cancelled. This is used when order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Used to categorize the order, useful for the OM system, such as: Broadband,
   * TVOption.
   */
  private @SafeText String category;
}