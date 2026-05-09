package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 5 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AgreementSpecificationCreate (651)</li>
 *   <li>AgreementSpecificationUpdate (651)</li>
 *   <li>LoyaltyProgramProductSpecUpdate (658)</li>
 *   <li>ResourceSpecificationCreate (634, 730, 908)</li>
 *   <li>ResourceSpecificationUpdate (634, 730, 908)</li>
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
    defaultImpl = ResourceSpecificationCreateBase.class
)
public abstract class ResourceSpecificationCreateBase extends Extensible implements IResourceSpecificationCreateBase {

  /**
   * A narrative that explains in detail what the agreement specification is
   * about.
   */
  private @SafeText String description;

  /**
   * If true, this agreement specification is a grouping of other agreement
   * specifications. The list of bundled agreement specifications is provided by
   * the specificationRelationship property.
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Indicates the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the agreement specification.
   */
  private @SafeText String name;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Agreement specification version.
   */
  private @SafeText String version;
}