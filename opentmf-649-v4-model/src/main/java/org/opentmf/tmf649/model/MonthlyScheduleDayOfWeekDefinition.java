package org.opentmf.tmf649.model;

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
 *   <li>TMF-649: Performance Thresholding Management API</li>
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
    defaultImpl = MonthlyScheduleDayOfWeekDefinition.class
)
public class MonthlyScheduleDayOfWeekDefinition extends Extensible implements IMonthlyScheduleDayOfWeekDefinition {

  @JsonProperty("dayOfMonthRecurrence")
  private List<@Valid DayOfMonthRecurrence> dayOfMonthRecurrences;

  private @SafeText String recurringDaySequence;
}