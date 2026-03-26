package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents a task used to import resources from a file
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> url<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-662: Entity Catalog Management API</li>
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
    defaultImpl = ImportJobCreate.class
)
@Required(fields = {"url"})
public class ImportJobCreate extends Extensible implements IImportJobCreate {

  /**
   * Date at which the job was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Indicates the format of the imported data.
   */
  private @SafeText String contentType;

  /**
   * Date at which the job was created.
   */
  private OffsetDateTime creationDate;

  /**
   * Reason for failure if status is failed.
   */
  private @SafeText String errorLog;

  /**
   * URL of the root resource where the content of the file specified by the
   * import job must be applied.
   */
  private @SafeText String path;

  /**
   * Valid values for the state of a batch job (e.g. catalog import)
   * <br/><p>Recommended values: Not Started, Running, Succeeded, Failed.
   *
   * @see org.opentmf.common.model.JobStateType
   */
  private @SafeText String status;

  /**
   * URL of the file containing the data to be imported.
   */
  private URI url;
}