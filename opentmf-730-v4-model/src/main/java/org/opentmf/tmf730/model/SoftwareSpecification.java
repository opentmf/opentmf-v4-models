package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.SoftwareSupportPackageRef;

/**
 * A base class used to define the invariant characteristics and behavior
 * (attributes, constraints, and relationships) of an InstalledSoftware.
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
    defaultImpl = SoftwareSpecification.class
)
public class SoftwareSpecification extends SoftwareResourceSpecification implements ISoftwareSpecification {

  /**
   * Defines the maximum number of users for a SoftwareSpecifciation.
   */
  private Integer numUsersMax;

  /**
   * Defines the maximum number of total processes that a SoftwareSpecifciation
   * can support at any given time.
   */
  private Integer numberProcessActiveTotal;

  /**
   * Reference to a SoftwareSupportPackage.
   */
  private @Valid SoftwareSupportPackageRef softwareSupportPackage;
}