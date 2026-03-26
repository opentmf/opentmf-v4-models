package org.opentmf.tmf720.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
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
    defaultImpl = BiometricCredential.class
)
public class BiometricCredential extends Credential implements IBiometricCredential {

  /**
   * List of attachment(s) associated with this biometric data.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * a biometric sub type when required like for finger: thumb, index, ring ,
   * pinkyFinger, etc.
   */
  private @SafeText String biometricSubType;

  /**
   * a biometric type like finger, iris, face, etc...
   */
  private @SafeText String biometricType;
}