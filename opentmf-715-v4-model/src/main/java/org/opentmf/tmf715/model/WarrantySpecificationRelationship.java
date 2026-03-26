package org.opentmf.tmf715.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Place;
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
    defaultImpl = WarrantySpecificationRelationship.class
)
@Required(fields = {"relationshipType"})
public class WarrantySpecificationRelationship extends Place implements IWarrantySpecificationRelationship {

  /**
   * Type of relationship such as migration, substitution, dependency,
   * exclusivity.
   */
  private @SafeText String relationshipType;
}