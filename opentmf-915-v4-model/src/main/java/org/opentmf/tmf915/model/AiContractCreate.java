package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.Rule;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An Ai Contract represents a contract or arrangement, either written or verbal
 * and sometimes enforceable by law, such as a service level agreement or a
 * customer price agreement. An agreement involves a number of other business
 * entities, such as products, services, and resources and/or their
 * specifications.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> aiContractSpecification, aiModel, relatedParty, state<br/>
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
    defaultImpl = AiContractCreate.class
)
@Required(fields = {"aiModel", "state", "relatedParty", "aiContractSpecification"})
public class AiContractCreate extends RuleUpdate implements IAiContractCreate {

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef aiContractSpecification;

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef aiModel;

  private OffsetDateTime approvalDate;

  private Boolean approved;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * Description of the Service Level Agreement (SLA).
   */
  private @SafeText String description;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private @Size(min = 1) List<@Valid RelatedParty> relatedParties;

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