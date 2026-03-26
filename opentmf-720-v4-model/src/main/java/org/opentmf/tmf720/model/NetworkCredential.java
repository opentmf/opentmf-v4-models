package org.opentmf.tmf720.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ResourceRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Credential based on a login and a password.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-720: Digital Identity Management API</li>
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
    defaultImpl = NetworkCredential.class
)
public class NetworkCredential extends Credential implements INetworkCredential {

  /**
   * credential password to use resource based credential - must be in write only.
   */
  private @SafeText String password;

  private @Valid ResourceRef resource;
}