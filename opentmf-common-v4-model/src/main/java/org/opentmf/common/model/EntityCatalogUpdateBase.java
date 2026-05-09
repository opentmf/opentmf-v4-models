package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 9 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AssociationSpecificationUpdate (662)</li>
 *   <li>EntityCatalogItemUpdate (662)</li>
 *   <li>EntityCatalogUpdate (662)</li>
 *   <li>EntityCategoryUpdate (662)</li>
 *   <li>IotDeviceSpecificationUpdate (908)</li>
 *   <li>ServiceCandidateUpdate (633)</li>
 *   <li>ServiceCatalogUpdate (633)</li>
 *   <li>ServiceCategoryUpdate (633)</li>
 *   <li>ShipmentSpecificationUpdate (711)</li>
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
    defaultImpl = EntityCatalogUpdateBase.class
)
public abstract class EntityCatalogUpdateBase extends Extensible implements IEntityCatalogUpdateBase {

  /**
   * Description of the specification.
   */
  private @SafeText String description;

  /**
   * Indicates the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this association specification.
   */
  private @SafeText String name;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Version of this association.
   */
  private @SafeText String version;
}