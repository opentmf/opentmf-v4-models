package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 10 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AssociationCreate (662, 703)</li>
 *   <li>AssociationUpdate (662, 703)</li>
 *   <li>EdgeSpecificationCreate (686)</li>
 *   <li>EdgeSpecificationUpdate (686)</li>
 *   <li>ResourceCandidateCreate (634)</li>
 *   <li>ResourceCandidateUpdate (634)</li>
 *   <li>ResourceCatalogCreate (634)</li>
 *   <li>ResourceCatalogUpdate (634)</li>
 *   <li>VertexSpecificationCreate (686)</li>
 *   <li>VertexSpecificationUpdate (686)</li>
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
    defaultImpl = AssociationCreateBase.class
)
public abstract class AssociationCreateBase extends Extensible implements IAssociationCreateBase {

  /**
   * Description of the association.
   */
  private @SafeText String description;

  /**
   * The last modified date of this association object.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Indicates the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this association.
   */
  private @SafeText String name;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Version of this REST resource.
   */
  private @SafeText String version;
}