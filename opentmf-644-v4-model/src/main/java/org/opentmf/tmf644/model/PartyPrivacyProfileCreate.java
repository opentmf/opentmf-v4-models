package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A Party Privacy Profile represents the set of Privacy settings defined for a
 * Party
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> agreedByParty, partyPrivacyProfileCharacteristic, partyPrivacyProfileSpecification<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
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
    defaultImpl = PartyPrivacyProfileCreate.class
)
@Required(fields = {"partyPrivacyProfileCharacteristic", "agreedByParty", "partyPrivacyProfileSpecification"})
public class PartyPrivacyProfileCreate extends PartyPrivacyProfileUpdate implements IPartyPrivacyProfileCreate {

  /**
   * The date on which the PartyPrivacyProfile was created.
   */
  private OffsetDateTime creationDate;
}