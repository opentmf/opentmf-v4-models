package org.opentmf.v4.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * Lack or inadequate strength or ability.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Disability.class
)
public class Disability extends Extensible {

  /**
   * Code of the disability.
   */
  private @SafeText String disabilityCode;

  /**
   * Name of the disability.
   */
  private @SafeText String disabilityName;

  private @Valid TimePeriod validFor;
}