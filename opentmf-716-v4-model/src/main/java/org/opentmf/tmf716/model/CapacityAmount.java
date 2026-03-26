package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Quantity that defines the Capacity.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-716: ResourceReservation</li>
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
    defaultImpl = CapacityAmount.class
)
public class CapacityAmount extends Extensible implements ICapacityAmount {

  /**
   * A value and units that define the CapacityAmount, such as 10000 ea, 10B Mb.
   * Instance values are mutually exclusive with From and To capacityAmounts and
   * range interval.
   */
  private @SafeText String capacityAmount;

  /**
   * The low range value that a Capacity Amount can take on.
   */
  private @SafeText String capacityAmountFrom;

  /**
   * The upper range value that CapacityAmount can take on.
   */
  private @SafeText String capacityAmountTo;

  /**
   * An indicator that specifies the inclusion or exclusion of the capacityAmount
   * From and capacityAmountTo attributes. 
   * <br/>Possible values are "open", "closed", "closedBottom" and "closedTop".
   */
  private @SafeText String rangeInterval;
}