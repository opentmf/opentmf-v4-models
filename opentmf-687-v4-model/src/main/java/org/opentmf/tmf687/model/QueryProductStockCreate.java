package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * QueryProductStock is used to query product stock availability
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> searchCriteria<br/>
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
    defaultImpl = QueryProductStockCreate.class
)
@Required(fields = {"searchCriteria"})
public class QueryProductStockCreate extends Extensible implements IQueryProductStockCreate {

  /**
   * Date when the QueryProductStock was completed.
   */
  private OffsetDateTime completedQueryProductStockDate;

  /**
   * Date when the QueryProductStock was created.
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
   * A list of query product stock item - only present in response.
   */
  @JsonProperty("queryProductStockItem")
  private List<@Valid ProductStock> queryProductStockItems;

  /**
   * A list of related party references (RelatedParty [*]). A related party
   * defines party or party role linked to this QueryProductStock.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Date when the stock availability should be query.
   */
  private OffsetDateTime requestedAvailabilityDate;

  /**
   * Date when the requester wished to have a response for this product stock
   * query.
   */
  private OffsetDateTime requestedQueryProductStockDate;

  /**
   * ProductStock is a base class for defining a product (or configured product
   * with values characteristic) stock level.
   */
  private @Valid ProductStock searchCriteria;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}