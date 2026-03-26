package org.opentmf.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.IntentUpdateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A collection of Product Offerings, intended for a specific
 * DistributionChannel, enhanced with additional information such as SLA
 * parameters, invoicing and shipping details
 * <br/>Skipped properties: id,href,lastUpdate,{@literal @}type,{@literal @}baseType.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CatalogUpdate extends IntentUpdateBase implements ICatalogUpdate {

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * Indicates if the catalog is a product, service or resource catalog.
   */
  private @SafeText String catalogType;

  /**
   * List of root categories contained in this catalog.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * List of parties involved in this catalog.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}