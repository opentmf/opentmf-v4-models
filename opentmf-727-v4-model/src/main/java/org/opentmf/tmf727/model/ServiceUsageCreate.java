package org.opentmf.tmf727.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * An occurrence of usage on a Service derived from various Resource usages,
 * which can be used for determining the Product usage. It is comprised of
 * characteristics, which represent attributes of service usage.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> status<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-727: Service Usage Management API</li>
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
    defaultImpl = ServiceUsageCreate.class
)
@Required(fields = {"status"})
public class ServiceUsageCreate extends ServiceUsageUpdate implements IServiceUsageCreate {

  /**
   * Date of usage.
   */
  private OffsetDateTime usageDate;
}