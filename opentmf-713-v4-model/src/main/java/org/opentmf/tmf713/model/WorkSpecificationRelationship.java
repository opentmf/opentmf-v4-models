package org.opentmf.tmf713.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationSpecificationRef;
import org.opentmf.common.model.RelatedEntityRefOrValue;
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
 *   <li>TMF-713: Work Management</li>
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
    defaultImpl = WorkSpecificationRelationship.class
)
@Required(fields = {"relationshipType"})
public class WorkSpecificationRelationship extends RelatedEntityRefOrValue implements IWorkSpecificationRelationship {

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