package org.henrypost.itm466.model

import java.util.*
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@XmlRootElement
class Message {

    var id: Long? = null
    var message: String? = null
    var author: String? = null
    var created: Date? = null
    private var comments: Map<Long, Comment> = HashMap()
    var links: List<Link> = ArrayList()

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

    @XmlTransient
    public fun getComments(): Map<Long, Comment> {
        return comments
    }

    public fun setComments(comments: Map<Long, Comment>) {
        this.comments = comments
    }

    public fun addLink(url: String, rel: String) {
        val link = Link()
        link.link = url
        link.rel = rel
        links += link
    }

}
