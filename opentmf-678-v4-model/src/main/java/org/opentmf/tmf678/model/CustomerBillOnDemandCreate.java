package org.opentmf.tmf678.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.BillRef;
import org.opentmf.common.model.BillingAccountRef;
import org.opentmf.common.model.RelatedPartyRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This resource is used to manage the creation request of a customer bill in
 * real-time (on demand).
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
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
    defaultImpl = CustomerBillOnDemandCreate.class
)
public class CustomerBillOnDemandCreate extends CustomerBillUpdate implements ICustomerBillOnDemandCreate {

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * Bill reference.
   */
  private @Valid BillRef customerBill;

  /**
   * Additional data describing the customer bill on demand request.
   */
  private @SafeText String description;

  /**
   * The last date time when the customer bill on demand has been updated.
   */
  private @SafeText String lastUpdate;

  /**
   * Friendly name to identify the customer bill on demand request.
   */
  private @SafeText String name;

  /**
   * RelatedParty reference. A related party defines party or party role linked to
   * a specific entity.
   */
  private @Valid RelatedPartyRef relatedParty;
}