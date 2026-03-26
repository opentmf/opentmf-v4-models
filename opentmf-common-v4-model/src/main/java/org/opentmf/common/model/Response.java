package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A response to a request.
 *
 * <p><br/>
 * <strong>Required:</strong> body, header<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-640: Service Activation Management API</li>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-702: Resource Activation Management API</li>
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
    defaultImpl = Response.class
)
@Required(fields = {"header", "body"})
public class Response extends Extensible implements IResponse {

  /**
   * The body of the response. For example for an HTTP response might contain HTML
   * for rendering.
   */
  private @SafeText String body;

  /**
   * Items included in the header of the response. For example for an HTTP
   * response might contain negotiated locale.
   */
  @JsonProperty("header")
  private @Size(min = 1) List<@Valid HeaderItem> headers;

  /**
   * The status of the response. For example for an HTTP response would be codes
   * such as 200, 400, etc.
   */
  private @SafeText String statusCode;
}