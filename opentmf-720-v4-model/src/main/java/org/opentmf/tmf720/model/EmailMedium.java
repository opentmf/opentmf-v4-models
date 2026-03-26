package org.opentmf.tmf720.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Describes an email that could be used to contact a party (an individual or an
 * organization).
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
    defaultImpl = EmailMedium.class
)
public class EmailMedium extends DigitalIdentityContactMedium implements IEmailMedium {

  /**
   * Full email address in standard format.
   */
  private @SafeText String emailAddress;
}