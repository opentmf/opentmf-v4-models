package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An incident resolution is an action taken to resolve/repair the root cause of
 * an incident or problem, or to implement a workaround
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> incident<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-724: Incident Management API</li>
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
    defaultImpl = ResolveIncidentCreate.class
)
@Required(fields = {"incident"})
public class ResolveIncidentCreate extends DiagnoseIncidentCreate implements IResolveIncidentCreate {

  /**
   * The clear time of the incident, for example 2020-03-10T04:01:12Z.
   */
  private @SafeText String clearTime;
}