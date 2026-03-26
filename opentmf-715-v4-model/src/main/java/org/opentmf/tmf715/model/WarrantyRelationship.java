package org.opentmf.tmf715.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Linked products to the one instantiate, such as [bundled] if the product is a
 * bundle and you want to describe the bundled products inside this bundle;
 * [reliesOn] if the product needs another already owned product to rely on
 * (e.g. an option on an already owned mobile access product) [targets] or
 * [isTargeted] (depending on the way of expressing the link) for any other kind
 * of links that may be useful.
 *
 * <p><br/>
 * <strong>Required:</strong> relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-715: Warranty Management</li>
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
    defaultImpl = WarrantyRelationship.class
)
@Required(fields = {"relationshipType"})
public class WarrantyRelationship extends Entity implements IWarrantyRelationship {

  /**
   * Type of the product relationship, such as [bundled] if the product is a
   * bundle and you want to describe the bundled products inside this bundle;
   * [reliesOn] if the product needs another already owned product to rely on
   * (e.g. an option on an already owned mobile access product) [targets] or
   * [isTargeted] (depending on the way of expressing the link) for any other kind
   * of links that may be useful.
   */
  private @SafeText String relationshipType;
}