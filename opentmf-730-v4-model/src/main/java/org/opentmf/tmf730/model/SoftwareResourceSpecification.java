package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Quantity;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.resource.model.ResourceSpecification;

/**
 * An abstract base class used to define the invariant characteristics and
 * behavior (attributes, constraints, and relationships) of a SoftwareResource.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = SoftwareResourceSpecification.class
)
public class SoftwareResourceSpecification extends ResourceSpecification implements ISoftwareResourceSpecification {

  /**
   * Defines the internal identifier for the compilation of this unit of a
   * SoftwareResourceSpecification.
   */
  private @SafeText String buildNumber;

  /**
   * An amount in a given unit.
   */
  private @Valid Quantity installSize;

  /**
   * Designates the SoftwareResource as being able to be distributed across
   * multiple physically distinct Resources.
   */
  private Boolean isDistributable;

  /**
   * True represents a special build (perhaps as a trial to suit specific customer
   * needs).
   */
  private Boolean isExperimental;

  /**
   * Defines the maintenance number component of the version of
   * SoftwareResourceSpecification.
   */
  private @SafeText String maintenanceVersion;

  /**
   * Defines the major number component of the version of
   * SoftwareResourceSpecification.
   */
  private @SafeText String majorVersion;

  /**
   * Defines the minor number component of the version of
   * SoftwareResourceSpecification.
   */
  private @SafeText String minorVersion;

  /**
   * Enables the manufacturer to label this software as having some set of special
   * restrictions.
   */
  private @SafeText String otherDesignator;

  /**
   * Defines the particualr release status of this SoftwareResourceSpecification.
   */
  private @SafeText String releaseStatus;
}