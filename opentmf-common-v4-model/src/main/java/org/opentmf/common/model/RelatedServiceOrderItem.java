package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

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
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = RelatedServiceOrderItem.class
)
@Required(fields = {"itemId", "serviceOrderId"})
public class RelatedServiceOrderItem extends ServiceOrderItemRef implements IRelatedServiceOrderItem {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * action to be performed on the product
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.common.model.OrderItemActionType
   */
  private @SafeText String itemAction;

  /**
   * role of the service order item for this service.
   */
  private @SafeText String role;
}