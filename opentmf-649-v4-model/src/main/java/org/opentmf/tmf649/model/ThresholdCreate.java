package org.opentmf.tmf649.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.general.model.ThresholdRule;

/**
 * A threshold base entity containing threshold rules.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name, thresholdRule<br/>
 * </p>
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
    defaultImpl = ThresholdCreate.class
)
@Required(fields = {"name", "thresholdRule"})
public class ThresholdCreate extends Extensible implements IThresholdCreate {

  /**
   * A description of the threshold.
   */
  private @SafeText String description;

  /**
   * A word, term, or phrase by which a Performance threshold is known and
   * distinguished from other thresholds.
   */
  private @SafeText String name;

  /**
   * A Performance Threshold contains a set of Performance threshold rules of
   * different conditions (Raise, Clear) and different severities.
   */
  @JsonProperty("thresholdRule")
  private @Size(min = 1) List<@Valid ThresholdRule> thresholdRules;
}