package org.opentmf.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.UsageSpecificationRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An occurrence of employing a Product, Service, or Resource for its intended
 * purpose, which is of interest to the business and can have charges applied to
 * it. It is comprised of characteristics, which represent attributes of usage.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-635: Usage Management API</li>
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
    defaultImpl = UsageUpdate.class
)
public class UsageUpdate extends Extensible implements IUsageUpdate {

  /**
   * Description of usage.
   */
  private @SafeText String description;

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