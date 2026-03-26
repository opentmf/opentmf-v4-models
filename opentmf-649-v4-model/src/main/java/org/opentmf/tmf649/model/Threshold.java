package org.opentmf.tmf649.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.ThresholdRule;

/**
 * A threshold base entity containing threshold rules.
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
    defaultImpl = Threshold.class
)
public class Threshold extends NamedEntity implements IThreshold {

  /**
   * A description of the threshold.
   */
  private @SafeText String description;

  /**
   * A Performance Threshold contains a set of Performance threshold rules of
   * different conditions (Raise, Clear) and different severities.
   */
  @JsonProperty("thresholdRule")
  private List<@Valid ThresholdRule> thresholdRules;
}