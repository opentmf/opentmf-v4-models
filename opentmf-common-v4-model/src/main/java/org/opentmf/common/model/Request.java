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
    defaultImpl = Request.class
)
@Required(fields = {"header", "body"})
public class Request extends Extensible implements IRequest {

  /**
   * The body of the request. For example for an HTTP request might contain
   * content of a form .
   */
  private @SafeText String body;

  /**
   * Items included in the header of the request. For example for an HTTP request
   * might contain requested locale, basic authentication.
   */
  @JsonProperty("header")
  private @Size(min = 1) List<@Valid HeaderItem> headers;

  /**
   * The protocol of the request, e.g. http.
   */
  private @SafeText String method;

  /**
   * The target of the request, e.g. a URL for an HTTP request.
   */
  private @SafeText String to;
}