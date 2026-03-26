package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Product Order is a type of order which can be used to place an order
 * between a customer and a service provider or between a service provider and a
 * partner and vice versa.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360ProductOrderVO.class
)
public class Customer360ProductOrderVO extends Entity implements ICustomer360ProductOrderVO {

  /**
   * Date when the order is cancelled. This is used when order is cancelled.
   */
  private OffsetDateTime cancellationDate;

  /**
   * Reason why the order is cancelled. This is used when order is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * Used to categorize the order from a business perspective that can be useful
   * for the OM system (e.g. "enterprise", "residential", ...).
   */
  private @SafeText String category;

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Description of the product order.
   */
  private @SafeText String description;

  /**
   * Expected delivery date amended by the provider.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * ID given by the consumer and only understandable by him (to facilitate his
   * searches afterwards).
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * Contact attached to the order to send back information regarding this order.
   */
  private @SafeText String notificationContact;

  /**
   * Date when the order was created.
   */
  private OffsetDateTime orderDate;

  /**
   * A way that can be used by consumers to prioritize orders in OM system (from 0
   * to 4 : 0 is the highest priority, and 4 the lowest).
   */
  private @SafeText String priority;

  /**
   * Requested delivery date from the requester perspective.
   */
  private OffsetDateTime requestedCompletionDate;

  /**
   * Order fulfillment start date wished by the requester. This is used when, for
   * any reason, requester cannot allow seller to begin to operationally begin the
   * fulfillment before a date.
   */
  private OffsetDateTime requestedStartDate;

  /**
   * Possible values for the state of the order
   * <br/><p>Recommended values: acknowledged, rejected, pending, held,
   * inProgress, cancelled, completed, failed, partial, assessingCancellation,
   * pendingCancellation.
   *
   * @see org.opentmf.customer.model.ProductOrderStateType
   */
  private @SafeText String state;
}