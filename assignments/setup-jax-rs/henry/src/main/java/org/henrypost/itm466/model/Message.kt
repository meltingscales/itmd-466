package org.henrypost.itm466.model

import java.util.*
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Message {

    var id: Long = 0
    var message: String? = null
    var author: String? = null
    var created: Date? = null

    constructor() {

    }

    constructor(_id: Long, _message: String, _author: String) {
        id = _id
        message = _message
        author = _author
        created = Date()
    }

    constructor(_id: Long, _message: String, _author: String, _created: Date) {
        id = _id
        message = _message
        author = _author
        created = _created
    }
}
