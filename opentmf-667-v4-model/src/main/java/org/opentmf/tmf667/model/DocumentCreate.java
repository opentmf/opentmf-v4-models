package org.opentmf.tmf667.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
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
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
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
@Required(fields = {"name"})
public class DocumentCreate extends DocumentUpdate implements IDocumentCreate {

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
}