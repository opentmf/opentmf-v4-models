package org.opentmf.tmf713.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-713: Work Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class WorkSpecificationAttributeValueChangeEventPayload implements IWorkSpecificationAttributeValueChangeEventPayload {

  /**
   * Definition of the nature of a Work Unit. For example, could be wiring,
   * equipment installation, etc.
   */
  private @Valid WorkSpecification workSpecification;
}