package org.opentmf.tmf633.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ServiceSpecification;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceSpecificationChangeEventPayload implements IServiceSpecificationChangeEventPayload {

  /**
   * ServiceSpecification is a class that offers characteristics to describe a
   * type of service.
   * <br/>Functionally, it acts as a template by which Services may be
   * instantiated. By sharing the same specification, these services would
   * therefore share the same set of characteristics.
   */
  private @Valid ServiceSpecification serviceSpecification;
}