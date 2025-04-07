package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.EntityRef;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among product specifications.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = ProductSpecificationRelationship.class
)
public class ProductSpecificationRelationship extends EntityRef {

  /**
   * Type of relationship such as migration, substitution, dependency,
   * exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which the productSpecificationRelationship is valid.
   */
  private @Valid TimePeriod validFor;
}