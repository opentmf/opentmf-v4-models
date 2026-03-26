package org.opentmf.tmf657.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Service level objectives are defined in terms of parameters and metrics,
 * thresholds, and tolerances 
 * <br/>associated with the parameters.
 * <br/>Skipped properties: id,href,validFor.
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
    defaultImpl = ServiceLevelObjectiveUpdate.class
)
public class ServiceLevelObjectiveUpdate extends Extensible implements IServiceLevelObjectiveUpdate {

  /**
   * An operator that specifies whether a Service Level Objective is 
   * <br/>violated above or below the conformanceTarget.
   */
  private @SafeText String conformanceComparator;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod conformancePeriod;

  /**
   * A value used to determine if Service Level Objective is met. 
   * <br/>The data type should be adjusted case by case.
   */
  private @SafeText String conformanceTarget;

  /**
   * The number of times an objective can remain un-updated without 
   * <br/>a violation of a Service Level Agreement in reference to a measurement
   * period and/or Service Level Agreement reporting period.
   */
  private @SafeText String graceTimes;

  /**
   * The name of the service level objectives.
   */
  private @SafeText String name;

  /**
   * A list of consequences for this objective.
   */
  @JsonProperty("serviceLevelObjectiveConsequence")
  private List<@Valid ServiceLevelSpecConsequence> serviceLevelObjectiveConsequences;

  /**
   * Service Level Specification parameters can be one of two types. A Key Quality
   * Indicator (KQI) 
   * <br/>provides a measurement of a specific aspect of the performance of a
   * Product (i.e., Product 
   * <br/>Specification, Product Offering, or Product) or a Service (i.e., Service
   * Specification or Service).
   */
  private @Valid ServiceLevelSpecParameter serviceLevelObjectiveParameter;

  /**
   * A value that used to specify when a warning should be used 
   * <br/>that indicates an objective is danger of not being met. Notice, the data
   * type should be adjusted case by case.
   */
  private @SafeText String thresholdTarget;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod tolerancePeriod;

  /**
   * A value that specifies the allowable variation of a conformance 
   * <br/>Target. The data type should be adjusted case by case.
   */
  private @SafeText String toleranceTarget;
}