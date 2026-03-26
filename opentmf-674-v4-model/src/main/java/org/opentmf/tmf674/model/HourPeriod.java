package org.opentmf.tmf674.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-674: Geographic Site Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = HourPeriod.class
)
public class HourPeriod extends Extensible implements IHourPeriod {

  /**
   * The time when the status ends applying.
   */
  private @SafeText String endHour;

  /**
   * The time when the status starts applying.
   */
  private @SafeText String startHour;
}