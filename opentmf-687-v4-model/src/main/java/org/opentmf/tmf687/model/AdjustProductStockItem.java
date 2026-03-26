package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.ProductStockRef;
import org.opentmf.common.model.Quantity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A list of AdjustProductStock items. Every item is a ProductStock adjustement
 * request.
 *
 * <p><br/>
 * <strong>Required:</strong> adjustProductStockQuantity, id, productStockTarget<br/>
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
    defaultImpl = AdjustProductStockItem.class
)
@Required(fields = {"adjustProductStockQuantity", "productStockTarget", "id"})
public class AdjustProductStockItem extends Entity implements IAdjustProductStockItem {

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity adjustProductStockQuantity;

  /**
   * ProductStockRef is a reference to a product stock.
   */
  private @Valid ProductStockRef productStockTarget;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}