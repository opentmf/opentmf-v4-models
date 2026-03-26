package org.opentmf.tmf720.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
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
    defaultImpl = LoginPasswordCredential.class
)
public class LoginPasswordCredential extends Credential implements ILoginPasswordCredential {

  /**
   * credential login.
   */
  private @SafeText String login;

  /**
   * credential password - must be in write only.
   */
  private @SafeText String password;
}