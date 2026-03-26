package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A customer bill displays applied billing rates created before or during the
 * billing process.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
 *   <li>TMF-728: Dunning Case Management</li>
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
    defaultImpl = AppliedCustomerBillingRate.class
)
@Required(fields = {"id"})
public class AppliedCustomerBillingRate extends NamedEntity implements IAppliedCustomerBillingRate {

  /**
   * List of: The applied billing tax rate represents taxes applied billing rate
   * it refers to. It is calculated during the billing process.
   */
  @JsonProperty("appliedTax")
  private List<@Valid AppliedBillingTaxRate> appliedTaxes;

  /**
   * Bill reference.
   */
  private @Valid BillRef bill;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * List of: An applied billing rate has dynamic characteristics according to the
   * its type (characteristics are based on the service type, line of business or
   * on others parameters).
   */
  @JsonProperty("characteristic")
  private List<@Valid AppliedBillingRateCharacteristic> characteristics;

  /**
   * Creation date of the applied billing rate.
   */
  private OffsetDateTime date;

  /**
   * Additional data to be displayed on the bill for this customer applied billing
   * rate.
   */
  private @SafeText String description;

  /**
   * If isBilled = true then bill should be provided, if false then billingAccount
   * should be provided.
   */
  private Boolean isBilled;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod periodCoverage;

  private @Valid ProductRef product;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxExcludedAmount;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxIncludedAmount;

  /**
   * Type of the applied billing rate : appliedBillingCharge (any kind of charge
   * except taxation charges : recurringCharge, oneTimeCharge, usageCharge),
   * appliedBillingCredit (any kind of credit : rebate or productAlteration) or
   * appliedPenaltyCharge (penalty charges such as late fees, payment rejection
   * fees,...).
   */
  private @SafeText String type;
}