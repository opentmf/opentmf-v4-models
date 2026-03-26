package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationSpecificationRef;
import org.opentmf.common.model.Place;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among entity specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
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
    defaultImpl = ShipmentSpecificationRelationship.class
)
@Required(fields = {"relationshipType"})
public class ShipmentSpecificationRelationship extends Place implements IShipmentSpecificationRelationship {

  /**
   * reference to an AssociationSpecification object.
   */
  private @Valid AssociationSpecificationRef associationSpec;

  /**
   * Type of relationship such as migration, substitution, dependency,
   * exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}