package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A reference to an entity, where the type of the entity is not known in
 * advance. A related entity defines a entity described by reference or by value
 * linked to a specific entity. The polymorphic attributes {@literal @}type,
 * {@literal @}schemaLocation & {@literal @}referredType are related to the Entity and not the
 * RelatedEntityRefOrValue class itself.
 *
 * <p><br/>
 * <strong>Required:</strong> role<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = RelatedEntityRefOrValue.class
)
@Required(fields = {"role"})
public class RelatedEntityRefOrValue extends EntityRefOrValue {

  private @SafeText String role;
}