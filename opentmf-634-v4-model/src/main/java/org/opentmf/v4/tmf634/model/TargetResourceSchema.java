package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The reference object to the schema and type of target resource which is
 * described by resource specification.
 *
 * <p><br/>
 * <strong>Required:</strong> @schemaLocation, @type<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@Required(fields = {"atType", "atSchemaLocation"})
public class TargetResourceSchema {

  /**
   * This field provides a link to the schema describing the target resource.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * Class type of the target resource.
   */
  @JsonProperty("@type")
  private @SafeText String atType;
}