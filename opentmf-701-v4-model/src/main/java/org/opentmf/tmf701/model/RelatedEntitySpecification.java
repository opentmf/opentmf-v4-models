package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.RelatedEntityRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A reference to an entity specification, where the type of the entity
 * specification is not known in advance.
 *
 * <p><br/>
 * <strong>Required:</strong> @referredType, id, role<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-701: Process Flow Management API</li>
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
    defaultImpl = RelatedEntitySpecification.class
)
@Required(fields = {"atReferredType", "role", "id"})
public class RelatedEntitySpecification extends RelatedEntityRefOrValue implements IRelatedEntitySpecification {

  /**
   * EntitySpecification version.
   */
  private @SafeText String version;
}