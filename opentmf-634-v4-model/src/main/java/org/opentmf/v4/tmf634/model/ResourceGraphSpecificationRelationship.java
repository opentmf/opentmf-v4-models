package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.CharacteristicRelationship;

/**
 * Describes link between resource graph specifications.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = ResourceGraphSpecificationRelationship.class
)
public class ResourceGraphSpecificationRelationship extends CharacteristicRelationship {

  /**
   * A reference to the related resource graph specification.
   */
  private @Valid ResourceGraphSpecificationRef resourceGraph;
}