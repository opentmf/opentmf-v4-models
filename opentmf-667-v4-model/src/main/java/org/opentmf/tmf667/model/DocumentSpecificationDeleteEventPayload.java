package org.opentmf.tmf667.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DocumentSpecificationDeleteEventPayload implements IDocumentSpecificationDeleteEventPayload {

  /**
   * A DocumentSpecification provides the characteristics and constraints that
   * describe a particular type of Document. It follows the EntitySpecification
   * pattern, so allows you to define the characteristics expected, as well as the
   * nature of the values of those characteristics (eg: integer range
   * [valueFrom/valueTo], regular expression or unitOfMeasure).
   */
  private @Valid DocumentSpecification documentSpecification;
}