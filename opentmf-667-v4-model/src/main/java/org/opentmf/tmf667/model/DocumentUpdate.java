package org.opentmf.tmf667.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.DocumentRef;
import org.opentmf.common.model.DocumentUpdateBase;
import org.opentmf.common.model.ExternalIdentifier;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Document describes the meta-data of a Document - such as the name,
 * creationDate and lifecycle status.
 * <br/>The (typically binary) body of this document (such as a Word.doc, PDF,
 * Video clip, or Image) will be held in the associated Attachment(s) either by
 * Ref or Value. If by value - the binary content is held in the
 * Attachment.content. If by reference, the Attachment.url might point to a
 * (file:) or remote (http:) pointer to the Document media.
 * <br/>
 * <br/>A Document may be associated with a DocumentSpecification, which will
 * detail the characteristics of that type of Document (an Image may have a
 * width, height and format; a Video may have a length and format).
 * <br/>A Document has a collection of RelatedParty's, for roles such as author,
 * reviewer, publisher; and a lifecycle status to take the document through a
 * simple set of production stages.
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
public class DocumentUpdate extends DocumentUpdateBase implements IDocumentUpdate {

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: The category for grouping recommendations.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * The date and time the document was created. A date and time formatted in
   * compliance with the ISO8601 standard must be used.
   */
  private OffsetDateTime creationDate;

  @JsonProperty("document")
  private List<@Valid DocumentRef> documents;

  /**
   * A DocumentSpecificationRefOrValue where you can select between a
   * DocumentSpecification (by Value) or a DocumentSpecificationRef (by
   * Reference).
   */
  private @Valid DocumentSpecificationRefOrValue documentSpecification;

  /**
   * Name of the document type.
   */
  private @SafeText String documentType;

  /**
   * List of: An identification of an entity that is owned by or originates in a
   * software system different from the current system, for example a ProductOrder
   * handed off from a commerce platform into an order handling system. The
   * structure identifies the system itself, the nature of the entity within the
   * system (e.g. class name) and the unique ID of the entity within the system.
   * It is anticipated that multiple external IDs can be held for a single entity,
   * e.g. if the entity passed through multiple systems on the way to the current
   * system. In this case the consumer is expected to sequence the IDs in the
   * array in reverse order of provenance, i.e. most recent system first in the
   * list.
   */
  @JsonProperty("externalIdentifier")
  private List<@Valid ExternalIdentifier> externalIdentifiers;

  /**
   * List of: A reference to an entity, where the type of the entity is not known
   * in advance.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Possible values for the status of a Document
   * <br/><p>Recommended values: created, reviewed, approved, published, archived,
   * deleted.
   *
   * @see org.opentmf.tmf667.model.DocumentStatusType
   */
  private @SafeText String status;
}