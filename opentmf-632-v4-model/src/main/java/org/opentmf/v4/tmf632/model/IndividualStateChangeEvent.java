package org.opentmf.v4.tmf632.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.AddressableEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class IndividualStateChangeEvent extends AddressableEventBase {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid IndividualStateChangeEventPayload event;
}