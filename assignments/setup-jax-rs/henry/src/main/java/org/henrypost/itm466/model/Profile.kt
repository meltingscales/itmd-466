package org.henrypost.itm466.model

import java.util.*
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Profile {

    var id: Long? = null
    var profileName: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var created: Date? = null

    constructor() {

    }

    constructor(_id: Long, _profileName: String, _firstName: String, _lastName: String) {
        id = _id
        profileName = _profileName
        firstName = _firstName
        lastName = _lastName
        created = Date()
    }

}