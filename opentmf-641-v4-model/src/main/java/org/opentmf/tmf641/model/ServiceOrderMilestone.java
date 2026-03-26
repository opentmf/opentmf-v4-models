package org.opentmf.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * ServiceOrderMilestone represents an action or event marking a significant
 * change or stage in processing of a service order.
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
    defaultImpl = ServiceOrderMilestone.class
)
public class ServiceOrderMilestone extends Milestone implements IServiceOrderMilestone {

  /**
   * A list of order item references corresponded to this milestone.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItemRef> serviceOrderItems;
}