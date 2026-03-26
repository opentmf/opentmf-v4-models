package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.Quantity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * CheckProductStockItem is used to log and execute query about one product (or
 * configured product) stock availability.
 *
 * <p><br/>
 * <strong>Required:</strong> checkedProductStock, id, requestedQuantity<br/>
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
    defaultImpl = CheckProductStockItem.class
)
@Required(fields = {"requestedQuantity", "checkedProductStock", "id"})
public class CheckProductStockItem extends Extensible implements ICheckProductStockItem {

  /**
   * A list of alternate availability - from other product stock , different date
   * or quantity.
   */
  @JsonProperty("alternate")
  private List<@Valid AlternateProductStock> alternates;

  /**
   * Result of the availability like available, notAvailable, alternate.
   */
  private @SafeText String availabilityResult;

  /**
   * ProductStock is a base class for defining a product (or configured product
   * with values characteristic) stock level.
   */
  private @Valid ProductStock checkedProductStock;

  /**
   * Unique identifier of the Check Product Stock item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * When the value is TRUE means that alternative proposal should be provided
   * (from other product stock, different date or quantity).
   */
  private Boolean provideAlternative;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity requestedQuantity;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}