package org.opentmf.customer.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer.class
)
@Required(fields = {"engagedParty"})
public class Customer extends CustomerUpdate implements ICustomer {

  /**
   * Url used to reference the customer.
   */
  private URI href;

  /**
   * Unique identifier for Customers.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}