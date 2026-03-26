package org.opentmf.tmf687.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.MarketSegmentRef;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * ReserveProductStock is used to request a product stock reservation
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> reserveProductStockItem<br/>
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
    defaultImpl = ReserveProductStockCreate.class
)
@Required(fields = {"reserveProductStockItem"})
public class ReserveProductStockCreate extends Extensible implements IReserveProductStockCreate {

  /**
   * Channel(s) beneficiary(ies) for this reservation.
   */
  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * Date when the ReserveProductStock was created (whatever its status).
   */
  private OffsetDateTime creationDate;

  /**
   * Market segment(s) beneficiary(ies) for this reservation.
   */
  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue place;

  /**
   * A list of related entity in relationship with this stock reservation (trouble
   * ticket, quote, product order, etc...).
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * A list of related party references (RelatedParty [*]). A related party
   * defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Requested product availability date for the reservation.
   */
  private OffsetDateTime requiredAvailabilityDate;

  /**
   * A list of product stock item reservation.
   */
  @JsonProperty("reserveProductStockItem")
  private @Size(min = 1) List<@Valid ReserveProductStockItem> reserveProductStockItems;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String reserveProductStockState;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}