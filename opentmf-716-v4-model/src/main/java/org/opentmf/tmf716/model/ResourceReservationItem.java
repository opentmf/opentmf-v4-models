package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ResourceRefOrValue;

/**
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
    defaultImpl = ResourceReservationItem.class
)
public class ResourceReservationItem extends ReservationItem implements IResourceReservationItem {

  @JsonProperty("reservationItem")
  private List<@Valid ResourceReservationItem> reservationItems;

  /**
   * Resource is an abstract entity that describes the common set of attributes
   * shared by all concrete resources. The polymorphic attributes {@literal @}type,
   * {@literal @}schemaLocation & {@literal @}referredType are related to the Resource entity and not
   * the related ResourceRefOrValue class itself.
   */
  private @Valid ResourceRefOrValue resource;
}