package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ChannelRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedPartyRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-716: ResourceReservation</li>
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
    defaultImpl = ResourceReservationUpdate.class
)
public class ResourceReservationUpdate extends Extensible implements IResourceReservationUpdate {

  /**
   * Date when the reservation is cancelled.
   */
  private @SafeText String cancellationDate;

  /**
   * Reason why the reservation is cancelled.
   */
  private @SafeText String cancellationReason;

  /**
   * The channel to which the resource reference to. e.g. channel for selling
   * product offerings, channel for opening a trouble ticket etc..
   */
  private @Valid ChannelRef channel;

  /**
   * Date when the reservation was completed.
   */
  private @SafeText String completionDate;

  /**
   * Date when the reservation was created.
   */
  private OffsetDateTime creationDate;

  /**
   * A string. free-text description of the reservation.
   */
  private @SafeText String description;

  /**
   * Expected completion date amended by the provider.
   */
  private @SafeText String expectedCompletionDate;

  /**
   * List of: A reference to an entity, where the type of the entity is not known
   * in advance.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * List of: RelatedParty reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedPartyRef> relatedParties;

  /**
   * Requested completion date from the requester perspective.
   */
  private @SafeText String requestedCompletionDate;

  /**
   * Reservation fulfillment start date wished by the requester. This is used
   * when, for any reason, requester cannot allow the reservation to begin before
   * a specific date.
   */
  private @SafeText String requestedStartDate;

  @JsonProperty("reservationItem")
  private List<@Valid ResourceReservationItem> reservationItems;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod reservationPeriod;

  /**
   * <p>Recommended values: acknowledged, rejected, pending, held, inProgress,
   * cancelled, completed, failed, partial, assessingCancellation,
   * pendingCancellation.
   *
   * @see org.opentmf.tmf716.model.ReservationStateType
   */
  private @SafeText String state;

  /**
   * The date and time the state changed.
   */
  private OffsetDateTime stateChangeDate;

  /**
   * The reason for changing the state.
   */
  private @SafeText String stateChangeReason;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}