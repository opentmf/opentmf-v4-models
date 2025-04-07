package org.opentmf.v4.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Resource is an abstract entity that describes the common set of attributes
 * shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = Resource.class
)
@Required(fields = {"href", "id"})
public class Resource extends ResourceCreate {

  /**
   * Identifier of an instance of the resource. Required to be unique within the
   * resource type. Used in URIs as the identifier for specific instances of a
   * type.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * The URI for the object itself.
   */
  private URI href;
}