package org.opentmf.tmf713.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Definition of the nature of a Work Unit. For example, could be wiring,
 * equipment installation, etc.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-713: Work Management</li>
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
    defaultImpl = WorkSpecificationCreate.class
)
@Required(fields = {"name"})
public class WorkSpecificationCreate extends WorkSpecificationUpdate implements IWorkSpecificationCreate {

  /**
   * Date and time of the last update of the specification.
   */
  private OffsetDateTime lastUpdate;
}