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
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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