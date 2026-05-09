package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeUrl;

/**
 * A Hub is used to subscribe to an event notification.
 *
 * <p><br/>
 * <strong>Required:</strong> callback, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-688: Event Management API</li>
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
    defaultImpl = Hub.class
)
@Required(fields = {"callback", "id"})
public class Hub extends Entity implements IHub {

  /**
   * The URI that will be POSTed to when a notification is triggered.
   */
  private URI callback;

  /**
   * This is a query string used to filter notifications in the context of the
   * notifier.
   */
  @SafeUrl
  @Size(max = 500)
  private String query;
}