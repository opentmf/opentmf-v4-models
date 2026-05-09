package org.opentmf.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.LoyaltyProgramMemberRef;
import org.opentmf.common.model.LoyaltyProgramProductRef;
import org.opentmf.common.model.Money;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.UsageSpecificationRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.product.model.RatedProductUsage;
import org.opentmf.product.model.UsageCharacteristic;

/**
 * A specialised event to process direct loyalty points earnings.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> description, loyaltyProgramMember, loyaltyProgramProduct, quantity<br/>
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = LoyaltyEarnCreate.class
)
@Required(fields = {"quantity", "loyaltyProgramProduct", "loyaltyProgramMember", "description"})
public class LoyaltyEarnCreate extends Extensible implements ILoyaltyEarnCreate {

  /**
   * A description detailing the earn event.
   */
  private @SafeText String description;

  private @Valid LoyaltyProgramMemberRef loyaltyProgramMember;

  private @Valid LoyaltyProgramProductRef loyaltyProgramProduct;

  /**
   * A base / value business entity used to represent money.
   */
  private @Valid Money quantity;

  /**
   * List of: An occurrence of employing a product for its intended purpose with
   * all rating details.
   */
  @JsonProperty("ratedProductUsage")
  private List<@Valid RatedProductUsage> ratedProductUsages;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Possible values for the status of the Usage
   * <br/><p>Recommended values: received, rejected, recycled, guided, rated,
   * rerated, billed.
   *
   * @see org.opentmf.product.model.UsageStatusType
   */
  private @SafeText String status;

  /**
   * List of: Provides the value of a given characteristic.
   */
  @JsonProperty("usageCharacteristic")
  private List<@Valid UsageCharacteristic> usageCharacteristics;

  /**
   * Date of usage.
   */
  private OffsetDateTime usageDate;

  /**
   * UsageSpecification reference. UsageSpecification is a detailed description of
   * a usage event that are of interest to the business and can have charges
   * applied to it. It is comprised of characteristics, which define all
   * attributes known for a particular type of usage.
   */
  private @Valid UsageSpecificationRef usageSpecification;

  /**
   * Type of usage.
   */
  private @SafeText String usageType;
}