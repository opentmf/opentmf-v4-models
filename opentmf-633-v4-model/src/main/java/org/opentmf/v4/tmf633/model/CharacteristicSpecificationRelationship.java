package org.opentmf.v4.tmf633.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among Characteristic specifications. The specification
 * characteristic is embedded within the specification whose ID and href are in
 * this entity, and identified by its ID.
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
public class CharacteristicSpecificationRelationship {

  /**
   * Unique identifier of the characteristic within the specification.
   */
  @SafeId
  @Size(max = 100)
  private String characteristicSpecificationId;

  /**
   * Name of the target characteristic within the specification.
   */
  private @SafeText String name;

  /**
   * Hyperlink reference to the parent specification containing the target
   * characteristic.
   */
  private URI parentSpecificationHref;

  /**
   * Unique identifier of the parent specification containing the target
   * characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String parentSpecificationId;

  /**
   * Type of relationship such as aggregation, migration, substitution,
   * dependency, exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which the object is valid.
   */
  private @Valid TimePeriod validFor;
}