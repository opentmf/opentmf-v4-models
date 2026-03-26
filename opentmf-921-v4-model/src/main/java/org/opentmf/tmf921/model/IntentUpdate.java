package org.opentmf.tmf921.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IntentUpdateBase;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An Intent instance is the formal description of all expectations including
 * requirements, goals, and constraints given to a technical system
 * <br/>Skipped properties: id,href,{@literal @}type.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-921: Intent Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class IntentUpdate extends IntentUpdateBase implements IIntentUpdate {

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
   * Date and time of the creation of this Intent.
   */
  private OffsetDateTime creationDate;

  /**
   * Expression is the ontology-encoded form of the Intent.
   */
  private @Valid Expression expression;

  /**
   * Date and time of the last update of this Intent.
   */
  private OffsetDateTime lastUpdate;

  /**
   * A date time( DateTime). The date that the entity status changed to the
   * current one.
   */
  private OffsetDateTime statusChangeDate;
}