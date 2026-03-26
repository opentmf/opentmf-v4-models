package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationSpecificationRef;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A uni-directionmal relationship from this entity to a target entity instance.
 *
 * <p><br/>
 * <strong>Required:</strong> entity, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-703: Entity Inventory Management API</li>
 *   <li>TMF-715: Warranty Management</li>
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
    defaultImpl = EntityRelationship.class
)
@Required(fields = {"relationshipType", "entity"})
public class EntityRelationship extends Extensible implements IEntityRelationship {

  /**
   * reference to an AssociationSpecification object.
   */
  private @Valid AssociationSpecificationRef associationSpec;

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef entity;

  /**
   * Type of relationship such as containment, substitution, dependency,
   * exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * The association role for this entity.
   */
  private @SafeText String role;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}