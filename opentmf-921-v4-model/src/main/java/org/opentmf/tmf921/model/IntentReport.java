package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * IntentReport is the mechanism to report back to Intent owner on an Intents
 * status.
 *
 * <p><br/>
 * <strong>Required:</strong> intent<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-921: Intent Management API</li>
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
    defaultImpl = IntentReport.class
)
@Required(fields = {"intent"})
public class IntentReport extends NamedEntity implements IIntentReport {

  /**
   * Date and time of the creation of this intent report.
   */
  private OffsetDateTime creationDate;

  /**
   * The description of the intent report.
   */
  private @SafeText String description;

  /**
   * Expression is the ontology-encoded form of the Intent.
   */
  private @Valid Expression expression;

  /**
   * Intent Ref (if Intent already exists) or Value (if Intent be created or its
   * details be presented).
   */
  private @Valid IntentRefOrValue intent;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}