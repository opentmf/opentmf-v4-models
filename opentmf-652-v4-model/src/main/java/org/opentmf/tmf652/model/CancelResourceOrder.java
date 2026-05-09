package org.opentmf.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CancelOrder;
import org.opentmf.common.model.ResourceOrderRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Request for cancellation an existing resource order.
 *
 * <p><br/>
 * <strong>Required:</strong> resourceOrder<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = CancelResourceOrder.class
)
@Required(fields = {"resourceOrder"})
public class CancelResourceOrder extends CancelOrder implements ICancelResourceOrder {

  private @Valid ResourceOrderRef resourceOrder;
}