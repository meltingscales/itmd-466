package org.henrypost.itm466.model

import java.util.*
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Message {

    var id: Long? = null
    var message: String? = null
    var author: String? = null
    var created: Date? = null

    constructor() {

    }


    constructor(_id: Long, _message: String, _author: String) {
        this.id = _id
        this.message = _message
        this.author = _author
        created = Date()
    }

    constructor(_id: Long, _message: String, _author: String, _created: Date) {
        this.id = _id
        this.message = _message
        this.author = _author
        created = _created
    }

}
