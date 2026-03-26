package org.opentmf.tmf646.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.RelatedPlaceRefOrValue;
import org.opentmf.common.model.TimeSlot;

/**
 * This task resource is used to retrieve available time slots. One of this
 * available time slot is after used to create or reschedule an appointment
 * <br/>Skipped properties:
 * id,href,status,searchDate,searchResult,availableTimeSlot.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-646: Appointment Management API</li>
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
    defaultImpl = SearchTimeSlotCreate.class
)
public class SearchTimeSlotCreate extends Extensible implements ISearchTimeSlotCreate {

  /**
   * List of: A reference to an entity, where the type of the entity is not known
   * in advance.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * Related Party reference. A related party defines party or party role linked
   * to a specific entity.
   */
  private @Valid RelatedParty relatedParty;

  /**
   * Related Entity reference. A related place defines a place described by
   * reference or by value linked to a specific entity. The polymorphic attributes
   * {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place entity and
   * not the RelatedPlaceRefOrValue class itself.
   */
  private @Valid RelatedPlaceRefOrValue relatedPlace;

  @JsonProperty("requestedTimeSlot")
  private List<@Valid TimeSlot> requestedTimeSlots;
}