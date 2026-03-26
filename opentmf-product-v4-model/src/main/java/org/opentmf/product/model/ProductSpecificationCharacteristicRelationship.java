package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among productSpecificationCharacteristics.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = ProductSpecificationCharacteristicRelationship.class
)
public class ProductSpecificationCharacteristicRelationship extends NamedEntity implements IProductSpecificationCharacteristicRelationship {

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
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}