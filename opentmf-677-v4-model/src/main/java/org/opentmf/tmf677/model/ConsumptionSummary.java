package org.opentmf.tmf677.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.Quantity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The consumption counters (called ConsumptionSummary in the SID model) detail
 * for example the different kind of consumption done on the bucket.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-677: Usage Consumption Management API</li>
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
    defaultImpl = ConsumptionSummary.class
)
public class ConsumptionSummary extends Entity implements IConsumptionSummary {

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod consumptionPeriod;

  /**
   * Type of the consumption counter. We can give for example a counter of the
   * used value for a bucket (counterType=used for example) or the value of the
   * consumption done out of the bucket(s) (counterType=outOfBucket for example).
   */
  private @SafeText String counterType;

  /**
   * Counter level. The counter can be given globally for the bucket or detailed
   * by user or by network product for example in case of shared bucket.
   */
  private @SafeText String level;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty user;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity value;

  /**
   * Value of the counter in a formatted string used for display needs for
   * example.
   */
  private @SafeText String valueName;
}