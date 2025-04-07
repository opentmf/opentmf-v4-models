package org.opentmf.v4.tmf669.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AgreementRef;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.common.model.ContactMedium;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;
import org.opentmf.v4.customer.model.AccountRef;
import org.opentmf.v4.customer.model.CreditProfile;
import org.opentmf.v4.customer.model.PaymentMethodRef;

/**
 * The part played by a party in a given context.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-669: Party Role Management API</li>
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
    defaultImpl = PartyRoleUpdate.class
)
public class PartyRoleUpdate extends Extensible {

  /**
   * A word, term, or phrase by which the PartyRole is known and distinguished
   * from other PartyRoles.
   */
  private @SafeText String name;

  /**
   * Used to track the lifecycle status of the party role.
   */
  private @SafeText String status;

  /**
   * A string providing an explanation on the value of the status lifecycle. For
   * instance if the status is Rejected, statusReason will provide the reason for
   * rejection.
   */
  private @SafeText String statusReason;

  /**
   * List of: Account reference. An account may be a party account or a financial
   * account.
   */
  @JsonProperty("account")
  private List<@Valid AccountRef> accounts;

  /**
   * List of: Agreement reference. An agreement represents a contract or
   * arrangement, either written or verbal and sometimes enforceable by law, such
   * as a service level agreement or a customer price agreement. An agreement
   * involves a number of other business entities, such as products, services, and
   * resources and/or their specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * Describes the characteristic of a party role.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * List of: Credit profile for the party (containing credit scoring, ...). By
   * default, only the current credit profile is retrieved. It can be used as a
   * list to give the party credit profiles history, the first one in the list
   * will be the current one.
   */
  @JsonProperty("creditProfile")
  private List<@Valid CreditProfile> creditProfiles;

  private @Valid RelatedParty engagedParty;

  /**
   * List of: PaymentMethod reference. A payment method defines a specific mean of
   * payment (e.g. direct debit).
   */
  @JsonProperty("paymentMethod")
  private List<@Valid PaymentMethodRef> paymentMethods;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * The time period that the PartyRole is valid for.
   */
  private @Valid TimePeriod validFor;
}