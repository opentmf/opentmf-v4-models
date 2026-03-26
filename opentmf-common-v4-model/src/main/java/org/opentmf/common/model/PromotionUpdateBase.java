package org.opentmf.common.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public abstract class PromotionUpdateBase implements IPromotionUpdateBase {

  /**
   * Description of this metadata catalog item resource.
   */
  private @SafeText String description;

  /**
   * Used to indicate the current lifecycle status of this catalog item.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}