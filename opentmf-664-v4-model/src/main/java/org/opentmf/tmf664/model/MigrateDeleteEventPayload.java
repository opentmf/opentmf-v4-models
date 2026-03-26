package org.opentmf.tmf664.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

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
public class MigrateDeleteEventPayload implements IMigrateDeleteEventPayload {

  /**
   * Task resource used to request migration of the Resource Function.
   */
  private @Valid Migrate migrate;
}