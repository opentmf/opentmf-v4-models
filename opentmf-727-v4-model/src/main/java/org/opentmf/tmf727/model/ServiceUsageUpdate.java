package org.opentmf.tmf727.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ServiceRef;
import org.opentmf.common.model.ServiceUsageSpecificationRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An occurrence of usage on a Service derived from various Resource usages,
 * which can be used for determining the Product usage. It is comprised of
 * characteristics, which represent attributes of service usage.
 * <br/>Skipped properties: id,href,usageDate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-727: Service Usage Management API</li>
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
    defaultImpl = ServiceUsageUpdate.class
)
public class ServiceUsageUpdate extends Extensible implements IServiceUsageUpdate {

  /**
   * Description of service usage.
   */
  private @SafeText String description;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Service reference, for when Service is used by other entities.
   */
  private @Valid ServiceRef service;

  /**
   * Possible values for the status of the Usage
   * <br/><p>Recommended values: generated, archived.
   *
   * @see org.opentmf.tmf727.model.ServiceUsageStatusType
   */
  private @SafeText String status;

  /**
   * List of: Provides the value of a given characteristic.
   */
  @JsonProperty("usageCharacteristic")
  private List<@Valid ServiceUsageCharacteristic> usageCharacteristics;

  /**
   * UsageSpecification reference. UsageSpecification is a detailed description of
   * a service usage event that are of interest to the business. It is comprised
   * of characteristics, which define all attributes known for a particular type
   * of usage.
   */
  private @Valid ServiceUsageSpecificationRef usageSpecification;

  /**
   * Type of usage.
   */
  private @SafeText String usageType;
}