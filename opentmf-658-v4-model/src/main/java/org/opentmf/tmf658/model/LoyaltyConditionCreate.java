package org.opentmf.tmf658.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A condition, comprised of a attribute that will be tested against a value.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> attribute, operator, value<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"attribute", "value", "operator"})
public class LoyaltyConditionCreate implements ILoyaltyConditionCreate {

  /**
   * The attribute to evaluate.
   */
  private @SafeText String attribute;

  /**
   * Comparison operator to be used in the evaluation.
   */
  private @SafeText String operator;

  /**
   * The value of the attribute to be evaluated.
   */
  private @SafeText String value;
}