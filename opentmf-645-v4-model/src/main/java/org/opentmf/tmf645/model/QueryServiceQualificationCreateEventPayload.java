package org.opentmf.tmf645.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class QueryServiceQualificationCreateEventPayload implements IQueryServiceQualificationCreateEventPayload {

  /**
   * QueryServiceQualification is used to retrieve a list of services that are
   * technically available in the context of the interaction (place, party,
   * service characteristics, ...).
   */
  private @Valid QueryServiceQualification queryServiceQualification;
}