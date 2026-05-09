package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.Rule;
import org.opentmf.common.model.TemplateRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Part of a business agreement between a Service Provider and a Customer,
 * quantitatively specifying the service performance level the Service Provider
 * commits to deliver.
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
    defaultImpl = SLA.class
)
public class SLA extends NamedEntity implements ISLA {

  private OffsetDateTime approvalDate;

  private Boolean approved;

  /**
   * Description of the Service Level Agreement (SLA).
   */
  private @SafeText String description;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  @JsonProperty("rule")
  private List<@Valid Rule> rules;

  /**
   * State of the Service Level Agreement (SLA).
   */
  private @SafeText String state;

  private @Valid TemplateRef template;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Version of the Service Level Agreement (SLA).
   */
  private @SafeText String version;
}