package org.opentmf.tmf672.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The Permission resource represents the entitlement given by an individual
 * (granter) to another individual (user) to get access to a set of his owned
 * manageable assets. One single permission resource can hold information
 * referring to privileges granted for multiple manageable assets.
 *
 * <p><br/>
 * <strong>Required:</strong> user, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-672: User Role Permission Management API</li>
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
    defaultImpl = Permission.class
)
@Required(fields = {"validFor", "user"})
public class Permission extends PermissionUpdate implements IPermission {

  /**
   * Date when the payment was performed.
   */
  private OffsetDateTime creationDate;

  /**
   * Hypertext Reference of the permission.
   */
  private URI href;

  /**
   * Unique identifier of the permission.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}