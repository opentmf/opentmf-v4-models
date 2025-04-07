package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
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
 *   <li>TMF-633: Service Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = EntitySpecificationRelationship.class
)
@Required(fields = {"relationshipType"})
public class EntitySpecificationRelationship extends RelatedEntityRefOrValue {

  /**
   * Type of relationship such as migration, substitution, dependency,
   * exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * A specification for an association used by this relationship.
   */
  private @Valid AssociationSpecificationRef associationSpec;

  /**
   * The period for which the entitySpecRelationship is valid.
   */
  private @Valid TimePeriod validFor;
}