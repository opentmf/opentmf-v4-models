package org.opentmf.tmf672.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entitlement;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A UserRole defines access levels to operate over a given function that can be
 * included in an asset.
 * <br/>Skipped properties: id,href.
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
    defaultImpl = UserRoleUpdate.class
)
public class UserRoleUpdate extends Extensible implements IUserRoleUpdate {

  /**
   * List of: An Entitlement defines access levels to operate over a given
   * function that can be included in an asset.
   */
  @JsonProperty("entitlement")
  private List<@Valid Entitlement> entitlements;

  /**
   * Indication of the part that a user plays in its involvement with a manageable
   * asset (product, service or resource).
   */
  private @SafeText String involvementRole;
}