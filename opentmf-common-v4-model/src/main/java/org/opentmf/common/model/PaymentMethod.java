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
 * A Payment Method is a pure-virtual super-class that defines a specific method
 * of payment such as Direct Debit, Cash, Digital Wallet,Tokenized Card, Bank
 * Account Transfer, Bank Account Debit, Bank Card, Voucher, Check, Bucket
 * PaymentMethod, Account PaymentMethod, and Loyalty PaymentMethod with all
 * details associated. Use the {@literal @}type attribute to specify the concrete type in
 * the API calls.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-670: Payment Method Management API</li>
 *   <li>TMF-676: Payment Management API</li>
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
    defaultImpl = PaymentMethod.class
)
@Required(fields = {"atType", "name"})
public class PaymentMethod extends NamedEntity implements IPaymentMethod {

  /**
   * Reference to the accounts that are linked to the payment method. May be a
   * party account or a financial account.
   */
  @JsonProperty("account")
  private List<@Valid AccountRef> accounts;

  /**
   * Review: Authorization code provided by a financial institution. Typically
   * this would be populated for recurring payments using the method, as payments
   * have an authorization code of their own.
   */
  private @SafeText String authorizationCode;

  /**
   * Text description of the contents of the payment method.
   */
  private @SafeText String description;

  /**
   * If the method is the preferred one by the owner. Typically used when querying
   * for the payment methods of a specific customer or account.
   */
  private Boolean isPreferred;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty relatedParty;

  /**
   * A Place and an associated role as installation adress, delivery address,
   * etc....
   */
  private @Valid RelatedPlace relatedPlace;

  /**
   * Status of the payment method.
   */
  private @SafeText String status;

  /**
   * The last time the payment method status changed.
   */
  private OffsetDateTime statusDate;

  /**
   * The reason for the last status change.
   */
  private @SafeText String statusReason;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}