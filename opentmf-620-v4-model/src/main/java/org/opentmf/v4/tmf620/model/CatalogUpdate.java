package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.CategoryRef;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;

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
 * @author Gokhan Demir
 */
@Getter
@Setter
public class CatalogUpdate {

  /**
   * Indicates if the catalog is a product, service or resource catalog.
   */
  private @SafeText String catalogType;

  /**
   * Description of this catalog.
   */
  private @SafeText String description;

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the catalog.
   */
  private @SafeText String name;

  /**
   * Catalog version.
   */
  private @SafeText String version;

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

  /**
   * The period for which the catalog is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;
}