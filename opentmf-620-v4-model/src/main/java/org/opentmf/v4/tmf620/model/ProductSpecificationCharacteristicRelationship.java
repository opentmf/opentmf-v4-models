package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.NamedEntity;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among productSpecificationCharacteristics.
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
    defaultImpl = ProductSpecificationCharacteristicRelationship.class
)
public class ProductSpecificationCharacteristicRelationship extends NamedEntity {

  /**
   * The order in which a CharacteristicSpecification appears within another
   * CharacteristicSpecification that defines a grouping of
   * CharacteristicSpecifications.
   * <br/>
   * <br/>For example, a grouping may represent the name of an individual. The
   * given name is first, the middle name is second, and the last name is third.
   */
  private Integer charSpecSeq;

  /**
   * Type of relationship such as aggregation, migration, substitution,
   * dependency, exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which the productSpecificationCharacteristicRelationship is
   * valid.
   */
  private @Valid TimePeriod validFor;
}