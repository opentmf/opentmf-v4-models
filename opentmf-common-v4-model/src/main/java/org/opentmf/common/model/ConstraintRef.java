package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Constraint reference. The Constraint resource represents a policy/rule
 * applied to an entity or entity spec.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-703: Entity Inventory Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = ConstraintRef.class
)
@Required(fields = {"id"})
public class ConstraintRef extends EntityRef implements IConstraintRef {

  /**
   * constraint version.
   */
  private @SafeText String version;
}