package org.opentmf.tmf915.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A template of an agreement that can be used when establishing partnerships
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = AiContractSpecificationCreate.class
)
@Required(fields = {"name"})
public class AiContractSpecificationCreate extends AiContractSpecificationUpdate implements IAiContractSpecificationCreate {

  /**
   * Date and time of the last update of the specification.
   */
  private OffsetDateTime lastUpdate;
}