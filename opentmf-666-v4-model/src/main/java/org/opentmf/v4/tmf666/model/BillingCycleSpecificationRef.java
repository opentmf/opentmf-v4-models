package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.EntityRef;

/**
 * BillingCycleSpecification reference. A description of when to initiate a
 * billing cycle and the various sub steps of a billing cycle.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = BillingCycleSpecificationRef.class
)
@Required(fields = {"id"})
public class BillingCycleSpecificationRef extends EntityRef {

  /**
   * An offset of a billing/settlement date. The offset is expressed as number of
   * days with regard to the start of the billing/settlement period.
   */
  private Integer dateShift;

  /**
   * Frequency of the billing cycle (monthly for instance).
   */
  private @SafeText String frequency;
}