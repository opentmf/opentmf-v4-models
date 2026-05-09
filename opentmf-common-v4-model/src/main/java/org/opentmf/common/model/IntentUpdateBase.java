package org.opentmf.common.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 5 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CatalogUpdate (620)</li>
 *   <li>CategoryUpdate (620)</li>
 *   <li>IntentUpdate (921)</li>
 *   <li>ProcessFlowSpecificationUpdate (701)</li>
 *   <li>TaskFlowSpecificationUpdate (701)</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public abstract class IntentUpdateBase implements IIntentUpdateBase {

  /**
   * Description of this catalog.
   */
  private @SafeText String description;

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the catalog.
   */
  private @SafeText String name;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Catalog version.
   */
  private @SafeText String version;
}