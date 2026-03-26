package org.opentmf.tmf653.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.CharacteristicSpecification;
import org.opentmf.common.model.ConstraintRef;
import org.opentmf.common.model.DocumentUpdateBase;
import org.opentmf.common.model.EntitySpecificationRelationship;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ServiceSpecificationRef;
import org.opentmf.common.model.TargetEntitySchema;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The service test specification describes the service test in terms of
 * parameters to be configured and 
 * <br/>measures to be taken.
 * <br/>Skipped properties: id,href,validFor,{@literal @}type,{@literal @}schemaLocation,{@literal @}baseType.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-653: Service Test Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceTestSpecificationUpdate extends DocumentUpdateBase implements IServiceTestSpecificationUpdate {

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
   * isBundle determines whether specification represents a single specification
   * (false), or a bundle of specifications (true).
   */
  private Boolean isBundle;

  /**
   * Used to indicate the current lifecycle status of this catalog item.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Parties who manage or otherwise have an interest in this specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * The related service specification may relate to more than one service
   * specification.
   */
  @JsonProperty("relatedServiceSpecification")
  private List<@Valid ServiceSpecificationRef> relatedServiceSpecifications;

  /**
   * A list of service test specifications related to this specification e.g.
   * dependency, substitution.
   */
  @JsonProperty("serviceTestSpecRelationship")
  private List<@Valid ServiceTestSpecRelationship> serviceTestSpecRelationships;

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

  /**
   * A list of definitions for the measurements for the test defined by this
   * specification.
   */
  @JsonProperty("testMeasureDefinition")
  private List<@Valid TestMeasureDefinition> testMeasureDefinitions;
}