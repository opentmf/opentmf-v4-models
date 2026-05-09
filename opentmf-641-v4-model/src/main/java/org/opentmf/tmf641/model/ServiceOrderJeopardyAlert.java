package org.opentmf.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ServiceOrderItemRef;

/**
 * A ServiceOrderJeopardyAlert represents a predicted exception during a service
 * order processing that would brings risk to complete successfully the order.
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
    defaultImpl = ServiceOrderJeopardyAlert.class
)
public class ServiceOrderJeopardyAlert extends JeopardyAlert implements IServiceOrderJeopardyAlert {

  /**
   * A list of order item references corresponded to this alert.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItemRef> serviceOrderItems;
}