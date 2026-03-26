package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.ProductRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An occurrence of employing a product for its intended purpose with all rating
 * details.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-635: Usage Management API</li>
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
    defaultImpl = RatedProductUsage.class
)
public class RatedProductUsage extends Extensible implements IRatedProductUsage {

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money bucketValueConvertedInAmount;

  /**
   * Boolean indicating if usage have been billed or not.
   */
  private Boolean isBilled;

  /**
   * Indicates if the rated amount is exempt of tax.
   */
  private Boolean isTaxExempt;

  /**
   * Type of tariff applied.
   */
  private @SafeText String offerTariffType;

  private @Valid ProductRef productRef;

  /**
   * Type of amount.
   */
  private @SafeText String ratingAmountType;

  /**
   * Date of usage rating.
   */
  private OffsetDateTime ratingDate;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxExcludedRatingAmount;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money taxIncludedRatingAmount;

  /**
   * Tax rate.
   */
  private BigDecimal taxRate;

  /**
   * Tag value: [usage]: the usage is always rated outside a usage bundle
   * <br/>[included usage]: the usage is rated inside a usage bundle
   * <br/>[non included usage]: the usage bundle is exhausted. The usage is rated
   * outside the usage bundle.
   */
  private @SafeText String usageRatingTag;
}