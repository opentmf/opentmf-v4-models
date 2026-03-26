package org.opentmf.tmf649.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Monitored objects are specified by the MonitoredObjectsCriteria.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class MonitoredObjectsCriteria implements IMonitoredObjectsCriteria {

  /**
   * A filter that can be used in conjunction with the monitored object class for
   * specifying the set of instances that are referenced.
   */
  private @SafeText String monitoredObjectFilter;
}