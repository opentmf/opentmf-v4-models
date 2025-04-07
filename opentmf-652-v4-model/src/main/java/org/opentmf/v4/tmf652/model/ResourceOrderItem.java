package org.opentmf.v4.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AppointmentRef;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.ResourceSpecificationRef;
import org.opentmf.v4.resource.model.ResourceRefOrValue;

/**
 * An identified part of the order. A resource order is decomposed into one or
 * more order items.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = ResourceOrderItem.class
)
public class ResourceOrderItem extends Extensible {

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03,
   * ...).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Can be "add" / "modify" / "no_change"/ "delete".
   */
  private @SafeText String action;

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  /**
   * State of the order item : described in the state machine diagram.
   */
  private @SafeText String state;

  private @Valid AppointmentRef appointment;

  @JsonProperty("orderItemRelationship")
  private List<@Valid ResourceOrderItemRelationship> orderItemRelationships;

  private @Valid ResourceRefOrValue resource;

  private @Valid ResourceSpecificationRef resourceSpecification;
}