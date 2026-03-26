package org.opentmf.tmf717.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Promotion Resource is used to provide the additional discount, voucher, bonus
 * or gift to the customer who meets the pre-defined criteria. Using promotion,
 * the enterprise is able to attract the users and encourage more consumption,
 * especially continuous purchases.  Normally Promotion is not regarded as one
 * type of product or product offering. It is often applied when the customer
 * buys the product offerings with the price or amount surpassing the certain
 * limit.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360PromotionVO.class
)
@Required(fields = {"name"})
public class Customer360PromotionVO extends NamedEntity implements ICustomer360PromotionVO {

  /**
   * Description of Promotion.
   */
  private @SafeText String description;

  /**
   * Latest update date of Promotion.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Status of Promotion, including
   * draft/Test/WaitForApproval/Release/Suspend/Retirement.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Type of promotion.The basic type is Award/Discount/Reduction. More types can
   * be extended in future.
   */
  private @SafeText String type;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}