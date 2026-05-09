package org.opentmf.tmf653.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ServiceRef;
import org.opentmf.common.model.ServiceTestSpecificationRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A service test is an entity that exists for a controlled test invocation on a
 * service. The service 
 * <br/>test is executed according to a schedule and contains service test
 * configuration parameters that are to be 
 * <br/>applied at execution time, and service test measures that result.
 * <br/>Skipped properties: id,href,{@literal @}type,{@literal @}schemaLocation,{@literal @}baseType.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-653: Service Test Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceTestUpdate implements IServiceTestUpdate {

  /**
   * List of characteristics with values that define the test run.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * Description of the service test.
   */
  private @SafeText String description;

  /**
   * The end date and time of the service test.
   */
  private OffsetDateTime endDateTime;

  /**
   * An indication of whether the service test is running in 
   * <br/>"PROACTIVE" or "ONDEMAND" mode.
   */
  private @SafeText String mode;

  /**
   * The name of the service test.
   */
  private @SafeText String name;

  /**
   * Party related to the test.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Service reference, for when Service is used by other entities.
   */
  private @Valid ServiceRef relatedService;

  /**
   * The start date and time of the service test.
   */
  private OffsetDateTime startDateTime;

  /**
   * The actual state the service test is in. Recommended states are found in
   * ExecutionStateType schema possible values include acknowledged, rejected,
   * pending, inProgress, cancelled, completed and failed.
   */
  private @SafeText String state;

  /**
   * The results of the test in terms of the measured metrics.
   */
  @JsonProperty("testMeasure")
  private List<@Valid TestMeasure> testMeasures;

  /**
   * The service test specification used by the service test.
   */
  private @Valid ServiceTestSpecificationRef testSpecification;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}