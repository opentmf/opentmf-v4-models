package org.opentmf.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Duration;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A condition under which a ProductOffering is made available to Customers. For
 * instance, a productOffering can be offered with multiple commitment periods.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = ProductOfferingTerm.class
)
public class ProductOfferingTerm extends Extensible implements IProductOfferingTerm {

  /**
   * Description of the productOfferingTerm.
   */
  private @SafeText String description;

  /**
   * A time interval in a given unit of time.
   */
  private @Valid Duration duration;

  /**
   * Name of the productOfferingTerm.
   */
  private @SafeText String name;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}