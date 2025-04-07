package org.opentmf.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.Quantity;

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
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = OrderTerm.class
)
public class OrderTerm extends Extensible {

  /**
   * Description of the productOrderTerm.
   */
  private @SafeText String description;

  /**
   * Name of the productOrderTerm.
   */
  private @SafeText String name;

  /**
   * Duration of the productOrderTerm.
   */
  private @Valid Quantity duration;
}