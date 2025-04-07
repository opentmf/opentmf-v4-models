package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An attachment by value or by reference.
 *
 * <p><br/>
 * <strong>Required:</strong> name, isRef<br/>
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
    defaultImpl = BillingCycleSpecificationRefOrValue.class
)
@Required(fields = {"isRef", "name"})
public class BillingCycleSpecificationRefOrValue extends BillingCycleSpecification {

  /**
   * An offset of a billing/settlement date. The offset is expressed as number of
   * days with regard to the start of the billing/settlement period.
   */
  private Integer dateShift;

  private Boolean isRef;

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}