package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

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
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = EntitySpecification.class
)
public class EntitySpecification extends UsageSpecificationUpdate implements IEntitySpecification {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}