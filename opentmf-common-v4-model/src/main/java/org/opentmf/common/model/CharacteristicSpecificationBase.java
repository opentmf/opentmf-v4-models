package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This class defines a characteristic specification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-635: Usage Management API</li>
 *   <li>TMF-653: Service Test Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-686: Topology API</li>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-701: Process Flow Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 *   <li>TMF-713: Work Management</li>
 *   <li>TMF-715: Warranty Management</li>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = CharacteristicSpecificationBase.class
)
public class CharacteristicSpecificationBase extends RuleUpdate implements ICharacteristicSpecificationBase {

  /**
   * This (optional) field provides a link to the schema describing the value
   * type.
   */
  @JsonProperty("@valueSchemaLocation")
  private URI atValueSchemaLocation;

  /**
   * If true, the Boolean indicates that the target Characteristic is
   * configurable.
   */
  private Boolean configurable;

  /**
   * A narrative that explains the CharacteristicSpecification.
   */
  private @SafeText String description;

  /**
   * An indicator that specifies that the values for the characteristic can be
   * extended by adding new values when instantiating a characteristic for a
   * resource.
   */
  private Boolean extensible;

  /**
   * Unique ID for the characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * An indicator that specifies if a value is unique for the specification.
   * Possible values are; "unique while value is in effect" and "unique whether
   * value is in effect or not".
   */
  private Boolean isUnique;

  /**
   * The maximum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where five is
   * the value for the maxCardinality.
   */
  private Integer maxCardinality;

  /**
   * The minimum number of instances a CharacteristicValue can take on. For
   * example, zero to five phone numbers in a group calling plan, where zero is
   * the value for the minCardinality.
   */
  private Integer minCardinality;

  /**
   * A rule or principle represented in regular expression used to derive the
   * value of a characteristic value.
   */
  private @SafeText String regex;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * A kind of value that the characteristic can take on, such as numeric, text
   * and so forth.
   */
  private @SafeText String valueType;
}