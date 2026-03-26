package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedPartyRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An identified part of the reservation. A reservation is decomposed into one
 * or more reservation items.
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
    defaultImpl = ReservationItem.class
)
public class ReservationItem extends Extensible implements IReservationItem {

  /**
   * action to be performed on the entity
   * <br/><p>Recommended values: add, modify, delete, noChange.
   *
   * @see org.opentmf.tmf716.model.ReservationItemActionType
   */
  private @SafeText String action;

  /**
   * Specific ability of an entity measured in quantity and units of quantity over
   * an extended period.
   */
  private @Valid Capacity appliedCapacity;

  /**
   * Specific ability of an entity measured in quantity and units of quantity over
   * an extended period.
   */
  private @Valid Capacity capacityDemand;

  /**
   * A string. Identifier of the item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  private Integer quantity;

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
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod reservationPeriod;

  /**
   * <p>Recommended values: acknowledged, rejected, pending, held, inProgress,
   * cancelled, completed, failed, partial, assessingCancellation,
   * pendingCancellation.
   *
   * @see org.opentmf.tmf716.model.ReservationItemStateType
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