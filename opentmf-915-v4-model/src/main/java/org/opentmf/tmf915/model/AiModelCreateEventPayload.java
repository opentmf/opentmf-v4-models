package org.opentmf.tmf915.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-915: AI Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AiModelCreateEventPayload implements IAiModelCreateEventPayload {

  /**
   * AiModel is a base class for defining the AiModel hierarchy.
   */
  private @Valid AiModel aiModel;
}