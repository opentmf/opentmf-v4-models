package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Entity;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Aspects of the agreement not formally specified elsewhere in the agreement
 * and that cannot be captured elsewhere in a formal notation, or automatically
 * monitored and require a more human level of management.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = AgreementTermOrCondition.class
)
public class AgreementTermOrCondition extends Entity {

  /**
   * Text that explains the term or condition of the agreement.
   */
  private @SafeText String description;

  /**
   * The period of time during which the term or condition of the agreement
   * applies.
   */
  private @Valid TimePeriod validFor;
}