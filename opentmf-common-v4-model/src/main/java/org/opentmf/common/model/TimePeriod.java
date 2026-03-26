package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * A period of time, either as a deadline (endDateTime only) a startDateTime
 * only, or both.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-621: Trouble Ticket Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-644: Privacy Management API</li>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-646: Appointment Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 *   <li>TMF-651: Agreement Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 *   <li>TMF-654: Prepay Balance Management API</li>
 *   <li>TMF-655: Change Management API</li>
 *   <li>TMF-657: Service Quality Management Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-668: Partnership Type</li>
 *   <li>TMF-669: Party Role Management API</li>
 *   <li>TMF-670: Payment Method Management API</li>
 *   <li>TMF-671: Promotion Management API</li>
 *   <li>TMF-672: User Role Permission Management API</li>
 *   <li>TMF-674: Geographic Site Management API</li>
 *   <li>TMF-676: Payment Management API</li>
 *   <li>TMF-677: Usage Consumption Management API</li>
 *   <li>TMF-678: Customer Bill Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-680: Recommendation Management API</li>
 *   <li>TMF-681: Communication Management API</li>
 *   <li>TMF-683: Party Interaction Management API</li>
 *   <li>TMF-686: Topology API</li>
 *   <li>TMF-687: Stock Management API</li>
 *   <li>TMF-691: Federated ID Management API</li>
 *   <li>TMF-699: Sales Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-701: Process Flow Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-703: Entity Inventory Management API</li>
 *   <li>TMF-704: Test Case Management API</li>
 *   <li>TMF-705: Test Environment Management API</li>
 *   <li>TMF-706: Test Data Management API</li>
 *   <li>TMF-707: Test Result Management API</li>
 *   <li>TMF-709: Test Scenario Management API</li>
 *   <li>TMF-710: General Test Artifact Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-714: Work Qualification Management</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-717: Customer360 Management API</li>
 *   <li>TMF-720: Digital Identity Management API</li>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 *   <li>TMF-728: Dunning Case Management</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
 *   <li>TMF-915: AI Management API</li>
 *   <li>TMF-921: Intent Management API</li>
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
    defaultImpl = TimePeriod.class
)
public class TimePeriod extends Entity implements ITimePeriod {

  /**
   * End of the time period, using IETC-RFC-3339 format.
   */
  private OffsetDateTime endDateTime;

  /**
   * Start of the time period, using IETC-RFC-3339 format.
   */
  private OffsetDateTime startDateTime;
}