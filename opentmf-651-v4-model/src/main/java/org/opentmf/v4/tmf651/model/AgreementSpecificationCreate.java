package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import org.opentmf.v4.common.model.CategoryRef;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * A template of an agreement that can be used when establishing partnerships
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> attachment, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = AgreementSpecificationCreate.class
)
@Required(fields = {"attachment", "name"})
public class AgreementSpecificationCreate extends Extensible {

  /**
   * A narrative that explains in detail what the agreement specification is
   * about.
   */
  private @SafeText String description;

  /**
   * If true, this agreement specification is a grouping of other agreement
   * specifications. The list of bundled agreement specifications is provided by
   * the specificationRelationship property.
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Indicates the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the agreement specification.
   */
  private @SafeText String name;

  /**
   * Agreement specification version.
   */
  private @SafeText String version;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private @Size(min = 1) List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  private @Valid CategoryRef serviceCategory;

  /**
   * List of: A characteristic quality or distinctive feature of an agreement.
   */
  @JsonProperty("specificationCharacteristic")
  private List<@Valid AgreementSpecCharacteristic> specificationCharacteristics;

  /**
   * List of: A relationship between agreement specifications. Typical
   * relationships are substitution and dependency.
   */
  @JsonProperty("specificationRelationship")
  private List<@Valid AgreementSpecificationRelationship> specificationRelationships;

  /**
   * The period for which the agreement specification is valid.
   */
  private @Valid TimePeriod validFor;
}