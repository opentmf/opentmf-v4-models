package org.opentmf.v4.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.v4.common.model.CharacteristicRelationship;

/**
 * Linked resources to the one instantiate, such as [bundled] if the resource is
 * a bundle and you want to describe the bundled resources inside this bundle;
 * [reliesOn] if the resource needs another already owned resource to rely on
 * (e.g. an option on an already owned mobile access resource) [targets] or
 * [isTargeted] (depending on the way of expressing the link) for any other kind
 * of links that may be useful.
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType, resource<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = ResourceRelationship.class
)
@Required(fields = {"relationshipType", "resource"})
public class ResourceRelationship extends CharacteristicRelationship {

  private @Valid ResourceRefOrValue resource;
}