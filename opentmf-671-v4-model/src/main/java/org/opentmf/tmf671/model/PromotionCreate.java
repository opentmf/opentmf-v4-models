package org.opentmf.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Promotion is used to provide the additional discount, voucher, bonus or gift
 * to the customer who meets the pre-defined criteria. Using promotion, the
 * enterprise is able to attract the users and encourage more consumption,
 * especially continuous purchases. Normally Promotion is not regarded as one
 * type of product or product offering. It is often applied when the customer
 * buys the product offerings with the price or amount surpassing the certain
 * limit.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"name"})
public class PromotionCreate extends PromotionUpdate implements IPromotionCreate {

  /**
   * The base type for use in polymorphic collections.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A link to the schema describing a resource (for type extension).
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * The class type of the actual resource (for type extension).
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  /**
   * List of: Contains the conditions and benefits of the promotion toan eligible
   * party.
   */
  @JsonProperty("pattern")
  private List<@Valid PromotionPattern> patterns;
}