package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.ContactMedium;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * An individual or an organization used as a contact point for a given account
 * and accessed via some contact medium.
 *
 * <p><br/>
 * <strong>Required:</strong> contactType, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = Contact.class
)
@Required(fields = {"validFor", "contactType"})
public class Contact extends Extensible {

  /**
   * A displayable name for that contact.
   */
  private @SafeText String contactName;

  /**
   * Type of contact (primary, secondary...).
   */
  private @SafeText String contactType;

  /**
   * Identifies what kind of party role type is linked to the contact (a account
   * manager...).
   */
  private @SafeText String partyRoleType;

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  private @Valid RelatedParty relatedParty;

  /**
   * Validity period of that contact.
   */
  private @Valid TimePeriod validFor;
}