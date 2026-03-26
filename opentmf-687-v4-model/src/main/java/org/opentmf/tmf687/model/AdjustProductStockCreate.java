package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * AdjustProductStock is used to log and execute on or several Product Stock
 * level change
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> adjustProductStockItem<br/>
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
    defaultImpl = AdjustProductStockCreate.class
)
@Required(fields = {"adjustProductStockItem"})
public class AdjustProductStockCreate extends Extensible implements IAdjustProductStockCreate {

  /**
   * List of: A list of AdjustProductStock items. Every item is a ProductStock
   * adjustement request.
   */
  @JsonProperty("adjustProductStockItem")
  private @Size(min = 1) List<@Valid AdjustProductStockItem> adjustProductStockItems;

  /**
   * A reason for this product stock adjustment like theft or wastage.
   */
  private @SafeText String adjustReason;

  /**
   * Date when the AdjustProductStock was created (whatever its status).
   */
  private OffsetDateTime completedAdjustProductStockDate;

  /**
   * Date when the AdjustProductStock was created (whatever its status).
   */
  private OffsetDateTime creationDate;

  /**
   * Free-text description of the AdjustProductStock.
   */
  private @SafeText String description;

  /**
   * An indicator which when the value is "true" means that requester expects the
   * adjustment immediately. If the indicator is true then the response code of
   * 200 indicates the operation is successful otherwise a task is created with a
   * response 201.
   */
  private Boolean instantSyncAdjust;

  /**
   * Date when the AdjustProductStock was created (whatever its status).
   */
  private OffsetDateTime requestedAdjustProductStockDate;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}