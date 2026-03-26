package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Another Characteristic that is related to the current Characteristic;.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-644: Privacy Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 *   <li>TMF-655: Change Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-681: Communication Management API</li>
 *   <li>TMF-686: Topology API</li>
 *   <li>TMF-687: Stock Management API</li>
 *   <li>TMF-688: Event Management API</li>
 *   <li>TMF-696: Risk Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-701: Process Flow Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-703: Entity Inventory Management API</li>
 *   <li>TMF-704: Test Case Management API</li>
 *   <li>TMF-705: Test Environment Management API</li>
 *   <li>TMF-706: Test Data Management API</li>
 *   <li>TMF-709: Test Scenario Management API</li>
 *   <li>TMF-710: General Test Artifact Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-714: Work Qualification Management</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-717: Customer360 Management API</li>
 *   <li>TMF-724: Incident Management API</li>
 *   <li>TMF-727: Service Usage Management API</li>
 *   <li>TMF-728: Dunning Case Management</li>
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
    defaultImpl = CharacteristicRelationship.class
)
public class CharacteristicRelationship extends Entity implements ICharacteristicRelationship {

  /**
   * The type of relationship.
   */
  private @SafeText String relationshipType;
}