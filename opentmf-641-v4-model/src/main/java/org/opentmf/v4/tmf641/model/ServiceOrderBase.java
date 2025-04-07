package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.ExternalReference;
import org.opentmf.v4.common.model.OrderBase;

/**
 * A manually introduced base object for service orders.
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ServiceOrderBase.class
)
public class ServiceOrderBase extends OrderBase {

  /**
   * Contact attached to the order to send back information regarding this order.
   */
  private @SafeText String notificationContact;

  /**
   * Can be used by consumers to prioritize orders in a Service Order Management
   * system.
   */
  private @SafeText String priority;

  /**
   * List of: External reference of the individual or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * A list of service orders related to this order (e.g. prerequisite, dependent
   * on).
   */
  @JsonProperty("orderRelationship")
  private List<@Valid ServiceOrderRelationship> orderRelationships;

  /**
   * A list of service order items to be processed by this order.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItem> serviceOrderItems;
}