package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This indicates an error that caused a qualificationItem to be terminated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
 *   <li>TMF-714: Work Qualification Management</li>
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
    defaultImpl = TerminationError.class
)
public class TerminationError extends Extensible implements ITerminationError {

  /**
   * Unique identifier of the termination error.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Text to describe the termination error - for example: Unable to proceed to
   * qualification because incomplete information provided.
   */
  private @SafeText String value;
}