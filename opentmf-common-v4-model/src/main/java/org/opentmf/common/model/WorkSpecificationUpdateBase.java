package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 6 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AiContractSpecificationUpdate (915)</li>
 *   <li>EntitySpecificationUpdate (662)</li>
 *   <li>ServiceSpecificationUpdate (633)</li>
 *   <li>UsageSpecificationCreate (635)</li>
 *   <li>UsageSpecificationUpdate (635)</li>
 *   <li>WarrantySpecificationUpdate (715)</li>
 *   <li>WorkSpecificationUpdate (713)</li>
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
    defaultImpl = WorkSpecificationUpdateBase.class
)
public abstract class WorkSpecificationUpdateBase extends Extensible implements IWorkSpecificationUpdateBase {

  /**
   * This is a list of constraint references applied to this specification.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Description of the specification.
   */
  private @SafeText String description;

  /**
   * Relationship to another specification.
   */
  @JsonProperty("entitySpecRelationship")
  private List<@Valid EntitySpecificationRelationship> entitySpecRelationships;

  /**
   * isBundle determines whether specification represents a single specification
   * (false), or a bundle of specifications (true).
   */
  private Boolean isBundle;

  /**
   * Used to indicate the current lifecycle status of this catalog item.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to the specification.
   */
  private @SafeText String name;

  /**
   * List of characteristics that the entity can take.
   */
  @JsonProperty("specCharacteristic")
  private List<@Valid CharacteristicSpecification> specCharacteristics;

  /**
   * The reference object to the schema and type of target entity which is
   * described by a specification.
   */
  private @Valid TargetEntitySchema targetEntitySchema;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * specification version.
   */
  private @SafeText String version;
}