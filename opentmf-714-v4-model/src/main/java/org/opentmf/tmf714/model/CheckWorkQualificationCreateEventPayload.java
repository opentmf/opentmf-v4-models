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
public class CheckWorkQualificationCreateEventPayload implements ICheckWorkQualificationCreateEventPayload {

  /**
   * CheckWorkQualification is used to validate specific units of work.
   */
  private @Valid CheckWorkQualification checkWorkQualification;
}