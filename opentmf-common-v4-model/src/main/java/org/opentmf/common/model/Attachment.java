package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Complements the description of an element (for instance a product) through
 * video, pictures...
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
 *   <li>TMF-681: Communication Management API</li>
 *   <li>TMF-683: Party Interaction Management API</li>
 *   <li>TMF-691: Federated ID Management API</li>
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
    defaultImpl = Attachment.class
)
public class Attachment extends NamedEntity implements IAttachment {

  /**
   * Attachment type such as video, picture.
   */
  private @SafeText String attachmentType;

  /**
   * The actual contents of the attachment object, if embedded, encoded as base64.
   */
  private @SafeText String content;

  /**
   * A narrative text describing the content of the attachment.
   */
  private @SafeText String description;

  /**
   * Attachment mime type such as extension file for video, picture and document.
   */
  private @SafeText String mimeType;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity size;

  /**
   * Uniform Resource Locator, is a web page address (a subset of URI).
   */
  private URI url;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}