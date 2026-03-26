package org.opentmf.common.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A time interval in a given unit of time.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class Duration implements IDuration {

  /**
   * Time interval (number of seconds, minutes, hours, etc.).
   */
  private Integer amount;

  /**
   * Unit of time (seconds, minutes, hours, etc.).
   */
  private @SafeText String units;
}