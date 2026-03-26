package org.opentmf.tmf662.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntitySpecification;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-662: Entity Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class EntitySpecificationDeleteEventPayload implements IEntitySpecificationDeleteEventPayload {

  /**
   * EntitySpecification is a class that offers characteristics to describe a type
   * of entity. Entities are generic constructs that may be used to describe
   * bespoke business entities that are not effectively covered by the existing
   * SID model.
   * <br/>Functionally, the entity specification acts as a template by which
   * entities may be instantiated and described. By sharing the same
   * specification, these entities would therefore share the same set of
   * characteristics.
   * <br/>Note: The ‘configurable’ attribute on the specCharacteristics determines
   * if an entity instantiated from the entity specification can override the
   * value of the attribute. When set to false, the entity instance may not define
   * a value that differs from the value in the specification.
   */
  private @Valid EntitySpecification entitySpecification;
}