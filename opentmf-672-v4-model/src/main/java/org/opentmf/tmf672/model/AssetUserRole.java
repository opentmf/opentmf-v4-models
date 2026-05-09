package org.opentmf.tmf672.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.UserRoleRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * The AssetUserRole is the detailed information concerning an individual user
 * role.
 *
 * <p><br/>
 * <strong>Required:</strong> manageableAsset, userRole<br/>
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
    defaultImpl = AssetUserRole.class
)
@Required(fields = {"manageableAsset", "userRole"})
public class AssetUserRole extends Extensible implements IAssetUserRole {

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef manageableAsset;

  /**
   * A UserRoleRef is a detailed information concerning an individual access
   * entitlement.
   */
  private @Valid UserRoleRef userRole;
}