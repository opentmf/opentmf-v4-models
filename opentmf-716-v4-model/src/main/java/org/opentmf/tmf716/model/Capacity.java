package org.opentmf.tmf716.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CapacityRef;
import org.opentmf.common.model.CapacitySpecRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PlaceRefOrValue;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Specific ability of an entity measured in quantity and units of quantity over
 * an extended period.
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
    defaultImpl = Capacity.class
)
public class Capacity extends Extensible implements ICapacity {

  /**
   * The period of time for which Capacity or CapacityDemand applies.
   */
  @JsonProperty("applicableTimePeriod")
  private List<@Valid ApplicableTimePeriod> applicableTimePeriods;

  /**
   * Quantity that defines the Capacity.
   */
  private @Valid CapacityAmount capacityAmount;

  private @Valid CapacitySpecRef capacitySpec;

  /**
   * A place described by reference or by value linked to a specific entity. The
   * polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to
   * the place entity and not the PlaceRefOrValue class itself.
   */
  private @Valid PlaceRefOrValue place;

  /**
   * An indicator that specifies whether the capacity is planned or actual.
   */
  private @SafeText String plannedOrActualCapacity;

  /**
   * related capacity.
   */
  @JsonProperty("relatedCapacity")
  private List<@Valid CapacityRef> relatedCapacities;
}