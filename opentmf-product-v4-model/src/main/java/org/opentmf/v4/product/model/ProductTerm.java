package org.opentmf.v4.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.Quantity;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Description of a productTerm linked to this product. This represents a
 * commitment with a duration.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
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
    defaultImpl = ProductTerm.class
)
public class ProductTerm extends Extensible {

  /**
   * Description of the productTerm.
   */
  private @SafeText String description;

  /**
   * Name of the productTerm.
   */
  private @SafeText String name;

  /**
   * Duration of the productTerm.
   */
  private @Valid Quantity duration;

  /**
   * productTerm validity period.
   */
  private @Valid TimePeriod validFor;
}