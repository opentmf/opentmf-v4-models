package org.opentmf.v4.common.model;

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
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-681: Communication Management API</li>
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
    defaultImpl = Attachment.class
)
public class Attachment extends RelatedEntityRefOrValue {

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
   * Uniform Resource Locator, is a web page address (a subset of URI).
   */
  private URI url;

  /**
   * The size of the attachment.
   */
  private @Valid Quantity size;

  /**
   * The period of time for which the attachment is valid.
   */
  private @Valid TimePeriod validFor;
}