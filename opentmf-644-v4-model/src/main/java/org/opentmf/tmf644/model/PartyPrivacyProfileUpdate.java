package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PartyPrivacyAgreementRef;
import org.opentmf.common.model.PartyPrivacyProfileSpecificationRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Party Privacy Profile represents the set of Privacy settings defined for a
 * Party
 * <br/>Skipped properties: id,href,creationDate.
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
    defaultImpl = PartyPrivacyProfileUpdate.class
)
public class PartyPrivacyProfileUpdate extends Extensible implements IPartyPrivacyProfileUpdate {

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty agreedByParty;

  /**
   * Reference to Party Privacy Agreement resource.
   */
  private @Valid PartyPrivacyAgreementRef agreement;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty applicableForParty;

  /**
   * Description of the privacy profile.
   */
  private @SafeText String description;

  /**
   * Name of the privacy profile.
   */
  private @SafeText String name;

  /**
   * List of characteristics of the privacy profile.
   */
  @JsonProperty("partyPrivacyProfileCharacteristic")
  private List<@Valid PartyPrivacyProfileCharacteristic> partyPrivacyProfileCharacteristics;

  /**
   * Reference to Party Privacy Specification resource.
   */
  private @Valid PartyPrivacyProfileSpecificationRef partyPrivacyProfileSpecification;

  /**
   * The status of this profile (for example: created, terminated, etc.).
   */
  private @SafeText String status;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}