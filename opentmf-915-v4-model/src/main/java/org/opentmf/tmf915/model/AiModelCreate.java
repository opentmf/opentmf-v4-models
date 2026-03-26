package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * AiModel is a base class for defining the AiModel hierarchy
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> aiModelSpecification, software, state<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = AiModelCreate.class
)
@Required(fields = {"aiModelSpecification", "software", "state"})
public class AiModelCreate extends AiModelUpdate implements IAiModelCreate {

  /**
   * Date when the service was created (whatever its status).
   */
  private OffsetDateTime serviceDate;
}