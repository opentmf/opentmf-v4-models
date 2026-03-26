package org.opentmf.tmf725.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Additional information to describe the catalog
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> description, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"name", "description"})
public class MetadataCatalogCreate extends MetadataCatalogUpdate implements IMetadataCatalogCreate {

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
   * The date and time the metadata asset was last updated.
   */
  private @SafeText String lastUpdateDate;
}