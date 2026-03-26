package org.opentmf.tmf667.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.CharacteristicSpecification;
import org.opentmf.common.model.ConstraintRef;
import org.opentmf.common.model.EntitySpecificationRelationship;
import org.opentmf.common.model.ProductOfferingUpdateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TargetEntitySchema;

/**
 * A DocumentSpecification provides the characteristics and constraints that
 * describe a particular type of Document. It follows the EntitySpecification
 * pattern, so allows you to define the characteristics expected, as well as the
 * nature of the values of those characteristics (eg: integer range
 * [valueFrom/valueTo], regular expression or unitOfMeasure).
 * <br/>Skipped properties: id,href,{@literal @}type,{@literal @}baseType,{@literal @}schemaLocation.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DocumentSpecificationUpdate extends ProductOfferingUpdateBase implements IDocumentSpecificationUpdate {

  /**
   * Attachments that may be of relevance to this specification, such as picture,
   * document, media.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * This is a list of constraint references applied to this specification.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Relationship to another specification.
   */
  @JsonProperty("entitySpecRelationship")
  private List<@Valid EntitySpecificationRelationship> entitySpecRelationships;

  /**
   * Date and time of the last update of the specification.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of characteristics that the entity can take.
   */
  @JsonProperty("specCharacteristic")
  private List<@Valid CharacteristicSpecification> specCharacteristics;

  /**
   * The reference object to the schema and type of target entity which is
   * described by a specification.
   */
  private @Valid TargetEntitySchema targetEntitySchema;
}