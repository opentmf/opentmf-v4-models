package org.opentmf.tmf678.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * This resource is used to manage the creation request of a customer bill in
 * real-time (on demand).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-678: Customer Bill Management API</li>
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
    defaultImpl = CustomerBillOnDemand.class
)
public class CustomerBillOnDemand extends CustomerBillOnDemandCreate implements ICustomerBillOnDemand {

  /**
   * Reference of the customer bill on demand request.
   */
  private URI href;

  /**
   * Unique identifier of the customer bill on demand request given by the server.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}