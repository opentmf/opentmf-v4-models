package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * ProductStock is a base class for defining a product (or configured product
 * with values characteristic) stock level.
 *
 * <p><br/>
 * <strong>Required:</strong> productStockLevel, stockedProduct<br/>
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
    defaultImpl = ProductStock.class
)
@Required(fields = {"productStockLevel", "stockedProduct"})
public class ProductStock extends ProductStockCreate implements IProductStock {

  /**
   * Reference of the ProductStock.
   */
  private URI href;

  /**
   * Unique identifier of the ProductStock.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}