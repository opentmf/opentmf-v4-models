package org.opentmf.tmf664.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.resource.model.ResourceFunction;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceFunctionAttributeValueChangeEventPayload implements IResourceFunctionAttributeValueChangeEventPayload {

  /**
   * A ResourceFunction is a behavior to transform inputs of any nature into
   * outputs of any nature independently from the way it is provided.
   */
  private @Valid ResourceFunction resourceFunction;
}