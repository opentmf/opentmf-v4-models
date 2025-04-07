package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AppointmentRef;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.service.model.ServiceRefOrValue;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> id, action, service<br/>
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
    defaultImpl = ServiceOrderItem.class
)
@Required(fields = {"service", "action", "id"})
public class ServiceOrderItem extends Extensible {

  /**
   * Identifier of the individual line item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  /**
   * The action to be carried out on the Service. Can be: add, modify, delete,
   * noChange.
   *
   * @see org.opentmf.v4.common.model.OrderItemActionType
   */
  private @SafeText String action;

  /**
   * An appointment that was set up with a related party for this order item.
   */
  private @Valid AppointmentRef appointment;

  /**
   * the error(s) cause an order item status change.
   */
  @JsonProperty("errorMessage")
  private List<@Valid ServiceOrderItemErrorMessage> errorMessages;

  /**
   * The Service to be acted on by the order item.
   */
  private @Valid ServiceRefOrValue service;

  /**
   * A list of order items embedded to this order item.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItem> serviceOrderItems;

  /**
   * A list of order items related to this order item.
   */
  @JsonProperty("serviceOrderItemRelationship")
  private List<@Valid ServiceOrderItemRelationship> serviceOrderItemRelationships;

  /**
   * State of the order item: described in the state machine diagram. This is the
   * requested state.
   *
   * @see org.opentmf.v4.tmf641.model.ServiceOrderItemStateType
   */
  private @SafeText String state;
}