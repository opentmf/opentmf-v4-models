package org.opentmf.tmf672.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entitlement;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A UserRole defines access levels to operate over a given function that can be
 * included in an asset.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> entitlement<br/>
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
    defaultImpl = UserRoleCreate.class
)
@Required(fields = {"entitlement"})
public class UserRoleCreate extends Extensible implements IUserRoleCreate {

  /**
   * List of: An Entitlement defines access levels to operate over a given
   * function that can be included in an asset.
   */
  @JsonProperty("entitlement")
  private @Size(min = 1) List<@Valid Entitlement> entitlements;

  /**
   * Indication of the part that a user plays in its involvement with a manageable
   * asset (product, service or resource).
   */
  private @SafeText String involvementRole;
}