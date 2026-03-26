package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * ProductStock is a base class for defining a product (or configured product
 * with values characteristic) stock level.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> productStockLevel, productStockStatusType, stockedProduct<br/>
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
    defaultImpl = ProductStockCreate.class
)
@Required(fields = {"productStockStatusType", "productStockLevel", "stockedProduct"})
public class ProductStockCreate extends ProductStockUpdate implements IProductStockCreate {

  /**
   * Date when the ProductStock was created (whatever its status).
   */
  private OffsetDateTime creationDate;
}