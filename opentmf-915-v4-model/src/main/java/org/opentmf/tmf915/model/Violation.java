package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRef;
import org.opentmf.common.model.Entity;
import org.opentmf.common.model.RuleRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> actualValue, consequence, operator, referenceValue<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = Violation.class
)
@Required(fields = {"consequence", "actualValue", "operator", "referenceValue"})
public class Violation extends Entity implements IViolation {

  private @SafeText String actualValue;

  /**
   * Attachment reference. An attachment complements the description of an element
   * (for instance a product) through video, pictures.
   */
  private @Valid AttachmentRef attachment;

  private @SafeText String comment;

  private @SafeText String consequence;

  private @SafeText String operator;

  private @SafeText String referenceValue;

  /**
   * Rule reference. Rule is a common pattern or Template for the SLA parameters,
   * metrics, and thresholds.
   */
  private @Valid RuleRef rule;

  private @SafeText String tolerance;

  private @SafeText String unit;

  private @SafeText String violationAverage;
}