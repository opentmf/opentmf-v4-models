package org.opentmf.tmf657.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Service level objectives are defined in terms of parameters and metrics,
 * thresholds, and tolerances 
 * <br/>associated with the parameters.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> conformanceComparator, conformanceTarget, serviceLevelObjectiveParameter<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-657: Service Quality Management Management API</li>
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
    defaultImpl = ServiceLevelObjectiveCreate.class
)
@Required(fields = {"conformanceComparator", "serviceLevelObjectiveParameter", "conformanceTarget"})
public class ServiceLevelObjectiveCreate extends ServiceLevelObjectiveUpdate implements IServiceLevelObjectiveCreate {

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}