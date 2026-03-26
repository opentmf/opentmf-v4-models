package org.opentmf.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * A Resource Order is a request to provision a set of Resources (logical and
 * physical) triggered by the request to provision a Service through a Service
 * Order
 * <br/>Skipped properties: id,href.
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
    defaultImpl = ResourceOrderCreate.class
)
public class ResourceOrderCreate extends ResourceOrderUpdate implements IResourceOrderCreate {

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Date when the order was created.
   */
  private OffsetDateTime orderDate;
}