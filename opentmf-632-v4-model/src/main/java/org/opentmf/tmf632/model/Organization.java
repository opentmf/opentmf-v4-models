package org.opentmf.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Organization represents a group of people identified by shared interests or
 * purpose. Examples include business, department and enterprise. Because of the
 * complex nature of many businesses, both organizations and organization units
 * are represented by the same data.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = Organization.class
)
@Required(fields = {"id"})
public class Organization extends OrganizationUpdate implements IOrganization {

  /**
   * Hyperlink to access the organization.
   */
  private URI href;

  /**
   * Unique identifier of the organization.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}