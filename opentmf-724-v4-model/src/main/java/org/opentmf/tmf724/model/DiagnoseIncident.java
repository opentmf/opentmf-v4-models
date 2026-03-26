package org.opentmf.tmf724.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A stage in the incident lifecycle. The purpose of diagnosis is to identify a
 * workaround for an incident (ITIL Service Operation). 
 * <br/>Diagnosing Incidents by Incident SN.
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
    defaultImpl = DiagnoseIncident.class
)
public class DiagnoseIncident extends DiagnoseIncidentCreate implements IDiagnoseIncident {

  /**
   * Reference of the diagnose incident task.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}