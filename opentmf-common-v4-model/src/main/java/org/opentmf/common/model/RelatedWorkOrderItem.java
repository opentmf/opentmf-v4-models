package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * RelatedWorkOrderItem (WorkOrder item). The work order item which triggered
 * this unit of work's creation/change/termination.
 *
 * <p><br/>
 * <strong>Required:</strong> orderItemId, workOrderId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-714: Work Qualification Management</li>
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
    defaultImpl = RelatedWorkOrderItem.class
)
@Required(fields = {"orderItemId", "workOrderId"})
public class RelatedWorkOrderItem extends Extensible implements IRelatedWorkOrderItem {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Action of the order item for this unit of work.
   */
  private @SafeText String orderItemAction;

  /**
   * Identifier of the work order item where the unit of work was managed.
   */
  @SafeId
  @Size(max = 100)
  private String orderItemId;

  /**
   * Role of the work order item for this unitof work.
   */
  private @SafeText String role;

  /**
   * Reference of the related entity.
   */
  private URI workOrderHref;

  /**
   * Unique identifier of a related entity.
   */
  @SafeId
  @Size(max = 100)
  private String workOrderId;
}