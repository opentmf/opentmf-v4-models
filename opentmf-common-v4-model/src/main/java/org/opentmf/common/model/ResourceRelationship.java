package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

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
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = ResourceRelationship.class
)
@Required(fields = {"relationshipType", "resource"})
public class ResourceRelationship extends CharacteristicRelationship implements IResourceRelationship {

  /**
   * Resource is an abstract entity that describes the common set of attributes
   * shared by all concrete resources. The polymorphic attributes {@literal @}type,
   * {@literal @}schemaLocation & {@literal @}referredType are related to the Resource entity and not
   * the related ResourceRefOrValue class itself.
   */
  private @Valid ResourceRefOrValue resource;
}