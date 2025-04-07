package org.opentmf.v4.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Logic resource is a type of resource that describes the common set of
 * attributes shared by all concrete logical resources (e.g. TPE, MSISDN, IP
 * Addresses) in the inventory.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = LogicalResource.class
)
@JsonTypeName("LogicalResource")
@Required(fields = {"href", "id"})
public class LogicalResource extends Resource {

  /**
   * the value of the logical resource. E.g '0746712345' for MSISDN's.
   */
  private @SafeText String value;
}