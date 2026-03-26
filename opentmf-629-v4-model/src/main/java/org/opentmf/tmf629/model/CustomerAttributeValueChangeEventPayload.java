package org.opentmf.tmf629.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.customer.model.Customer;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-629: Customer Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CustomerAttributeValueChangeEventPayload implements ICustomerAttributeValueChangeEventPayload {

  private @Valid Customer customer;
}