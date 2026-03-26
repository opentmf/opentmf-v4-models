package org.opentmf.tmf672.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entitlement;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A Privilege is a detailed information concerning an individual access
 * entitlement.
 *
 * <p><br/>
 * <strong>Required:</strong> action, function, manageableAsset<br/>
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
    defaultImpl = Privilege.class
)
@Required(fields = {"manageableAsset", "function", "action"})
public class Privilege extends Entitlement implements IPrivilege {

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef manageableAsset;
}