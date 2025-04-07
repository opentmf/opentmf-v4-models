package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Used when an API throws an Error, typically with a HTTP error response-code
 * (3xx, 4xx, 5xx).
 *
 * <p><br/>
 * <strong>Required:</strong> code, reason<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-669: Party Role Management API</li>
 *   <li>TMF-673: Geographic Address Management API</li>
 *   <li>TMF-674: Geographic Site Management API</li>
 *   <li>TMF-675: Geographic Location API</li>
 *   <li>TMF-681: Communication Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@ToString
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Error.class
)
@Required(fields = {"reason", "code"})
public class Error extends Extensible {

  /**
   * Application relevant detail, defined in the API or a common list.
   */
  private @SafeText String code;

  /**
   * Explanation of the reason for the error which can be shown to a client user.
   */
  private @SafeText String reason;

  /**
   * More details and corrective actions related to the error which can be shown
   * to a client user.
   */
  private @SafeText String message;

  /**
   * HTTP Error code extension.
   */
  private @SafeText String status;

  /**
   * URI of documentation describing the error.
   */
  private URI referenceError;
}