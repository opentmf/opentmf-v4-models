package org.opentmf.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AppointmentRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ServiceRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> action, id, service<br/>
 * </p>
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
    defaultImpl = ServiceOrderItem.class
)
@Required(fields = {"service", "action", "id"})
public class ServiceOrderItem extends Extensible implements IServiceOrderItem {

  /**
   * action to be performed on the product
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.common.model.OrderItemActionType
   */
  private @SafeText String action;

  /**
   * Refers an appointment, such as a Customer presentation or internal meeting or
   * site visit.
   */
  private @Valid AppointmentRef appointment;

  /**
   * the error(s) cause an order item status change.
   */
  @JsonProperty("errorMessage")
  private List<@Valid ServiceOrderItemErrorMessage> errorMessages;

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
   * A Service to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the Service entity and not the RelatedServiceRefOrValue class itself.
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
   * Possible values for the state of the order item
   * <br/><p>Recommended values: acknowledged, rejected, pending, held,
   * inProgress, cancelled, completed, failed, assessingCancellation,
   * pendingCancellation, partial.
   *
   * @see org.opentmf.tmf641.model.ServiceOrderItemStateType
   */
  private @SafeText String state;
}