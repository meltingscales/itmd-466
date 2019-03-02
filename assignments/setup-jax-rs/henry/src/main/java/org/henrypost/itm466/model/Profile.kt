package org.henrypost.itm466.model

import java.util.*

class Profile(_id: Long, _profileName: String, _firstName: String, _lastName: String) {

    private var id: Long = _id
    private var profileName: String? = _profileName
    private var firstName: String? = _firstName
    private var lastName: String? = _lastName
    private var created: Date? = null

    init {
        created = Date()
    }

}