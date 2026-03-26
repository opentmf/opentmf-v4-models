package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AgreementSpecificationRef;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An agreement represents a contract or arrangement, either written or verbal
 * and sometimes enforceable by law, such as a service level agreement or a
 * customer price agreement. An agreement involves a number of other business
 * entities, such as products, services, and resources and/or their
 * specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> agreementType, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360AgreementVO.class
)
@Required(fields = {"agreementType", "name"})
public class Customer360AgreementVO extends NamedEntity implements ICustomer360AgreementVO {

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
   * Date at which the agreement was initialized.
   */
  private OffsetDateTime initialDate;

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