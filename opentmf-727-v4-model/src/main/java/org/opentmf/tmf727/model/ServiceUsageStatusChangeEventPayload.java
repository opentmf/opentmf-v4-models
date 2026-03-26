package org.opentmf.tmf727.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-727: Service Usage Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceUsageStatusChangeEventPayload implements IServiceUsageStatusChangeEventPayload {

  /**
   * An occurrence of usage on a Service derived from various Resource usages,
   * which can be used for determining the Product usage. It is comprised of
   * characteristics, which represent attributes of service usage.
   */
  private @Valid ServiceUsage serviceUsage;
}