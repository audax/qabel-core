package de.qabel.core.repository

import de.qabel.core.config.Contact
import de.qabel.core.config.Identity
import de.qabel.core.repository.entities.ChatDropMessage
import de.qabel.core.repository.framework.Repository
import de.qabel.core.repository.framework.PagingResult

interface ChatDropMessageRepository : Repository<ChatDropMessage> {

    fun findByContact(contactId: Int, identityId: Int): List<ChatDropMessage>

    open fun findNew(identityId: Int): List<ChatDropMessage>
    open fun findLatest(identityId: Int): List<ChatDropMessage>

    fun exists(chatDropMessage : ChatDropMessage): Boolean

    open fun markAsRead(contact: Contact, identity: Identity)
    open fun findByContact(contactId: Int, identityId: Int, offset: Int, pageSize: Int): PagingResult<ChatDropMessage>
}
