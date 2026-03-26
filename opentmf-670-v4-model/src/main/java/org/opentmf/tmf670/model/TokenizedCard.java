package org.opentmf.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PaymentMethod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Tokenized Card method of payment.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, expirationDate, lastFourDigits, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-670: Payment Method Management API</li>
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
    defaultImpl = TokenizedCard.class
)
@Required(fields = {"lastFourDigits", "atType", "name", "expirationDate"})
public class TokenizedCard extends PaymentMethod implements ITokenizedCard {

  /**
   * Card brand. Might be used for display purposes.
   */
  private @SafeText String brand;

  /**
   * Card type. Might be used for display purposes.
   */
  private @SafeText String cardType;

  /**
   * ISO 3166-1 Alpha-2 country code that designate the country where the
   * tokenised card was issued.e.g. GB, NG, FR.
   */
  private @SafeText String countryOfIssue;

  /**
   * The tokenised card's expiration date.
   */
  private OffsetDateTime expirationDate;

  /**
   * The entity that issued the token.
   */
  private @SafeText String issuer;

  /**
   * The last four digits of the credit card.
   */
  private @SafeText String lastFourDigits;

  /**
   * The token. A series of randomly generated numbers.
   */
  private @SafeText String token;

  /**
   * Token type (e.g.: emv).
   */
  private @SafeText String tokenType;
}