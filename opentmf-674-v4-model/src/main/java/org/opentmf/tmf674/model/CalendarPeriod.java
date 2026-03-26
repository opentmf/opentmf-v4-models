package org.opentmf.tmf674.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
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
    defaultImpl = CalendarPeriod.class
)
public class CalendarPeriod extends Extensible implements ICalendarPeriod {

  /**
   * Days when the calendar status applies (e.g.: monday, mon-to-fri, weekdays,
   * weekend, all week, ...).
   */
  private @SafeText String day;

  @JsonProperty("hourPeriod")
  private List<@Valid HourPeriod> hourPeriods;

  /**
   * Indication of the availability of the site (e.g.: open).
   */
  private @SafeText String status;

  /**
   * Indication of the timezone applicable to the calendar information (e.g.:
   * Paris, GMT+1).
   */
  private @SafeText String timeZone;
}