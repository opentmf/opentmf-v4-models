package org.opentmf.tmf677.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = UsageConsumptionProductRef.class
)
@Required(fields = {"id"})
public class UsageConsumptionProductRef extends EntityRef implements IUsageConsumptionProductRef {

  /**
   * List of: The consumption counters (called ConsumptionSummary in the SID
   * model) detail for example the different kind of consumption done on the
   * bucket.
   */
  @JsonProperty("consumptionSummary")
  private List<@Valid ConsumptionSummary> consumptionSummaries;
}