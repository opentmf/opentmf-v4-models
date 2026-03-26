package org.opentmf.tmf635.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.product.model.Usage;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-635: Usage Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class UsageCreateEventPayload implements IUsageCreateEventPayload {

  /**
   * An occurrence of employing a Product, Service, or Resource for its intended
   * purpose, which is of interest to the business and can have charges applied to
   * it. It is comprised of characteristics, which represent attributes of usage.
   */
  private @Valid Usage usage;
}