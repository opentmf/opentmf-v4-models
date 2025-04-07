package org.opentmf.v4.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Entity;

/**
 * RelatedServiceOrderItem (a ServiceOrder item) .The service order item which
 * triggered service creation/change/termination.
 *
 * <p><br/>
 * <strong>Required:</strong> itemId, serviceOrderId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
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
    defaultImpl = RelatedServiceOrderItem.class
)
@Required(fields = {"itemId", "serviceOrderId"})
public class RelatedServiceOrderItem extends Entity {

  /**
   * Identifier of the order item where the service was managed.
   */
  @SafeId
  @Size(max = 100)
  private String itemId;

  /**
   * role of the service order item for this service.
   */
  private @SafeText String role;

  /**
   * Reference of the related entity.
   */
  private URI serviceOrderHref;

  /**
   * Unique identifier of a related entity.
   */
  @SafeId
  @Size(max = 100)
  private String serviceOrderId;

  /**
   * Action of the order item for this service.
   *
   * @see org.opentmf.v4.common.model.OrderItemActionType
   */
  private @SafeText String itemAction;

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}