package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Configuration feature.
 *
 * <p><br/>
 * <strong>Required:</strong> featureCharacteristic, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@Required(fields = {"featureCharacteristic", "name"})
public class Feature {

  /**
   * Unique identifier of the feature.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * True if this is a feature group. Default is false.
   */
  private Boolean isBundle;

  /**
   * True if this feature is enabled. Default is true.
   */
  private Boolean isEnabled;

  /**
   * This is the name for the feature.
   */
  private @SafeText String name;

  /**
   * This is a list of feature constraints.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * This is a list of Characteristics for a particular feature.
   */
  @JsonProperty("featureCharacteristic")
  private @Size(min = 1) List<@Valid Characteristic> featureCharacteristics;

  /**
   * List of: Configuration feature.
   */
  @JsonProperty("featureRelationship")
  private List<@Valid FeatureRelationship> featureRelationships;
}