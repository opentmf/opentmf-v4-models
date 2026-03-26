package org.opentmf.tmf677.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-677: Usage Consumption Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class QueryUsageConsumptionCreateEventPayload implements IQueryUsageConsumptionCreateEventPayload {

  /**
   * An QueryUsageConsumption allows to manage the calculation request of an usage
   * consumption.
   */
  private @Valid QueryUsageConsumption queryUsageConsumption;
}