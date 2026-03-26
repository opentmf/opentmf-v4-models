package org.opentmf.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AccountRef;
import org.opentmf.common.model.AgreementRef;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.ContactMedium;
import org.opentmf.common.model.CreditProfile;
import org.opentmf.common.model.PaymentMethodRef;
import org.opentmf.common.model.RoleTypeRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A person or group that opts in to a loyalty program.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name, roleType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"name", "roleType"})
public class LoyaltyProgramMemberCreate implements ILoyaltyProgramMemberCreate {

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  @JsonProperty("ValidFor")
  private @Valid TimePeriod validFor;

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

  /**
   * Entity reference. A related party defines party or party role linked to a
   * specific entity.
   */
  private @Valid RelatedPartyRefOrValue engagedParty;

  /**
   * The array of loyalty program products that the member is enrolled to.
   */
  @JsonProperty("loyltyProgramProduct")
  private List<@Valid LoyaltyProgramProductRef> loyltyProgramProducts;

  /**
   * The loyalty members name.
   */
  private @SafeText String name;

  /**
   * List of: PaymentMethod reference. A payment method defines a specific mean of
   * payment (e.g. direct debit).
   */
  @JsonProperty("paymentMethod")
  private List<@Valid PaymentMethodRef> paymentMethods;

  /**
   * List of: Entity reference. A related party defines party or party role linked
   * to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyRefOrValue> relatedParties;

  /**
   * RoleType reference.
   */
  private @Valid RoleTypeRef roleType;

  /**
   * A free-form field in which the members status may be captured, e.g. [active],
   * [suspended], .etc.
   */
  private @SafeText String status;

  /**
   * A string providing an explanation on the value of the status lifecycle. For
   * instance if the status is Rejected, statusReason will provide the reason for
   * rejection.
   */
  private @SafeText String statusReason;

  /**
   * The member tier based on tiered loyalty program rules.
   */
  private @SafeText String tier;
}