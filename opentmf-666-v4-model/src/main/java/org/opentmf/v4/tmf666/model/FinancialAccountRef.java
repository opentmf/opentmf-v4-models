package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.v4.common.model.EntityRef;

/**
 * AccountReceivable reference. An account of money owed by a party to another
 * entity in exchange for goods or services that have been delivered or used. An
 * account receivable aggregates the amounts of one or more party accounts
 * (billing or settlement) owned by a given party.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = FinancialAccountRef.class
)
@Required(fields = {"id"})
public class FinancialAccountRef extends EntityRef {

  private @Valid AccountBalance accountBalance;
}