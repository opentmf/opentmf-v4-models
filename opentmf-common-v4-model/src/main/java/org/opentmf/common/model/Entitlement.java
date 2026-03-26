package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An Entitlement defines access levels to operate over a given function that
 * can be included in an asset.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-672: User Role Permission Management API</li>
 *   <li>TMF-691: Federated ID Management API</li>
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
    defaultImpl = Entitlement.class
)
public class Entitlement extends Extensible implements IEntitlement {

  /**
   * Level of access granted as part of the permission.
   */
  private @SafeText String action;

  /**
   * Specific function that can be managed over a given asset.
   */
  private @SafeText String function;
}