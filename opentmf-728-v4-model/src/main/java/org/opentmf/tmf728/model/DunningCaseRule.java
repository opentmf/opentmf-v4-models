package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AppliedCustomerBillingRate;
import org.opentmf.common.model.CustomerBillRef;
import org.opentmf.common.model.DunningRuleRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductOrderRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The Dunning Case Rule represents an action performed by the company (or on
 * its behalf) to recover a debt.
 *
 * <p><br/>
 * <strong>Required:</strong> action, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = DunningCaseRule.class
)
@Required(fields = {"action", "id"})
public class DunningCaseRule extends Extensible implements IDunningCaseRule {

  /**
   * The action this dunning case rule is triggering. Can be either
   * "DunningNotification", "AppliedCustomerFeeCharge", "ProductOrder",
   * "CustomerBill" or "DunningWriteOff".
   */
  private @SafeText String action;

  /**
   * A customer bill displays applied billing rates created before or during the
   * billing process.
   */
  private @Valid AppliedCustomerBillingRate appliedPenaltyCharge;

  /**
   * The date on which the dunning case rule was created.
   */
  private OffsetDateTime creationDate;

  /**
   * Bill reference.
   */
  private @Valid CustomerBillRef customerBill;

  /**
   * A communication or joint activity from the Telecommunication Operator to the
   * customer to ask for a CustomerPayment or negotiate a PaymentPlan.
   */
  @JsonProperty("dunningNotification")
  private List<@Valid PartyInteractionRef> dunningNotifications;

  /**
   * Dunning rule reference.
   */
  private @Valid DunningRuleRef dunningRule;

  /**
   * The DunningWriteOff corresponds, in a dunning context, to a credit to
   * definitively balance the CustomerAccount before being able to close it.
   */
  private @Valid DunningWriteOff dunningWriteOff;

  /**
   * Unique identifier for the dunning case rule.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * ProductOrder (ProductOrder) .The product order which the recommendation is
   * related with.
   */
  private @Valid ProductOrderRef productOrder;
}