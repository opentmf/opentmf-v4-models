package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AgreementRef;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * An agreement represents a contract or arrangement, either written or verbal
 * and sometimes enforceable by law, such as a service level agreement or a
 * customer price agreement. An agreement involves a number of other business
 * entities, such as products, services, and resources and/or their
 * specifications.
 * <br/>Skipped properties: id,href,completionDate.
 *
 * <p><br/>
 * <strong>Required:</strong> agreementItem, agreementType, engagedParty, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement</li>
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
    defaultImpl = AgreementUpdate.class
)
@Required(fields = {"agreementType", "name", "agreementItem", "engagedParty"})
public class AgreementUpdate extends Extensible {

  /**
   * The type of the agreement. For example commercial.
   */
  private @SafeText String agreementType;

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
   * Date at which the agreement was initialized.
   */
  private OffsetDateTime initialDate;

  /**
   * A human-readable name for the agreement.
   */
  private @SafeText String name;

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
   * The time period during which the Agreement is in effect.
   */
  private @Valid TimePeriod agreementPeriod;

  private @Valid AgreementSpecificationRef agreementSpecification;

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
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("engagedParty")
  private @Size(min = 1) List<@Valid RelatedParty> engagedParties;
}