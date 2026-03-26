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
import org.opentmf.common.model.PlaceRefOrValue;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * CheckProductStock is used to log and execute check about product stock
 * availability
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> checkProductStockItem<br/>
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
    defaultImpl = CheckProductStockCreate.class
)
@Required(fields = {"checkProductStockItem"})
public class CheckProductStockCreate extends Extensible implements ICheckProductStockCreate {

  /**
   * A list of check product stock item.
   */
  @JsonProperty("checkProductStockItem")
  private @Size(min = 1) List<@Valid CheckProductStockItem> checkProductStockItems;

  /**
   * Date when the CheckProductStock was completed.
   */
  private OffsetDateTime completedCheckProductStockDate;

  /**
   * Date when the CheckProductStock was created (whatever its status).
   */
  private OffsetDateTime creationDate;

  /**
   * An indicator which when the value is "true" means that requester expects to
   * get result immediately in the response. If the indicator is true then the
   * response code of 200 indicates the operation is successful otherwise a task
   * is created with a response 201.
   */
  private Boolean instantSyncCheck;

  /**
   * A place described by reference or by value linked to a specific entity. The
   * polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to
   * the place entity and not the PlaceRefOrValue class itself.
   */
  private @Valid PlaceRefOrValue place;

  /**
   * When the value is TRUE means that alternative proposal should be provided
   * (from other product stock, different date or quantity).
   */
  private Boolean provideAlternative;

  /**
   * A list of related party references (RelatedParty [*]). A related party
   * defines party or party role linked to this CheckProductStock.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Date when the stock availability should be check.
   */
  private OffsetDateTime requestedAvailabilityDate;

  /**
   * Date when the requester wished to have a response for this product stock
   * check query.
   */
  private OffsetDateTime requestedCheckProductStockDate;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}