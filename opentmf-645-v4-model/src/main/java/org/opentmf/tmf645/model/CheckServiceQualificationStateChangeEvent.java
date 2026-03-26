package org.opentmf.tmf645.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CheckServiceQualificationStateChangeEvent extends EventBase implements ICheckServiceQualificationStateChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid CheckServiceQualificationStateChangeEventPayload event;
}