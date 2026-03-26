package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The AdjustBalance resource allows adjustments to be made to the original
 * BalanceTopup eg increment the amount, alter the recharge periodicity.
 *
 * <p><br/>
 * <strong>Required:</strong> status<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
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
    defaultImpl = AdjustBalance.class
)
@Required(fields = {"status"})
public class AdjustBalance extends ReserveBalance implements IAdjustBalance {

  /**
   * Valid values for the Balance Adjust types
   * <br/><p>Recommended values: recurring, oneTime.
   *
   * @see org.opentmf.tmf654.model.AdjustType
   */
  private @SafeText String adjustType;
}