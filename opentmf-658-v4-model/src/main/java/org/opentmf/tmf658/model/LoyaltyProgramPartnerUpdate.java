package org.opentmf.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AccountRef;
import org.opentmf.common.model.AgreementRef;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.ContactMedium;
import org.opentmf.common.model.CustomerCreateBase;
import org.opentmf.common.model.PaymentMethodRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A partner engaged in the Loyalty Program
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty, name<br/>
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = LoyaltyProgramPartnerUpdate.class
)
@Required(fields = {"name", "engagedParty"})
public class LoyaltyProgramPartnerUpdate extends CustomerCreateBase implements ILoyaltyProgramPartnerUpdate {

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
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty engagedParty;

  /**
   * The partner catalog category reference maps to a category containing the
   * partner product offerings.
   */
  @JsonProperty("partnerCatalog")
  private List<@Valid CategoryRef> partnerCatalogs;

  /**
   * List of: PaymentMethod reference. A payment method defines a specific mean of
   * payment (e.g. direct debit).
   */
  @JsonProperty("paymentMethod")
  private List<@Valid PaymentMethodRef> paymentMethods;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}