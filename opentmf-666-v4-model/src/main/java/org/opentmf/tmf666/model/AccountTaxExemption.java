package org.opentmf.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Proof of freedom from taxes imposed by a taxing jurisdiction.
 *
 * <p><br/>
 * <strong>Required:</strong> issuingJurisdiction, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = AccountTaxExemption.class
)
@Required(fields = {"validFor", "issuingJurisdiction"})
public class AccountTaxExemption extends Extensible implements IAccountTaxExemption {

  /**
   * Identifier of a document that shows proof of exemption from taxes for the
   * taxing jurisdiction.
   */
  private @SafeText String certificateNumber;

  /**
   * Name of the taxing jurisdiction for which taxes are exempt.
   */
  private @SafeText String issuingJurisdiction;

  /**
   * Reason of the tax exemption.
   */
  private @SafeText String reason;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}