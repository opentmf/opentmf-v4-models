package org.opentmf.tmf921.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-921: Intent Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class IntentReportCreateEventPayload implements IIntentReportCreateEventPayload {

  /**
   * IntentReport is the mechanism to report back to Intent owner on an Intents
   * status.
   */
  private @Valid IntentReport intentReport;
}