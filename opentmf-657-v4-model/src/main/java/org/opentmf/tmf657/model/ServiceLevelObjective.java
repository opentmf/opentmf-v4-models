package org.opentmf.tmf657.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Service level objectives are defined in terms of parameters and metrics,
 * thresholds, and tolerances 
 * <br/>associated with the parameters.
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
    defaultImpl = ServiceLevelObjective.class
)
public class ServiceLevelObjective extends ServiceLevelObjectiveCreate implements IServiceLevelObjective {

  /**
   * The hyperlink to access a service level objective.
   */
  private URI href;

  /**
   * The identifier of a service level objectives.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}