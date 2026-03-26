package org.opentmf.tmf725.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Attachment;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Additional information to describe the catalog
 * <br/>Skipped properties:
 * id,href,lastUpdateDate,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type.
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
public class MetadataCatalogUpdate implements IMetadataCatalogUpdate {

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  private @Valid Attachment attachment;

  /**
   * A narrative text describing the content of the MetadataCatalog.
   */
  private @SafeText String description;

  /**
   * The categories used in this catalog.
   */
  @JsonProperty("metadataCategory")
  private List<@Valid MetadataCategoryRef> metadataCategories;

  /**
   * The name of the MetadataCatalog.
   */
  private @SafeText String name;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Catalog version.
   */
  private @SafeText String version;
}