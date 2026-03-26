package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AgreementRef;
import org.opentmf.common.model.AgreementSpecificationRef;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.partner.model.AgreementAuthorization;
import org.opentmf.partner.model.AgreementItem;

/**
 * A specific type of agreement that formalizes the privacy profiles requested
 * for a party
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> agreementItem, agreementType, engagedParty, name<br/>
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
    defaultImpl = PartyPrivacyAgreementUpdate.class
)
@Required(fields = {"agreementType", "name", "agreementItem", "engagedParty"})
public class PartyPrivacyAgreementUpdate extends Extensible implements IPartyPrivacyAgreementUpdate {

  /**
   * List of: A business participant that is responsible for approving the
   * agreement.
   */
  @JsonProperty("agreementAuthorization")
  private List<@Valid AgreementAuthorization> agreementAuthorizations;

  /**
   * List of: A part of the agreement expressed in terms of a product offering and
   * possibly including specific terms and conditions.
   */
  @JsonProperty("agreementItem")
  private @Size(min = 1) List<@Valid AgreementItem> agreementItems;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod agreementPeriod;

  /**
   * Agreement specification reference. An AgreementSpecification represents a
   * template of an agreement that can be used when establishing partnerships.
   */
  private @Valid AgreementSpecificationRef agreementSpecification;

  /**
   * The type of the agreement. For example commercial.
   */
  private @SafeText String agreementType;

  /**
   * List of: Agreement reference. An agreement represents a contract or
   * arrangement, either written or verbal and sometimes enforceable by law, such
   * as a service level agreement or a customer price agreement. An agreement
   * involves a number of other business entities, such as products, services, and
   * resources and/or their specifications.
   */
  @JsonProperty("associatedAgreement")
  private List<@Valid AgreementRef> associatedAgreements;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod completionDate;

  /**
   * Narrative that explains the agreement and details about it, such as why the
   * agreement is taking place.
   */
  private @SafeText String description;

  /**
   * A reference number assigned to an Agreement that follows a prescribed
   * numbering system.
   */
  private Integer documentNumber;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("engagedParty")
  private @Size(min = 1) List<@Valid RelatedParty> engagedParties;

  /**
   * Date at which the agreement was initialized.
   */
  private OffsetDateTime initialDate;

  /**
   * A human-readable name for the agreement.
   */
  private @SafeText String name;

  /**
   * The privacy profiles that are the subject of the agreement.
   */
  @JsonProperty("partyPrivacyProfile")
  private List<@Valid PartyPrivacyProfileRef> partyPrivacyProfiles;

  /**
   * A list of (typically) high criticality characteristics whose chosen privacy
   * rules are included in the agreement.
   */
  @JsonProperty("partyPrivacyProfileCharacteristic")
  private List<@Valid PartyPrivacyProfileCharacteristic> partyPrivacyProfileCharacteristics;

  /**
   * An overview and goals of the Agreement.
   */
  private @SafeText String statementOfIntent;

  /**
   * The current status of the agreement. Typical values are: in process, approved
   * and rejected.
   */
  private @SafeText String status;

  /**
   * A string identifying the version of the agreement.
   */
  private @SafeText String version;
}