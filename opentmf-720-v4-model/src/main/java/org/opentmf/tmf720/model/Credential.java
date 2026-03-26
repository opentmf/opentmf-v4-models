package org.opentmf.tmf720.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Credential is a class that allow to describe an authentification method.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, id<br/>
 * </p>
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
    defaultImpl = Credential.class
)
@Required(fields = {"atType", "id"})
public class Credential extends Extensible implements ICredential {

  /**
   * List of contact medium associated with this credential/authentification
   * method.
   */
  @JsonProperty("contactMedium")
  private List<@Valid DigitalIdentityContactMedium> contactMediums;

  /**
   * an identifier for a credential/authentification method for this digital
   * identity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Used to indicate the current lifecycle state of this credential (like active,
   * inactive, expired).
   */
  private @SafeText String state;

  /**
   * A level of assurance associated with this credential - this could be used to
   * limit/allow specific permission based on this trust level.
   */
  private @SafeText String trustLevel;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}