package org.opentmf.tmf686.model;

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
 * relationship between/among VertexSpecificationCharacteristics. The
 * specification characteristic is embedded within the specification whose ID
 * and href are in this entity, and identified by its ID.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-686: Topology API</li>
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
    defaultImpl = VertexSpecificationCharacteristicRelationship.class
)
public class VertexSpecificationCharacteristicRelationship extends Extensible implements IVertexSpecificationCharacteristicRelationship {

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
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Hyperlink reference to the vertex specification containing the target
   * characteristic.
   */
  private URI vertexSpecificationHref;

  /**
   * Unique identifier of the vertex specification containing the target
   * characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String vertexSpecificationId;
}