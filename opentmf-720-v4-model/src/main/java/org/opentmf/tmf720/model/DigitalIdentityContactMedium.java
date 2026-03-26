package org.opentmf.tmf720.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Indicates the contact medium that could be used to contact the party.
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
    defaultImpl = DigitalIdentityContactMedium.class
)
@Required(fields = {"atType", "id"})
public class DigitalIdentityContactMedium extends Extensible implements IDigitalIdentityContactMedium {

  /**
   * Type of the contact medium to qualifiy it like pro email / personal email.
   * This is not used to define the contact medium used.
   */
  private @SafeText String contactType;

  /**
   * Identifier for this contact medium.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * If true, indicates that is the preferred contact medium.
   */
  private Boolean preferred;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}