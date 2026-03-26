package org.opentmf.tmf715.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-715: Warranty Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class WarrantySpecificationDeleteEventPayload implements IWarrantySpecificationDeleteEventPayload {

  private @Valid WarrantySpecification warrantySpecification;
}