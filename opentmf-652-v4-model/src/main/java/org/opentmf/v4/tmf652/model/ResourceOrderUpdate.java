package org.opentmf.v4.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.OrderBase;

/**
 * A Resource Order is a request to provision a set of Resources (logical and
 * physical) triggered by the request to provision a Service through a Service
 * Order
 * <br/>Skipped properties: id,href,completionDate,orderDate.
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
    defaultImpl = ResourceOrderUpdate.class
)
public class ResourceOrderUpdate extends OrderBase {

  /**
   * Used to categorize the order from a business perspective that can be useful
   * for the OM system.
   */
  private @SafeText String category;

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime expectedCompletionDate;

  /**
   * A string used to give a name to the Resource Order.
   */
  private @SafeText String name;

  /**
   * Name of the Resource Order type.
   */
  private @SafeText String orderType;

  /**
   * A way that can be used by consumers to prioritize orders in OM system (from 0
   * to 4 : 0 is the highest priority, and 4 the lowest).
   */
  private Integer priority;

  /**
   * Date when the order was actually started.
   */
  private OffsetDateTime startDate;

  /**
   * The life cycle state of the resource.
   */
  private @SafeText String state;

  /**
   * List of: An identification of an entity that is owned by or originates in a
   * software system different from the current system, for example a ProductOrder
   * handed off from a commerce platform into an order handling system. The
   * structure identifies the system itself, the nature of the entity within the
   * system (e.g. class name) and the unique ID of the entity within the system.
   * It is anticipated that multiple external IDs can be held for a single entity,
   * e.g. if the entity passed through multiple systems on the way to the current
   * system. In this case the consumer is expected to sequence the IDs in the
   * array in reverse order of provenance, i.e. most recent system first in the
   * list.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalId> externalReferences;

  /**
   * List of: An identified part of the order. A resource order is decomposed into
   * one or more order items.
   */
  @JsonProperty("orderItem")
  private List<@Valid ResourceOrderItem> orderItems;
}