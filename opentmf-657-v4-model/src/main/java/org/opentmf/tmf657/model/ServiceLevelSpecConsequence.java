package org.opentmf.tmf657.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Some consequences for the provider of the Service are resulted when the
 * service level objective
 * <br/>does not meet.
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
    defaultImpl = ServiceLevelSpecConsequence.class
)
public class ServiceLevelSpecConsequence extends Extensible implements IServiceLevelSpecConsequence {

  /**
   * Recommended remedy for a violated Service Level Objective. 
   * <br/>This could be a hyperlink to the recommended action.
   */
  private @SafeText String prescribedAction;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}