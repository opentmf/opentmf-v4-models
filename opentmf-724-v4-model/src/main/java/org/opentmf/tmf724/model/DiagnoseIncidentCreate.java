package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A stage in the incident lifecycle. The purpose of diagnosis is to identify a
 * workaround for an incident (ITIL Service Operation). 
 * <br/>Diagnosing Incidents by Incident SN
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
    defaultImpl = DiagnoseIncidentCreate.class
)
@Required(fields = {"incident"})
public class DiagnoseIncidentCreate extends Extensible implements IDiagnoseIncidentCreate {

  /**
   * Reason for failure.
   */
  private @SafeText String errorLog;

  /**
   * Incident reference.
   */
  private @Valid IncidentRef incident;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}