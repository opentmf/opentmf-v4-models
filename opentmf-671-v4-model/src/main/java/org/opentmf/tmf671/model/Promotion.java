package org.opentmf.tmf671.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Promotion is used to provide the additional discount, voucher, bonus or gift
 * to the customer who meets the pre-defined criteria. Using promotion, the
 * enterprise is able to attract the users and encourage more consumption,
 * especially continuous purchases. Normally Promotion is not regarded as one
 * type of product or product offering. It is often applied when the customer
 * buys the product offerings with the price or amount surpassing the certain
 * limit.
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
public class Promotion extends PromotionCreate implements IPromotion {

  /**
   * Hyperlink to access the promotion.
   */
  private URI href;

  /**
   * Unique identifier of promotion.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}