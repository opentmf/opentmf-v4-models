package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Duration;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

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
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ProductOfferingTerm.class
)
public class ProductOfferingTerm extends Extensible {

  /**
   * Description of the productOfferingTerm.
   */
  private @SafeText String description;

  /**
   * Name of the productOfferingTerm.
   */
  private @SafeText String name;

  /**
   * Duration of the productOfferingTerm.
   */
  private @Valid Duration duration;

  /**
   * The period for which the productOfferingTerm is valid.
   */
  private @Valid TimePeriod validFor;
}