package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * An agreement represents a contract or arrangement, either written or verbal
 * and sometimes enforceable by law, such as a service level agreement or a
 * customer price agreement. An agreement involves a number of other business
 * entities, such as products, services, and resources and/or their
 * specifications.
 * <br/>Skipped properties: id,href.
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
    defaultImpl = AgreementCreate.class
)
@Required(fields = {"agreementType", "name", "agreementItem", "engagedParty"})
public class AgreementCreate extends AgreementUpdate {

  /**
   * Date at which the agreement is completed.
   */
  private @Valid TimePeriod completionDate;
}