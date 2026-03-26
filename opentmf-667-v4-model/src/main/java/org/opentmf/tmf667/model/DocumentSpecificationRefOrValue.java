package org.opentmf.tmf667.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntitySpecification;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A DocumentSpecificationRefOrValue where you can select between a
 * DocumentSpecification (by Value) or a DocumentSpecificationRef (by
 * Reference).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
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
    defaultImpl = DocumentSpecificationRefOrValue.class
)
public class DocumentSpecificationRefOrValue extends EntitySpecification implements IDocumentSpecificationRefOrValue {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;
}