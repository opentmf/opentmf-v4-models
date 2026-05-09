package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Description of a productTerm linked to this orderItem. This represents a
 * commitment with a duration.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
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
    defaultImpl = OrderTerm.class
)
public class OrderTerm extends Extensible implements IOrderTerm {

  /**
   * Description of the productOrderTerm.
   */
  private @SafeText String description;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity duration;

  /**
   * Name of the productOrderTerm.
   */
  private @SafeText String name;
}