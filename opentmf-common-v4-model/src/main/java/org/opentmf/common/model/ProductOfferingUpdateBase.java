package org.opentmf.common.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>DocumentSpecificationUpdate (667)</li>
 *   <li>ProductOfferingPriceUpdate (620)</li>
 *   <li>ProductOfferingUpdate (620)</li>
 *   <li>ProductSpecificationUpdate (620)</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public abstract class ProductOfferingUpdateBase implements IProductOfferingUpdateBase {

  /**
   * Description of the specification.
   */
  private @SafeText String description;

  /**
   * isBundle determines whether specification represents a single specification
   * (false), or a bundle of specifications (true).
   */
  private Boolean isBundle;

  /**
   * Possible values for the status of a DocumentSpecification
   * <br/><p>Recommended values: created, reviewed, approved, published, archived,
   * deleted.
   *
   * @see org.opentmf.tmf667.model.DocumentSpecificationStatusType
   */
  private @SafeText String lifecycleStatus;

  /**
   * The name of the DocumentSpecification.
   */
  private @SafeText String name;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * The version of the DocumentSpecification.
   */
  private @SafeText String version;
}