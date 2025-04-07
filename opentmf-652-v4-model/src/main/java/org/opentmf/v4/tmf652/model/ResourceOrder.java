package org.opentmf.v4.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A Resource Order is a request to provision a set of Resources (logical and
 * physical) triggered by the request to provision a Service through a Service
 * Order.
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
    defaultImpl = ResourceOrder.class
)
public class ResourceOrder extends ResourceOrderCreate {

  /**
   * Identifier of an instance of the Resource Order. Required to be unique within
   * the resource type. Used in URIs as the identifier for specific instances of a
   * type.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Hyperlink to access the order.
   */
  private URI href;
}