package org.opentmf.tmf714.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-714: Work Qualification Management</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class QueryWorkQualificationCreateEventPayload implements IQueryWorkQualificationCreateEventPayload {

  /**
   * QueryWorkQualification is used to retrieve a list of units of work that are
   * valid in the context of the interaction.
   */
  private @Valid QueryWorkQualification queryWorkQualification;
}