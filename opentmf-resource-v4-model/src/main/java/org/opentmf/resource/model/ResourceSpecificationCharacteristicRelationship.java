package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among ResourceSpecificationCharacteristics. The
 * specification characteristic is embedded within the specification whose ID
 * and href are in this entity, and identified by its ID.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = ResourceSpecificationCharacteristicRelationship.class
)
public class ResourceSpecificationCharacteristicRelationship extends Extensible implements IResourceSpecificationCharacteristicRelationship {

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
   * Type of relationship such as aggregation, migration, substitution,
   * dependency, exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * Hyperlink reference to the resource specification containing the target
   * characteristic.
   */
  private URI resourceSpecificationHref;

  /**
   * Unique identifier of the resource specification containing the target
   * characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String resourceSpecificationId;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}