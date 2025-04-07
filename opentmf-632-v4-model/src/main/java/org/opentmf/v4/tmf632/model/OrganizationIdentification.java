package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Represents our registration of information used as proof of identity by an
 * organization.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = OrganizationIdentification.class
)
public class OrganizationIdentification extends Extensible {

  /**
   * Identifier.
   */
  @SafeId
  @Size(max = 100)
  private String identificationId;

  /**
   * Type of identification information used to identify the company in a country
   * or internationally.
   */
  private @SafeText String identificationType;

  /**
   * Authority which has issued the identifier (chamber of commerce...).
   */
  private @SafeText String issuingAuthority;

  /**
   * Date at which the identifier was issued.
   */
  private OffsetDateTime issuingDate;

  private @Valid AttachmentRefOrValue attachment;

  /**
   * The period for which the identification information is valid.
   */
  private @Valid TimePeriod validFor;
}