package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 6 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CustomerCreate (629)</li>
 *   <li>CustomerUpdate (629)</li>
 *   <li>LoyaltyProgramPartnerCreate (658)</li>
 *   <li>LoyaltyProgramPartnerUpdate (658)</li>
 *   <li>PartyRoleCreate (669)</li>
 *   <li>PartyRoleUpdate (669)</li>
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
    defaultImpl = CustomerCreateBase.class
)
public abstract class CustomerCreateBase extends Extensible implements ICustomerCreateBase {

  /**
   * Describes the characteristic of a customer.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * List of: Credit profile for the party (containing credit scoring, ...). By
   * default, only the current credit profile is retrieved. It can be used as a
   * list to give the party credit profiles history, the first one in the list
   * will be the current one.
   */
  @JsonProperty("creditProfile")
  private List<@Valid CreditProfile> creditProfiles;

  /**
   * A word, term, or phrase by which the Customer is known and distinguished from
   * other Customers.
   */
  private @SafeText String name;

  /**
   * Used to track the lifecycle status of the customer.
   */
  private @SafeText String status;

  /**
   * A string providing an explanation on the value of the status lifecycle. For
   * instance if the status is Rejected, statusReason will provide the reason for
   * rejection.
   */
  private @SafeText String statusReason;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}