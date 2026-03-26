package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductStockRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Linked product stock with a type relationship.
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-687: Stock Management API</li>
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
    defaultImpl = ProductStockRelationship.class
)
@Required(fields = {"relationshipType"})
public class ProductStockRelationship extends Extensible implements IProductStockRelationship {

  /**
   * The type of relationship between product stock.
   */
  private @SafeText String relationshipType;

  /**
   * ProductStockRef is a reference to a product stock.
   */
  private @Valid ProductStockRef stockLevel;
}