package org.opentmf.tmf655.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Change Request is a type of request which can be used for the management and
 * control of Change Management process 
 * <br/> -within a service provider organisation or 
 * <br/> -between a customer and a service provider or 
 * <br/> -between a service provider and a partner and vice versa.
 *
 * <p><br/>
 * <strong>Required:</strong> targetEntity<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-655: Change Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"targetEntity"})
public class ChangeRequest extends ChangeRequestUpdate implements IChangeRequest {

  /**
   * When subclassing, this defines the super-class.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * When subclassing, this defines the subclass Extensible name.
   */
  @JsonProperty("@type")
  private @SafeText String atType;

  /**
   * Hyperlink to access a change request.
   */
  private URI href;

  /**
   * Identifier of a Change Request. It is created on repository side (a Change
   * Management system).
   */
  @SafeId
  @Size(max = 100)
  private String id;
}