package org.opentmf.common.model;

import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>DocumentUpdate (667)</li>
 *   <li>PartyPrivacyProfileSpecificationCreate (644)</li>
 *   <li>PartyPrivacyProfileSpecificationUpdate (644)</li>
 *   <li>ServiceTestSpecificationUpdate (653)</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public abstract class DocumentUpdateBase implements IDocumentUpdateBase {

  /**
   * free-text description of the document.
   */
  private @SafeText String description;

  /**
   * The date and time the document was last modified. A date and time formatted
   * in compliance with the ISO8601 standard must be used.
   */
  private OffsetDateTime lastUpdate;

  /**
   * A string used to give a name to the document.
   */
  private @SafeText String name;

  /**
   * A particular form or variety of an artefact that is different from others or
   * from the original. The form represents differences in properties that
   * characterize an artefact, that are not enough to warrant creating a new
   * artefact.
   */
  private @SafeText String version;
}