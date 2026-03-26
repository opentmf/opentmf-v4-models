package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductRefOrValue;
import org.opentmf.common.model.ProductStockRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * ReserveProductStockItem is used to request a stock reservation item for a
 * product.
 *
 * <p><br/>
 * <strong>Required:</strong> id, quantityRequested, requestedProduct<br/>
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
    defaultImpl = ReserveProductStockItem.class
)
@Required(fields = {"requestedProduct", "quantityRequested", "id"})
public class ReserveProductStockItem extends Extensible implements IReserveProductStockItem {

  /**
   * Unique identifier of the ReserveProductStockItem.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * ProductStockRef is a reference to a product stock.
   */
  private @Valid ProductStockRef productStockRequested;

  /**
   * ProductStockRef is a reference to a product stock.
   */
  private @Valid ProductStockRef productStockReserved;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity quantityRequested;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity quantityReserved;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue requestedProduct;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String reserveProductStockState;
}