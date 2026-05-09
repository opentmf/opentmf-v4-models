package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Relationship among cart items mainly other than hierarchical relationships
 * such as "RelyOn", "DependentOn", "Shipping" etc.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-663: Shopping Cart Management API</li>
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
    defaultImpl = CartItemRelationship.class
)
public class CartItemRelationship extends Extensible implements ICartItemRelationship {

  /**
   * Unique identifier of the referred cart item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Type of the cart item relationship.
   */
  private @SafeText String relationshipType;
}