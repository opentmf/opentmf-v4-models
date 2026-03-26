package org.opentmf.tmf730.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A base class used to define the invariant characteristics and behavior
 * (attributes, constraints, and relationships) of an API.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = APISpecification.class
)
public class APISpecification extends SoftwareResourceSpecification implements IAPISpecification {

  /**
   * API protocol type like REST, SOAP and so on.
   */
  private @SafeText String apiProtocolType;

  /**
   * The authentication scheme used for this API.
   */
  private @SafeText String authenticationType;

  /**
   * The external API schema of the (external) URL offered to the client of this
   * API.
   */
  private URI externalSchema;

  /**
   * The URL of an API offered to the user. This is seen as external url for an
   * API brokerage.
   */
  private URI externalUrl;

  /**
   * The internal API schema of the (internal) URL which an API broker uses.
   */
  private URI internalSchema;

  /**
   * The URL of an API offered to an API brokerage.
   */
  private URI internalUrl;
}