package org.opentmf.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.PromotionUpdateBase;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Promotion is used to provide the additional discount, voucher, bonus or gift
 * to the customer who meets the pre-defined criteria. Using promotion, the
 * enterprise is able to attract the users and encourage more consumption,
 * especially continuous purchases. Normally Promotion is not regarded as one
 * type of product or product offering. It is often applied when the customer
 * buys the product offerings with the price or amount surpassing the certain
 * limit.
 * <br/>Skipped properties: id,href,pattern,{@literal @}baseType,{@literal @}type,{@literal @}schemaLocation.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PromotionUpdate extends PromotionUpdateBase implements IPromotionUpdate {

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Latest update date of promotion.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Type of promotion. The basic type are Award/Discount/Reduction.
   */
  private @SafeText String promotionType;
}