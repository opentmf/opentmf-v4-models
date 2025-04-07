package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A template of an agreement that can be used when establishing partnerships.
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
    defaultImpl = AgreementSpecification.class
)
@Required(fields = {"attachment", "name"})
public class AgreementSpecification extends AgreementSpecificationCreate {

  /**
   * Unique identifier of the agreement specification.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Reference of the agreement specification.
   */
  private URI href;
}