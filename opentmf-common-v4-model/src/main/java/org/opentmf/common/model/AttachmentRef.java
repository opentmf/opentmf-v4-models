package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Attachment reference. An attachment complements the description of an element
 * (for instance a product) through video, pictures.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-621: Trouble Ticket Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-646: Appointment Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 *   <li>TMF-655: Change Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-671: Promotion Management API</li>
 *   <li>TMF-678: Customer Bill Management API</li>
 *   <li>TMF-683: Party Interaction Management API</li>
 *   <li>TMF-691: Federated ID Management API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-701: Process Flow Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
 *   <li>TMF-703: Entity Inventory Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-714: Work Qualification Management</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-716: ResourceReservation</li>
 *   <li>TMF-717: Customer360 Management API</li>
 *   <li>TMF-720: Digital Identity Management API</li>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = AttachmentRef.class
)
@Required(fields = {"id"})
public class AttachmentRef extends AgreementSpecificationRef implements IAttachmentRef {

  /**
   * Link to the attachment media/content.
   */
  private URI url;
}